import docx
from docx.oxml.table import CT_Tbl
from docx.table import Table

doc = docx.Document('doc/CBP-MP-VN-SD系統設計文件-06.利率議價-v0.01.docx')

for t_idx, element in enumerate(doc.element.body):
    if isinstance(element, CT_Tbl):
        table = Table(element, doc)
        cell_counts = [len(row.cells) for row in table.rows]
        if len(set(cell_counts)) > 1:
            print(f"Table {t_idx} has mismatched column counts: {cell_counts}")
