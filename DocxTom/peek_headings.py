import docx
doc = docx.Document('doc/CBP-MP-VN-SD系統設計文件-06.利率議價-v0.01.docx')
for p in doc.paragraphs:
    if '第一層標題' in p.style.name or '第二層標題' in p.style.name or '第三層標題' in p.style.name:
        print(f"Style: {p.style.name}, Text: '{p.text}'")
