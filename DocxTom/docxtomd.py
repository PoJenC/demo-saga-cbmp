import docx
import re
import os

import zipfile
import lxml.etree as ET
from docx.oxml.table import CT_Tbl
from docx.oxml.text.paragraph import CT_P
from docx.table import Table, _Cell
from docx.text.paragraph import Paragraph

def create_numbering_map(file_path):
    num_map = {}
    ns = {'w': 'http://schemas.openxmlformats.org/wordprocessingml/2006/main'}
    try:
        with zipfile.ZipFile(file_path) as docx_zip:
            if 'word/numbering.xml' not in docx_zip.namelist():
                return num_map
                
            xml_content = docx_zip.read('word/numbering.xml')
            root = ET.fromstring(xml_content)
            
            abstract_nums = {}
            for anum in root.xpath('.//w:abstractNum', namespaces=ns):
                anum_id = anum.get(f"{{{ns['w']}}}abstractNumId")
                levels = {}
                for lvl in anum.xpath('.//w:lvl', namespaces=ns):
                    ilvl = lvl.get(f"{{{ns['w']}}}ilvl")
                    
                    numfmt_elem = lvl.xpath('.//w:numFmt', namespaces=ns)
                    numfmt = numfmt_elem[0].get(f"{{{ns['w']}}}val") if numfmt_elem else 'decimal'
                    
                    ind_elem = lvl.xpath('.//w:pPr/w:ind', namespaces=ns)
                    try:
                        left_val = int(ind_elem[0].get(f"{{{ns['w']}}}left")) if ind_elem else 0
                    except:
                        left_val = 0

                    start_elem = lvl.xpath('.//w:start', namespaces=ns)
                    try:
                        start_val = int(start_elem[0].get(f"{{{ns['w']}}}val")) if start_elem else 1
                    except:
                        start_val = 1
                        
                    levels[int(ilvl)] = {'fmt': numfmt, 'start': start_val, 'left': left_val}
                    
                abstract_nums[anum_id] = levels
                
                for num in root.xpath('.//w:num', namespaces=ns):
                    num_id = num.get(f"{{{ns['w']}}}numId")
                    abstract_id_elem = num.xpath('.//w:abstractNumId', namespaces=ns)
                    abstract_id = abstract_id_elem[0].get(f"{{{ns['w']}}}val") if abstract_id_elem else None
                    if abstract_id in abstract_nums:
                        num_map[int(num_id)] = abstract_nums[abstract_id]
                        
            # Dynamically infer base_left and step_size using ilvl mode
            import statistics
            ilvl_0_twips = []
            ilvl_1_twips = []
            for anum in abstract_nums.values():
                if 0 in anum and anum[0]['left'] > 0:
                    ilvl_0_twips.append(anum[0]['left'])
                if 1 in anum and anum[1]['left'] > 0:
                    ilvl_1_twips.append(anum[1]['left'])
                    
            base_left = 1560
            step_size = 480
            
            if ilvl_0_twips:
                try:
                    base_left = statistics.mode(ilvl_0_twips)
                except statistics.StatisticsError:
                    base_left = ilvl_0_twips[0]
                    
            if ilvl_1_twips:
                try:
                    mode_1 = statistics.mode(ilvl_1_twips)
                except statistics.StatisticsError:
                    mode_1 = ilvl_1_twips[0]
                if mode_1 > base_left:
                    step_size = mode_1 - base_left
                    if step_size < 100: step_size = 480 # Fallback
            
            num_map['__metadata__'] = {'base_left': base_left, 'step_size': step_size}
            
    except Exception as e:
        print(f"Numbering parsing error: {e}")
        
    return num_map

def format_bullet(val, fmt):
    if fmt == 'upperLetter':
        return f"{chr(64 + val)}." if val <= 26 else f"{val}."
    elif fmt == 'lowerLetter':
        return f"{chr(96 + val)}." if val <= 26 else f"{val}."
    elif fmt == 'upperRoman':
        romans = {1: 'I', 2: 'II', 3: 'III', 4: 'IV', 5: 'V', 6: 'VI', 7: 'VII', 8: 'VIII', 9: 'IX', 10: 'X'}
        return f"{romans.get(val, val)}."
    elif fmt == 'lowerRoman':
        romans = {1: 'i', 2: 'ii', 3: 'iii', 4: 'iv', 5: 'v', 6: 'vi', 7: 'vii', 8: 'viii', 9: 'ix', 10: 'x'}
        return f"{romans.get(val, val)}."
    else: # decimal, etc.
        return f"{val}."

