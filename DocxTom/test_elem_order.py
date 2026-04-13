import docx

doc = docx.Document('doc/CBP-MP-VN-SD系統設計文件-06.利率議價-v0.01.docx')

for element in doc.element.body:
    if element.tag.endswith('p'):
        text = "".join(node.text for node in element.xpath('.//w:t') if node.text)
        if '［是否確認操作］為Y，則於交易完成後更新' in text or '若輸入的［是否為分行］＝Y' in text:
            print(f"PARAGRAPH: {text}")
    elif element.tag.endswith('tbl'):
        # extract text from first cell
        texts = element.xpath('.//w:t')
        if texts:
            print(f"TABLE FIRST TEXT: {texts[0].text}")
