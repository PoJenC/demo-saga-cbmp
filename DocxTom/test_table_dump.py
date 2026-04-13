import docx
from docx.oxml.table import CT_Tbl
from docx.table import Table

doc = docx.Document('doc/CBP-MP-VN-SD系統設計文件-06.利率議價-v0.01.docx')

for element in doc.element.body:
    if isinstance(element, CT_Tbl):
        table = Table(element, doc)
        for i, row in enumerate(table.rows):
            texts = [c.text.replace('\n', ' ') for c in row.cells]
            print(f"Row {i}: {texts[:2]}...")
        break # just check the first table