def process_table(table):
    lines = []
    
    # Find max columns to avoid broken markdown tables (due to colspans/merged headers)
    max_cols = 0
    for row in table.rows:
        if len(row.cells) > max_cols:
            max_cols = len(row.cells)
            
    # Process rows
    for i, row in enumerate(table.rows):
        row_data = []
        for cell in row.cells:
            # Cleanup newline to markdown breaks and escape pipes
            cell_text = cell.text.strip().replace('\n', '<br>').replace('|', '\\|')
            row_data.append(cell_text)
            
        # Pad row to match max columns
        while len(row_data) < max_cols:
            row_data.append("")
            
        lines.append("| " + " | ".join(row_data) + " |")
        
        # Add markdown header separator after first row
        if i == 0:
            lines.append("|" + "|".join(["---"] * max_cols) + "|")
            
    return lines

def process_and_split_docx(file_path, output_dir="output"):
    doc = docx.Document(file_path)
    if not os.path.exists(output_dir):
        os.makedirs(output_dir)
        
    # Build dynamic numbering map from XML
    num_map = create_numbering_map(file_path)
    
    # State tracking: numId -> array of counters [0, 0, 0...]
    active_lists = {}
    heading_counters = [0, 0, 0, 0, 0] # Track level 1-4
    current_indent_stack = []
    
    # Table extraction
    table_registry = []  # (anchor_id, label, table_lines)
    table_counter = 0
    last_text = ""
    
    current_chapter_title = "Untitled"
    current_lines = []
    chapter_index = 0
    
    def save_chapter():
        if current_lines:
            safe_title = re.sub(r'[\\/*?:"<>|]', "", current_chapter_title).strip()
            if not safe_title:
                safe_title = f"Chapter_{chapter_index}"
            filename = os.path.join(output_dir, f"{safe_title}.md")
            
            with open(filename, 'w', encoding='utf-8') as f:
                f.write("\n\n".join(current_lines))
            print(f"Saved: {filename}")
            current_lines.clear()

    for element in doc.element.body:
        if isinstance(element, CT_Tbl):
            table = Table(element, doc)
            table_lines = process_table(table)
            
            # Register table and emit a hyperlink instead of inline table
            table_counter += 1
            anchor = f"table-{table_counter}"
            # Use the preceding paragraph as label only if it starts with 表格
            label = last_text if re.match(r'^(表格|TABLE|Table)\s', last_text) else f"表 {table_counter}"
            table_registry.append((anchor, label, table_lines))
            
            # Emit link; indent to match current list level
            if current_indent_stack:
                visual_level = len(current_indent_stack)
                ind = "    " * visual_level
            else:
                ind = ""
            current_lines.append(f"{ind}> 📋 [**{label}**](./tables.md#{anchor})")
            # DO NOT clear active_lists or current_indent_stack so sequence is not broken
            continue
            
        if not isinstance(element, CT_P):
            continue
            
        p = Paragraph(element, doc)    
        text = p.text.strip()
        if not text:
            continue
            
        style_name = p.style.name
        
        # Look for explicit XML list assignments
        p_element = p._element
        numPr = p_element.xpath('.//w:numPr')
        ilvl = None
        numId = None
        if len(numPr) > 0:
            ilvl_element = numPr[0].xpath('.//w:ilvl')
            numId_element = numPr[0].xpath('.//w:numId')
            if len(ilvl_element) > 0:
                val = ilvl_element[0].get('{http://schemas.openxmlformats.org/wordprocessingml/2006/main}val')
                if val is not None:
                    ilvl = int(val)
            if len(numId_element) > 0:
                val = numId_element[0].get('{http://schemas.openxmlformats.org/wordprocessingml/2006/main}val')
                if val is not None:
                    numId = int(val)
                
        is_h1 = False
        level = None
        is_list = False
        list_level = 0
        
        if '第一層標題' in style_name:
            level = 1
            is_h1 = True
        elif '第二層標題' in style_name:
            level = 2
        elif '第三層標題' in style_name:
            level = 3
        elif '第四層標題' in style_name:
            if ilvl is None:
                level = 4
            else:
                is_list = True
                list_level = ilvl
        
        # Fallbacks
        if level is None and not is_list:
            if style_name.startswith('Heading'):
                try:
                    level = int(style_name.split()[-1])
                    if level == 1:
                        is_h1 = True
                except ValueError:
                    level = 1
                    is_h1 = True
            elif re.match(r'^(第一章|第[\u4e00-\u9fa50-9]+章)\s*、?', text):
                level = 1
                is_h1 = True
            elif re.match(r'^\d+\.\d+(\.\d+)*\s+', text):
                level = text.split()[0].count('.') + 1

        if not is_list:
            if style_name.startswith('List Number') and numId is None:
                is_list = True
                parts = style_name.split()
                list_level = int(parts[-1]) - 1 if len(parts) > 2 and parts[-1].isdigit() else 0
                numId = -1 # Shared fallback list
            elif ilvl is not None and numId is not None:
                is_list = True
                list_level = ilvl

        # Restore numeric headings
        heading_prefix = ""
        if level is not None and not is_list:
            if level <= 4:
                heading_counters[level] += 1
                for i in range(level + 1, 5):
                    heading_counters[i] = 0
                
                if level == 1:
                    heading_prefix = f"{heading_counters[1]}. "
                elif level == 2:
                    heading_prefix = f"{heading_counters[1]}.{heading_counters[2]} "
                elif level == 3:
                    heading_prefix = f"{heading_counters[1]}.{heading_counters[2]}.{heading_counters[3]} "
                elif level == 4:
                    heading_prefix = f"{heading_counters[1]}.{heading_counters[2]}.{heading_counters[3]}.{heading_counters[4]} "

        # Split file at level 2 ("n.n") or any level 1
        if level == 2 or is_h1:
            save_chapter() 
            chapter_index += 1
            current_chapter_title = f"{heading_prefix}{text}".strip()
            # active_lists could be cleared on file boundary if needed
            active_lists.clear()
            current_indent_stack = []

        if level is not None and not is_list:
            current_lines.append(f"{'#' * level} {heading_prefix}{text}")
            continue
        
        left_twips = 0        
        if is_list:
            if numId not in active_lists:
                active_lists[numId] = {}
            if list_level not in active_lists[numId]:
                active_lists[numId][list_level] = 0
            
            ind_elem = p_element.xpath('.//w:ind')
            explicit_left = int(ind_elem[0].get('{http://schemas.openxmlformats.org/wordprocessingml/2006/main}left')) if ind_elem and ind_elem[0].get('{http://schemas.openxmlformats.org/wordprocessingml/2006/main}left') else None
            
            if explicit_left is not None:
                left_twips = explicit_left
            elif numId in num_map and list_level in num_map[numId]:
                left_twips = num_map[numId][list_level].get('left', 0)
            
            if left_twips > 0:
                while current_indent_stack and current_indent_stack[-1] > left_twips:
                    current_indent_stack.pop()
                    
                if not current_indent_stack or current_indent_stack[-1] < left_twips:
                    current_indent_stack.append(left_twips)
                    
                visual_level = current_indent_stack.index(left_twips)
                indent = "    " * visual_level
            else:
                indent = "    " * list_level
            
            fmt = 'decimal'
            val = active_lists[numId][list_level]
            
            if numId in num_map and list_level in num_map[numId]:
                fmt = num_map[numId][list_level]['fmt']
                if val == 0:
                    val = num_map[numId][list_level]['start'] - 1
            
            active_lists[numId][list_level] = val + 1
            
            # Reset sub-levels
            for i in range(list_level + 1, 10):
                if i in active_lists[numId]:
                    active_lists[numId][i] = 0
                    
            val = active_lists[numId][list_level]
            bullet = format_bullet(val, fmt)
            
            # Use standard markdown bullet and bold the visual counter to avoid code block parsing
            current_lines.append(f"{indent}- **{bullet}** {text}")
        else:
            current_lines.append(text)
        
        last_text = text
            
    save_chapter()
    
    # Write all collected tables to a single tables.md
    if table_registry:
        tables_path = os.path.join(output_dir, "tables.md")
        with open(tables_path, 'w', encoding='utf-8') as f:
            f.write("# 表格索引\n\n")
            for anchor, label, tbl_lines in table_registry:
                f.write(f'<a name="{anchor}"></a>\n\n')
                f.write(f"### {label}\n\n")
                f.write("\n".join(tbl_lines))
                f.write("\n\n---\n\n")
        print(f"Saved: {tables_path}")

if __name__ == '__main__':
    import sys
    file_to_parse = sys.argv[1] if len(sys.argv) > 1 else 'mock_test.docx'
    print(f"Starting to parse and split: {file_to_parse}")
    process_and_split_docx(file_to_parse)
    print("Done!")
