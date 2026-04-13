import docx
from docx.document import Document
from docx.oxml.table import CT_Tbl
from docx.oxml.text.paragraph import CT_P
from docx.table import _Cell, Table
from docx.text.paragraph import Paragraph

doc = docx.Document('doc/CBP-MP-VN-SD系統設計文件-06.利率議價-v0.01.docx')

count_p = 0
count_t = 0
for element in doc.element.body:
    if isinstance(element, CT_P):
        count_p += 1
    elif isinstance(element, CT_Tbl):
        count_t += 1

print(f"Total paragraphs: {count_p}, Total tables: {count_t}")
