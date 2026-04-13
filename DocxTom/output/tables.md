# 表格索引

<a name="table-1"></a>

### 表 1

| 文件名稱 | 銀行核心現代化計畫－系統整合及計畫管理專業服務建置案<br>SD文件-06(利率議價) | 銀行核心現代化計畫－系統整合及計畫管理專業服務建置案<br>SD文件-06(利率議價) | 銀行核心現代化計畫－系統整合及計畫管理專業服務建置案<br>SD文件-06(利率議價) |
|---|---|---|---|
| 修訂日期 | 版本編號 | 主要修訂摘要 | 作者 |
| 2026/03/27 | v0.01 | 初稿 | IBM |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |

---

<a name="table-2"></a>

### 表 2

| 關係人限額組件-檢核利害關係人身份(規格請參考1.1.1.4.II.i) | 關係人限額組件-檢核利害關係人身份(規格請參考1.1.1.4.II.i) |
|---|---|
| Request | 客戶識別號、建檔國家代碼＝VN（越南） |
| Response | 是否為利害關係人、金控關係人類型 |

---

<a name="table-3"></a>

### 表 3

| MIM-87 Get latest Interest rate(規格請參考1.1.1.4.II.ii) | MIM-87 Get latest Interest rate(規格請參考1.1.1.4.II.ii) |
|---|---|
| Request | 幣別、日期、利率代碼、期間單位、期間值 |
| Response | 利率查詢結果(FTP利率) |

---

<a name="table-4"></a>

### 表 4

| BBP-45 Get a specific Configurable Parameter record(規格請參考1.1.1.4.II.iii) | BBP-45 Get a specific Configurable Parameter record(規格請參考1.1.1.4.II.iii) |
|---|---|
| Request | 查詢參數（parameter=126 base currency）、applicability=4、applicability-entity=GBANKOU001 |
| Response | 基幣幣別 |

---

<a name="table-5"></a>

### 表 5

| MIM-21 Fetch exchange rates for a given date(規格請參考1.1.1.4.II.iv) | MIM-21 Fetch exchange rates for a given date(規格請參考1.1.1.4.II.iv) |
|---|---|
| Request | 輸入幣別、參數幣別（基幣）、日期、時間、匯率類型=即期成本 |
| Response | 匯率中價 |

---

<a name="table-6"></a>

### 表 6

| MIM 交叉幣別試算API（以 GBP 最終實作為準）(規格請參考1.1.1.4.II.v) | MIM 交叉幣別試算API（以 GBP 最終實作為準）(規格請參考1.1.1.4.II.v) |
|---|---|
| Request | 買賣別＝S、交易幣別＝輸入幣別、交易金額＝承作金額、對方幣別＝參數幣別（基幣）、匯率類型-成本＝中價 |
| Response | 報價金額 |

---

<a name="table-7"></a>

### 表 7

| BBP-45 Get a specific Configurable Parameter record(規格請參考1.1.1.4.II.iii) | BBP-45 Get a specific Configurable Parameter record(規格請參考1.1.1.4.II.iii) |
|---|---|
| Request | 查詢參數（parameter=126 base currency）、applicability=4、applicability-entity=GBANKOU001 |
| Response | 基幣幣別 |

---

<a name="table-8"></a>

### 表 8

| MIM-21 Fetch exchange rates for a given date(規格請參考1.1.1.4.II.iv) | MIM-21 Fetch exchange rates for a given date(規格請參考1.1.1.4.II.iv) |
|---|---|
| Request | 輸入幣別、參數幣別（基幣）、日期、時間、匯率類型=即期成本 |
| Response | 匯率中價 |

---

<a name="table-9"></a>

### 表 9

| MIM 交叉幣別試算API（以 GBP 最終實作為準）(規格請參考1.1.1.4.II.v) | MIM 交叉幣別試算API（以 GBP 最終實作為準）(規格請參考1.1.1.4.II.v) |
|---|---|
| Request | 買賣別＝S、交易幣別＝輸入幣別、交易金額＝承作金額、對方幣別＝參數幣別（基幣）、匯率類型-成本＝中價 |
| Response | 報價金額 |

---

<a name="table-10"></a>

### 表 10

| BBP-45 Get a specific Configurable Parameter record(規格請參考1.1.1.4.II.iii) | BBP-45 Get a specific Configurable Parameter record(規格請參考1.1.1.4.II.iii) |
|---|---|
| Request | 查詢參數（parameter=126 base currency）、applicability=4、applicability-entity=GBANKOU001 |
| Response | 基幣幣別 |

---

<a name="table-11"></a>

### 表 11

| MIM-21 Fetch exchange rates for a given date(規格請參考1.1.1.4.II.iv) | MIM-21 Fetch exchange rates for a given date(規格請參考1.1.1.4.II.iv) |
|---|---|
| Request | 輸入幣別、參數幣別（基幣）、日期、時間、匯率類型=即期成本 |
| Response | 匯率中價 |

---

<a name="table-12"></a>

### 表 12

| MIM 交叉幣別試算API（以 GBP 最終實作為準）(規格請參考1.1.1.4.II.v) | MIM 交叉幣別試算API（以 GBP 最終實作為準）(規格請參考1.1.1.4.II.v) |
|---|---|
| Request | 買賣別＝S、交易幣別＝輸入幣別、交易金額＝承作金額、對方幣別＝參數幣別（基幣）、匯率類型-成本＝中價 |
| Response | 報價金額 |

---

<a name="table-13"></a>

### 表格 1.1.1.3.1 異動的資料表

| 資料表英文名稱 | 資料表中文名稱 | 操作類型 | 說明 |
|---|---|---|---|
| tb_deposit_interest_contract | 利率議價主檔 | INSERT | 建立新的利率議價合約 |
| tb_customer_branch_setting | 客戶及分行參數檔 | SELECT | 查詢分行權限相關參數 |
| tb_ftp_range_setting | 加減碼參數檔 | SELECT | 查詢FTP利率加減碼範圍 |
| tb_max_interest_setting | 利率上限參數檔 | SELECT | 查詢各幣別最高承作利率上限 |
| tb_deposit_interest_contract | 利率議價主檔 | SELECT | 查詢合約基幣承作金額資料 |

---

<a name="table-14"></a>

### 表格 1.1.1.3.2 建立新的利率議價合約tb_deposit_interest_contract (Insert)

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| contract_no | 系統生成 | 議價編號 | VARCHAR(16), 格式：YYYYMMDD+IR+4碼流水號 |
| transaction_date | 系統日 | 訂約日期 | DATE, 系統日期 |
| value_date | Request: valueDate | 起息日期 | DATE, 定存必填 |
| expire_date | Request: expireDate | 到期日期 | DATE |
| branch_class | Request: branchClass \| Default: DBU | 分行類型 | VARCHAR(6), 預設DBU |
| branch_code | Request: branchCode | 分行代碼 | VARCHAR(4) |
| bsn_unit | Request: bsnUnit | 績效行 | VARCHAR(4) |
| customer_reference_no | Request: customerReferenceNo | 客戶識別號 | VARCHAR(35) |
| is_stakeholder | 關係人組件 API Response: cfhStakeholderType等於1時為Y；否則為N | 是否為金控利害關係人 | VARCHAR(1), Y/N， |
| product_reference | Request: productReference | 產品別 | DECIMAL(10) |
| currency | Request: currency | 幣別 | VARCHAR(3), ISO 4217標準 |
| interest_type | Request: interestType | 利率別 | DECIMAL(3) |
| period_unit_1 | Request: periodUnit1 | 期間單位1 | DECIMAL(3) |
| period_value_1 | Request: periodValue1 | 期間值1 | DECIMAL(6) |
| period_unit_2 | Request: periodUnit2 | 期間單位2 | DECIMAL(3) |
| period_value_2 | Request: periodValue2 | 期間值2 | DECIMAL(6) |
| ftp_rate | Request: ftpRate | FTP利率 | DECIMAL(11,7) |
| dealing_rate | Request: dealingRate | 承作利率 | DECIMAL(11,7) |
| dealing_amount | Request: dealingAmount \| 0 (活存) | 承作金額 | DECIMAL(24,7), 活存寫入0 |
| equ_amount | Request: dealingAmount(合約幣別為基幣) \| 換為基幣的金額(合約幣別不為基幣) | 等值基幣金額 | DECIMAL(24,7)，<br>若合約輸入的［幣別］為基幣，則與［承作金額］相同。<br>若合約輸入的［幣別］不為基幣，則為前述處理流程中，換為基幣的金額 |
| remarks | Request: remark | 註記 | VARCHAR(80) |
| userid_op | Request: userIdOp | 交易櫃員 | VARCHAR(35) |
| userid_verify | NULL | 覆核主管 | VARCHAR(35), 初始為空 |
| datetime_verify | NULL | 覆核日期 | TIMESTAMP, 初始為空, UTC格式 |
| contract_status | Default: SUBMIT | 合約狀態 | VARCHAR(10), 預設SUBMIT (未覆核) |
| contract_type | Request: contractType | 合約類型 | VARCHAR(3), TDM/DDA |

---

<a name="table-15"></a>

### 表格 1.1.1.3.3 查詢分行權限相關參數tb_customer_branch_setting (Select)

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| 查詢條件 | 查詢條件 | 查詢條件 | 查詢條件 |
| currency | Request: currency | 幣別 | VARCHAR(3)，<br>運算子：等於 |
| 查詢結果 | 查詢結果 | 查詢結果 | 查詢結果 |
| - | customer_daily_max | 客戶額度金額上限 | DECIMAL(24,7), 用於當日累積檢核 |
| - | branch_single_max | 分行單筆承作上限 | DECIMAL(24,7),用於單筆金額檢核 |
| - | branch_daily_max | 分行當日承作上限 | DECIMAL(24,7),用於分行當日累積檢核 |

---

<a name="table-16"></a>

### 表格 1.1.1.3.4 查詢FTP利率加減碼範圍 tb_ftp_range_setting (Select)

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| 查詢條件 | 查詢條件 | 查詢條件 | 查詢條件 |
| currency | Request: currency | 幣別 | VARCHAR(3) ，<br>運算子：等於 |
| 查詢結果 | 查詢結果 | 查詢結果 | 查詢結果 |
| - | ftp_sub_max | FTP利率減碼下限 | DECIMAL(11,7), FTP利率可減碼範圍 |
| - | ftp_add_max | FTP利率加碼上限 | DECIMAL(11,7), FTP利率可加碼範圍 |

---

<a name="table-17"></a>

### 表格 1.1.1.3.5 查詢各幣別最高承作利率上限tb_max_interest_setting (Select)

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| 查詢條件 | 查詢條件 | 查詢條件 | 查詢條件 |
| currency | Request: currency | 幣別 | 必填，<br>運算子：等於 |
| period_unit | Request: periodUnit1\|空值(活存) | 期間單位 | 運算子：等於 |
| period_value_min | Request: periodValue1\|空值(活存) | 期間值下限 | 運算子：大於等於 |
| period_value_max | Request: periodValue1\|空值(活存) | 期間值上限 | 運算子：小於 |
| 查詢結果 | 查詢結果 | 查詢結果 | 查詢結果 |
| - | max_rate | 最高利率 | DECIMAL(11,7), 用於承作利率上限檢核 |

---

<a name="table-18"></a>

### 表格 1.1.1.3.6 查詢合約基幣承作金額資料tb_deposit_interest_contract (Select)

| 目標欄位 | 欄位對應規則 | 說明 (Description) | 備註 (Remarks) |
|---|---|---|---|
| 查詢條件 | 查詢條件 | 查詢條件 | 查詢條件 |
| customer_reference_no | Request: customerReferenceNo | 客戶識別號 | VARCHAR(35)<br>運算子：等於 |
| transaction_date | Request: 今日日期 | 訂約日期 | Date<br>運算子：等於 |
| branch_code | Request: branchCode | 分行代碼 | VARCHAR(4)<br>運算子：等於 |
| 查詢結果 | 查詢結果 | 查詢結果 | 查詢結果 |
| - | equ_amount | 等值基幣金額 | 計算等值基幣金額加總 |

---

<a name="table-19"></a>

### 表 19

| API 代碼 | API 名稱 | 功能說明 | 目標系統 |
|---|---|---|---|
| 關係人組件 | 檢核利害關係人 | 檢核客戶是否為金控利害關係人 | 中台關係人組件 |
| MIM-87 | Get latest Interest rate | 查詢FTP利率 | GBP MIM |
| BBP-45 | Get a specific Configurable Parameter record | 查詢基幣幣別 | GBP BBP |
| MIM-21 | Fetch exchange rates for a given date | 查詢匯率進行換匯 | GBP MIM |
| MIN | 客製化 | 交叉幣別試算 | GBP MIM |

---

<a name="table-20"></a>

### 表 20

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| customerRefNo | Request: customerReferenceNo | 客戶識別號 | 必填 |
| createdCountryCode | Fixed: VN | 建檔國家代碼 | 必填 |

---

<a name="table-21"></a>

### 表 21

| 目標欄位 | 內部對應欄位 | 說明 | 備註 |
|---|---|---|---|
| - | isStakeholder | 是否為利害關係人 | Y/N |
| - | cfhStakeholderType | 金控關係人類型 | 是否為金控利害關係人，0：非金控關係人/1：金控關係人 |

---

<a name="table-22"></a>

### 表 22

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| currency | Request: currency | 幣別 | 必填 |
| for-date | 系統日期 | 查詢日期 | 必填 系統日期，格式：YYYY-MM-DD |
| rate-type | Request: interestType | 利率代碼 | 必填，此代碼待確認 |
| entity-id | Fixed: GCUBBANKIN | 實體識別碼 | 必填 |
| rate-period-freq | Request: periodUnit1 | 期間單位 | 必填 |
| rate-period-value | Request: periodValue1 | 期間值 | 必填 |

---

<a name="table-23"></a>

### 表 23

| 目標欄位 | 內部對應欄位 | 說明 (Description) | 備註 (Remarks) |
|---|---|---|---|
| - | interest-rates.rate | FTP利率 | 用於加減碼範圍檢核 |

---

<a name="table-24"></a>

### 表 24

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| parameter | Fixed:126 | 查詢參數 | 必填，基幣查詢，代表Base Currency |
| applicability | Fixed :4 | 適用性 | 必填 |
| applicability-entity | Fixed: GBANKOU001 | 適用實體 | 必填 |

---

<a name="table-25"></a>

### 表 25

| 目標欄位 | 內部對應欄位 | 說明 (Description) | 備註 (Remarks) |
|---|---|---|---|
| - | parameter | 參數代碼驗證 | 取出參數為基幣(126) |
| - | parameter-value | 基幣幣別 | 取得基幣後傳入MIM-21作為兌換幣別(MIM-21.counter-currency) |
| - | status | 參數狀態驗證 | 取出參數為Active(5) |

---

<a name="table-26"></a>

### 表 26

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| reference-currency | Request: currency | 輸入幣別（來源幣別） | 必填 |
| counter-currency | BBP-45 Response: parameter-value | 參數幣別（基幣） | 必填 |
| entity-id | Fixed: GCUBBANKIN | 實體識別碼 |  |
| rate-date | 系統日 | 匯率日期 | 格式：YYYY-MM-DD |
| rate-purpose | Fixed:即期成本(此代碼待確認) | 匯率類型 |  |
| sanity-status | Optional | 完整性狀態 | 空值 |
| rate-status | Optional | 匯率狀態 | 空值 |

---

<a name="table-27"></a>

### 表 27

| 目標欄位 | 內部對應欄位 | 說明 (Description) | 備註 (Remarks) |
|---|---|---|---|
| - | mid-Rate | 匯率中價 | 交叉幣別試算時使用 |

---

<a name="table-28"></a>

### 表 28

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
|  | Fixed:S | 買賣別 | 必填，<br>B：銀行買入/S：銀行賣出 |
|  | Request: currency | 交易幣別 | 必填 |
|  | Request: dealingAmount | 交易金額 |  |
|  | BBP-45 Response: parameter-value | 對方幣別 | 必填 |
|  | Fixed:即期 (此代碼待確認) | 匯率類型-牌告 | 必填 |
|  | Fixed:即期成本(此代碼待確認) | 匯率類型-成本 |  |
|  | 系統日 | 匯率日期 | 格式：YYYY-MM-DD |
|  | MIM-21 Response: mid-Rate | 成交匯率(交叉匯率) |  |

---

<a name="table-29"></a>

### 表 29

| 目標欄位 | 內部對應欄位 | 說明 (Description) | 備註 (Remarks) |
|---|---|---|---|
| - |  | 對方金額 |  |

---

<a name="table-30"></a>

### 表格 1.1.2.3.1 異動的資料表

| 資料表英文名稱 | 資料表中文名稱 | 操作類型 | 說明 |
|---|---|---|---|
| tb_deposit_interest_contract | 利率議價主檔 | SELECT | 查詢合約狀態檢核 |
| tb_deposit_interest_contract | 利率議價主檔 | UPDATE | 更新合約狀態 |
| tb_deposit_interest_quota_usage | 利率議價額度使用明細檔 | SELECT | 查詢合約使用狀況（刪除時） |

---

<a name="table-31"></a>

### 表格 1.1.2.3.2 查詢合約狀態檢核tb_deposit_interest_contract (Select)

| 目標欄位 | 欄位對應規則 | 說明 (Description) | 備註 (Remarks) |
|---|---|---|---|
| 查詢條件 | 查詢條件 | 查詢條件 | 查詢條件 |
| contract_no | Request: contractNo | 議價編號 | VARCHAR(16)，<br>運算子：等於 |
| 查詢結果 | 查詢結果 | 查詢結果 | 查詢結果 |
| - | contract_status | 合約狀態 | VARCHAR(10)，<br>用於判斷合約狀態是否可更新 |

---

<a name="table-32"></a>

### 表格 1.1.2.3.3 更新合約狀態tb_deposit_interest_contract (Update)

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| 更新條件 | 更新條件 | 更新條件 | 更新條件 |
| contract_no | Request: contractNo | 議價編號 | VARCHAR(16)，<br>運算子：等於 |
| 更新欄位 | 更新欄位 | 更新欄位 | 更新欄位 |
| contract_status | Request: contractStatus | 合約狀態 | VARCHAR(10), APPROVE/CANCEL/DELETE |
| userid_verify | Request: userIdVerify | 覆核主管 | VARCHAR(35), 狀態=APPROVE時更新 |
| datetime_verify | Request: datetimeVerify | 覆核日期 | TIMESTAMP, 狀態=APPROVE時更新, UTC格式 |

---

<a name="table-33"></a>

### 表 33

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| 查詢條件 | 查詢條件 | 查詢條件 | 查詢條件 |
| contract_no | Request: contractNo | 議價編號 | VARCHAR(16) ，<br>運算子：等於 |
| quota_transaction_status | Fixed: ACTUAL | 明細狀態 | VARCHAR(7), 檢核是否有實佔記錄 |
| 查詢結果 | 查詢結果 | 查詢結果 | 查詢結果 |
| - | * | 利率議價額度使用明細檔實佔內容 | 判斷是否有實佔記錄 |

---

<a name="table-34"></a>

### 表 34

| 關係人限額組件-檢核利害關係人身份(規格請參考1.1.3.4.II.i) | 關係人限額組件-檢核利害關係人身份(規格請參考1.1.3.4.II.i) |  |
|---|---|---|
| Request | 客戶識別號、建檔國家代碼＝VN（越南） | 客戶識別號、建檔國家代碼＝VN（越南） |
| Response | 是否為利害關係人、金控關係人類型 | 是否為利害關係人、金控關係人類型 |

---

<a name="table-35"></a>

### 表 35

| MIM-87 Get latest Interest rate(規格請參考1.1.3.4.II.ii) | MIM-87 Get latest Interest rate(規格請參考1.1.3.4.II.ii) |
|---|---|
| Request | 幣別、日期、利率代碼、期間單位、期間值 |
| Response | 利率查詢結果(FTP利率) |

---

<a name="table-36"></a>

### 表 36

| BBP-45 Get a specific Configurable Parameter record(規格請參考1.1.3.4.II.iii) | BBP-45 Get a specific Configurable Parameter record(規格請參考1.1.3.4.II.iii) |
|---|---|
| Request | 查詢參數（parameter=126 base currency）、applicability=4、applicability-entity=GBANKOU001 |
| Response | 基幣幣別 |

---

<a name="table-37"></a>

### 表 37

| MIM-21 Fetch exchange rates for a given date(規格請參考1.1.3.4.II.iv) | MIM-21 Fetch exchange rates for a given date(規格請參考1.1.3.4.II.iv) |
|---|---|
| Request | 輸入幣別、參數幣別（基幣）、日期、時間、匯率類型=即期成本 |
| Response | 匯率中價 |

---

<a name="table-38"></a>

### 表 38

| MIM 交叉幣別試算API（以 GBP 最終實作為準）(規格請參考1.1.3.4.II.v) | MIM 交叉幣別試算API（以 GBP 最終實作為準）(規格請參考1.1.3.4.II.v) |
|---|---|
| Request | 買賣別＝S、交易幣別＝輸入幣別、交易金額＝承作金額、對方幣別＝參數幣別（基幣）、匯率類型-成本＝中價 |
| Response | 報價金額 |

---

<a name="table-39"></a>

### 表 39

| BBP-45 Get a specific Configurable Parameter record(規格請參考1.1.3.4.II.iii) | BBP-45 Get a specific Configurable Parameter record(規格請參考1.1.3.4.II.iii) |
|---|---|
| Request | 查詢參數（parameter=126 base currency）、applicability=4、applicability-entity=GBANKOU001 |
| Response | 基幣幣別 |

---

<a name="table-40"></a>

### 表 40

| MIM-21 Fetch exchange rates for a given date(規格請參考1.1.3.4.II.iv) | MIM-21 Fetch exchange rates for a given date(規格請參考1.1.3.4.II.iv) |
|---|---|
| Request | 輸入幣別、參數幣別（基幣）、日期、時間、匯率類型=即期成本 |
| Response | 匯率中價 |

---

<a name="table-41"></a>

### 表 41

| MIM 交叉幣別試算API（以 GBP 最終實作為準）(規格請參考1.1.3.4.II.v) | MIM 交叉幣別試算API（以 GBP 最終實作為準）(規格請參考1.1.3.4.II.v) |
|---|---|
| Request | 買賣別＝S、交易幣別＝輸入幣別、交易金額＝承作金額、對方幣別＝參數幣別（基幣）、匯率類型-成本＝中價 |
| Response | 報價金額 |

---

<a name="table-42"></a>

### 表 42

| BBP-45 Get a specific Configurable Parameter record(規格請參考1.1.3.4.II.iii) | BBP-45 Get a specific Configurable Parameter record(規格請參考1.1.3.4.II.iii) |
|---|---|
| Request | 查詢參數（parameter=126 base currency）、applicability=4、applicability-entity=GBANKOU001 |
| Response | 基幣幣別 |

---

<a name="table-43"></a>

### 表 43

| MIM-21 Fetch exchange rates for a given date(規格請參考1.1.3.4.II.iv) | MIM-21 Fetch exchange rates for a given date(規格請參考1.1.3.4.II.iv) |
|---|---|
| Request | 輸入幣別、參數幣別（基幣）、日期、時間、匯率類型=即期成本 |
| Response | 匯率中價 |

---

<a name="table-44"></a>

### 表 44

| MIM 交叉幣別試算API（以 GBP 最終實作為準）(規格請參考1.1.3.4.II.v) | MIM 交叉幣別試算API（以 GBP 最終實作為準）(規格請參考1.1.3.4.II.v) |
|---|---|
| Request | 買賣別＝S、交易幣別＝輸入幣別、交易金額＝承作金額、對方幣別＝參數幣別（基幣）、匯率類型-成本＝中價 |
| Response | 報價金額 |

---

<a name="table-45"></a>

### 表格 1.1.3.3.1 異動的資料表

| 資料表英文名稱 | 資料表中文名稱 | 操作類型 | 說明 |
|---|---|---|---|
| Tb_deposit_interest_contract | 利率議價主檔 | SELECT | 查詢原合約資料 |
| Tb_deposit_interest_contract | 利率議價主檔 | UPDATE | 更新合約內容 |
| Tb_deposit_interest_quota_usage | 利率議價額度使用明細檔 | SELECT | 檢核合約是否已使用 |
| Tb_customer_branch_setting | 客戶及分行參數檔 | SELECT | 查詢客戶與分行承作上限參數 |
| Tb_ftp_range_setting | 加減碼參數檔 | SELECT | 查詢FTP利率加減碼範圍參數 |
| Tb_max_interest_setting | 利率上限參數檔 | SELECT | 查詢各幣別最高承作利率上限 |

---

<a name="table-46"></a>

### 表格 1.1.3.3.2 查詢原合約資料tb_deposit_interest_contract (Select)

| 目標欄位 | 欄位對應規則 | 說明 (Description) | 備註 (Remarks) |
|---|---|---|---|
| 查詢條件 | 查詢條件 | 查詢條件 | 查詢條件 |
| contract_no | Request: contractNo | 議價編號 | VARCHAR(16)，<br>運算子：等於 |
| customer_reference_no | Request: customerReferenceNo | 客戶識別號 | VARCHAR(35)<br>運算子：等於 |
| transaction_date | Request: 今日日期 | 訂約日期 | Date<br>運算子：等於 |
| branch_code | Request: branchCode | 分行代碼 | VARCHAR(4)<br>運算子：等於 |
| 查詢結果 | 查詢結果 | 查詢結果 | 查詢結果 |
| - | * | 原合約完整內容 | 用於檢核及比對 |
| - | equ_amount | 等值基幣金額 | 計算等值基幣金額加總 |

---

<a name="table-47"></a>

### 表 47

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| 更新條件 | 更新條件 | 更新條件 | 更新條件 |
| contract_no | Request: contractNo | 議價編號 | VARCHAR(16)，<br>運算子：等於 |
| 更新欄位 | 更新欄位 | 更新欄位 | 更新欄位 |
| value_date | Request: valueDate | 起息日期 | DATE, 定存必填 |
| expire_date | Request: expireDate | 到期日期 | DATE |
| branch_class | Request: branchClass \| Default: DBU | 分行類型 | VARCHAR(6), 預設DBU |
| branch_code | Request: branchCode | 分行代碼 | VARCHAR(4) |
| bsn_unit | Request: bsnUnit | 績效行 | VARCHAR(4) |
| customer_reference_no | Request: customerReferenceNo | 客戶識別號 | VARCHAR(35) |
| is_stakeholder | 關係人組件 API Response: cfhStakeholderType等於1時為Y；否則為N | 是否為金控利害關係人 | VARCHAR(1), Y/N |
| product_reference | Request: productReference | 產品別 | DECIMAL(10) |
| currency | Request: currency | 幣別 | VARCHAR(3) |
| interest_type | Request: interestType | 利率別 | DECIMAL(3) |
| period_unit_1 | Request: periodUnit1 | 期間單位1 | DECIMAL(3) |
| period_value_1 | Request: periodValue1 | 期間值1 | DECIMAL(6) |
| period_unit_2 | Request: periodUnit2 | 期間單位2 | DECIMAL(3) |
| period_value_2 | Request: periodValue2 | 期間值2 | DECIMAL(6) |
| ftp_rate | Request: ftpRate | FTP利率 | DECIMAL(11,7) |
| dealing_rate | Request: dealingRate | 承作利率 | DECIMAL(11,7) |
| dealing_amount | Request: dealingAmount\| 0 (活存) | 承作金額 | DECIMAL(24,7) , 活存寫入0 |
| equ_amount | Request: dealingAmount(合約幣別為基幣) \| 換為基幣的金額(合約幣別不為基幣) | 等值基幣金額 | DECIMAL(24,7)，<br>若合約輸入的［幣別］為基幣，則與［承作金額］相同。<br>若合約輸入的［幣別］不為基幣，則為前述處理流程中，換為基幣的金額 |
| remarks | Request: remark | 註記 | VARCHAR(80) |
| userid_op | Request: userIdOp | 交易櫃員 | VARCHAR(35) |
| userid_verify | NULL | 覆核主管 | VARCHAR(35),清空覆核資訊 |
| datetime_verify | NULL | 覆核日期 | TIMESTAMP,清空覆核資訊 |
| contract_status | Fixed: SUBMIT | 合約狀態 | VARCHAR(10), 回復為未覆核 |
| contract_type | Request: contractType | 合約類型 | VARCHAR(3), TDM/DDA |

---

<a name="table-48"></a>

### 表格  1.1.3.3.4檢核合約是否已使用tb_deposit_interest_quota_usage (Select)

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| 查詢條件 | 查詢條件 | 查詢條件 | 查詢條件 |
| contract_no | Request: contractNo | 議價編號 | VARCHAR(16) ，<br>運算子：等於 |
| quota_transaction_status | Fixed: ACTUAL | 明細狀態 | VARCHAR(7), 檢核是否有實佔記錄 |
| 查詢結果 | 查詢結果 | 查詢結果 | 查詢結果 |
| - | * | 利率議價額度使用明細檔實佔內容 | 判斷是否有實佔記錄 |

---

<a name="table-49"></a>

### 表格  1.1.3.3.5 查詢客戶與分行承作上限參數tb_customer_branch_setting (Select)

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| 查詢條件 | 查詢條件 | 查詢條件 | 查詢條件 |
| currency | Request: currency | 幣別 | VARCHAR(3)，<br>運算子：等於 |
| 查詢結果 | 查詢結果 | 查詢結果 | 查詢結果 |
| - | customer_daily_max | 客戶額度金額上限 | DECIMAL(24,7), 用於當日累積檢核 |
| - | branch_single_max | 分行單筆承作上限 | DECIMAL(24,7),用於單筆金額檢核 |
| - | branch_daily_max | 分行當日承作上限 | DECIMAL(24,7),用於分行當日累積檢核 |

---

<a name="table-50"></a>

### 表格 1.1.3.3.6 查詢FTP利率加減碼範圍參數tb_ftp_range_setting (Select)

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| 查詢條件 | 查詢條件 | 查詢條件 | 查詢條件 |
| currency | Request: currency | 幣別 | VARCHAR(3) ，<br>運算子：等於 |
| 查詢結果 | 查詢結果 | 查詢結果 | 查詢結果 |
| - | ftp_sub_max | FTP利率減碼下限 | DECIMAL(11,7), FTP利率可減碼範圍 |
| - | ftp_add_max | FTP利率加碼上限 | DECIMAL(11,7), FTP利率可加碼範圍 |

---

<a name="table-51"></a>

### 表格  1.1.3.3.7 查詢各幣別最高承作利率上限tb_max_interest_setting (Select)

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| 查詢條件 | 查詢條件 | 查詢條件 | 查詢條件 |
| currency | Request: currency | 幣別 | 必填，<br>運算子：等於 |
| period_unit | Request: periodUnit1\|空值(活存) | 期間單位 | 運算子：等於 |
| period_value_min | Request: periodValue1\|空值(活存) | 期間值下限 | 運算子：大於等於 |
| period_value_max | Request: periodValue1\|空值(活存) | 期間值上限 | 運算子：小於 |
| 查詢結果 | 查詢結果 | 查詢結果 | 查詢結果 |
| - | max_rate | 最高利率 | DECIMAL(11,7), 用於承作利率上限檢核 |

---

<a name="table-52"></a>

### 表 52

| API 代碼 | API 名稱 | 功能說明 | 目標系統 |
|---|---|---|---|
| 關係人組件 | 檢核利害關係人 | 檢核客戶是否為金控利害關係人 | 中台關係人組件 |
| MIM-87 | Get latest Interest rate | 查詢FTP利率 | GBP MIM |
| BBP-45 | Get a specific Configurable Parameter record | 查詢基幣幣別 | GBP BBP |
| MIM-21 | Fetch exchange rates for a given date | 查詢匯率進行換匯 | GBP MIM |
| MIN | 客製化 | 交叉幣別試算 | GBP MIM |

---

<a name="table-53"></a>

### 表 53

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| customerRefNo | Request: customerReferenceNo | 客戶識別號 | 必填 |
| createdCountryCode | Fixed: VN | 建檔國家代碼 | 必填 |

---

<a name="table-54"></a>

### 表 54

| 目標欄位 | 內部對應欄位 | 說明 | 備註 |
|---|---|---|---|
| - | isStakeholder | 是否為利害關係人 | Y/N |
| - | cfhStakeholderType | 金控關係人類型 | 是否為金控利害關係人，0：非金控關係人/1：金控關係人 |

---

<a name="table-55"></a>

### 表 55

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| currency | Request: currency | 幣別 | 必填 |
| for-date | 系統日期 | 查詢日期 | 必填 系統日期，格式：YYYY-MM-DD |
| rate-type | Request: interestType | 利率代碼 | 必填，此代碼待確認 |
| entity-id | Fixed: GCUBBANKIN | 實體識別碼 | 必填 |
| rate-period-freq | Request: periodUnit1 | 期間單位 | 必填 |
| rate-period-value | Request: periodValue1 | 期間值 | 必填 |

---

<a name="table-56"></a>

### 表 56

| 目標欄位 | 內部對應欄位 | 說明 (Description) | 備註 (Remarks) |
|---|---|---|---|
| - | interest-rates.rate | FTP利率 | 用於加減碼範圍檢核 |

---

<a name="table-57"></a>

### 表 57

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| parameter | Fixed:126 | 查詢參數 | 必填，基幣查詢，代表Base Currency |
| applicability | Fixed :4 | 適用性 | 必填 |
| applicability-entity | Fixed: GBANKOU001 | 適用實體 | 必填 |

---

<a name="table-58"></a>

### 表 58

| 目標欄位 | 內部對應欄位 | 說明 (Description) | 備註 (Remarks) |
|---|---|---|---|
| - | parameter | 參數代碼驗證 | 取出參數為基幣(126) |
| - | parameter-value | 基幣幣別 | 取得基幣後傳入MIM-21作為兌換幣別(MIM-21.counter-currency) |
| - | status | 參數狀態驗證 | 取出參數為Active(5) |

---

<a name="table-59"></a>

### 表 59

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| reference-currency | Request: currency | 輸入幣別（來源幣別） | 必填 |
| counter-currency | BBP-45 Response: parameter-value | 參數幣別（基幣） | 必填 |
| entity-id | Fixed: GCUBBANKIN | 實體識別碼 |  |
| rate-date | 系統日 | 匯率日期 | 格式：YYYY-MM-DD |
| rate-purpose | Fixed:即期成本(此代碼待確認) | 匯率類型 |  |
| sanity-status | Optional | 完整性狀態 | 空值 |
| rate-status | Optional | 匯率狀態 | 空值 |

---

<a name="table-60"></a>

### 表 60

| 目標欄位 | 內部對應欄位 | 說明 (Description) | 備註 (Remarks) |
|---|---|---|---|
| - | mid-Rate | 匯率中價 | 交叉幣別試算時使用 |

---

<a name="table-61"></a>

### 表 61

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
|  | Fixed:S | 買賣別 | 必填，<br>B：銀行買入/S：銀行賣出 |
|  | Request: currency | 交易幣別 | 必填 |
|  | Request: dealingAmount | 交易金額 |  |
|  | BBP-45 Response: parameter-value | 對方幣別 | 必填 |
|  | Fixed:即期 (此代碼待確認) | 匯率類型-牌告 | 必填 |
|  | Fixed:即期成本(此代碼待確認) | 匯率類型-成本 |  |
|  | 系統日 | 匯率日期 | 格式：YYYY-MM-DD |
|  | MIM-21 Response: mid-Rate | 成交匯率(交叉匯率) |  |

---

<a name="table-62"></a>

### 表 62

| 目標欄位 | 內部對應欄位 | 說明 (Description) | 備註 (Remarks) |
|---|---|---|---|
| - |  | 對方金額 |  |

---

<a name="table-63"></a>

### 表格 1.2.1.3.1 異動的資料表

| 資料表英文名稱 | 資料表中文名稱 | 操作類型 | 說明 |
|---|---|---|---|
| tb_deposit_interest_contract | 利率議價主檔 | SELECT | 查詢利率議價合約紀錄 |
| tb_deposit_interest_quota_usage | 利率議價額度使用明細檔 | SELECT | 查詢額度使用狀況 |

---

<a name="table-64"></a>

### 表格 1.2.1.3.2查詢利率議價合約紀錄tb_deposit_interest_contract (Select)

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| 查詢條件 | 查詢條件 | 查詢條件 | 查詢條件 |
| branch_code | Request: branchCode | 分行代碼 | 選填，<br>運算子：等於，<br>未輸入則查所有 |
| transaction_date | Request: transactionDateStart | 訂約日期(起) | 選填，<br>運算子：大於等於 |
| transaction_date | Request: transactionDateEnd | 訂約日期(迄) | 選填，<br>運算子：小於等於 |
| value_date | Request: valueDateStart | 起息日期(起) | 選填，<br>運算子：大於等於 |
| value_date | Request: valueDateEnd | 起息日期(迄) | 選填，<br>運算子：小於等於 |
| expire_date | Request: expireDateStart | 到期日期(起) | 選填，<br>運算子：大於等於 |
| expire_date | Request: expireDateEnd | 到期日期(迄) | 選填，<br>運算子：小於等於 |
| customer_reference_no | Request: customerReferenceNo | 客戶識別號 | 選填，<br>運算子：等於 |
| contract_no | Request: contractNo | 議價編號 | 選填，<br>運算子：等於 |
| contract_type | Request: contractType | 合約類型 | 選填，<br>運算子：等於，<br>未輸入則查所有 |
| contract_status | Request: contractStatus | 合約狀態 | 選填，<br>運算子：等於 |
| userid_op | Request: userIdOp | 交易櫃員 | 選填，<br>運算子：等於 |
| currency | Request: currency | 幣別 | 選填，<br>運算子：等於 |
| 查詢結果(需進行分頁處理) | 查詢結果(需進行分頁處理) | 查詢結果(需進行分頁處理) | 查詢結果(需進行分頁處理) |
| contractNo | contract_no | 議價編號 | VARCHAR(16) |
| TransactionDate | transaction_date | 訂約日期 | Date，<br>依此欄位由大到小排序 |
| valueDate | value_date | 起息日期 | Date |
| expireDate | expire_date | 到期日期 | Date |
| branchClass | branch_class | 分行類型 | VARCHAR(6) |
| branchCode | branch_code | 分行代碼 | VARCHAR(4) |
| bsnUnit | bsn_unit | 績效行 | VARCHAR(4) |
| customerReferenceNo | customer_reference_no | 客戶識別號 | VARCHAR(35) |
| isStakeholder | is_stakeholder | 是否為金控利害關係人 | VARCHAR(1) |
| productReference | product_reference | 產品別 | DECIMAL(10) |
| currency | currency | 幣別 | VARCHAR(3) |
| interestType | interest_type | 利率別 | DECIMAL(3) |
| periodUnit1 | period_unit_1 | 期間單位1 | DECIMAL(3) |
| periodValue1 | period_value_1 | 期間值1 | DECIMAL(3) |
| periodUnit2 | period_unit_2 | 期間單位2 | DECIMAL(3) |
| periodValue2 | period_value_2 | 期間值2 | DECIMAL(3) |
| ftpRate | ftp_rate | FTP利率 | DECIMAL(11,7) |
| dealingRate | dealing_rate | 承作利率 | DECIMAL(11,7) |
| dealingAmount | dealing_amount | 承作金額 | DECIMAL(24,7) |
| remarks | remarks | 註記 | VARCHAR(80) |
| userIdOp | userid_op | 交易櫃員 | VARCHAR(35) |
| userIdVerify | userid_verify | 覆核主管 | VARCHAR(35) |
| datetimeVerify | datetime_verify | 覆核日期 | TIMESTAMP |
| contractStatus | contract_status | 合約狀態 | VARCHAR(10) |
| contractType | contract_type | 合約類型 | VARCHAR(3) |

---

<a name="table-65"></a>

### 表格 1.2.1.3.3 查詢額度使用狀況tb_deposit_interest_quota_usage (Select)

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| 查詢條件 | 查詢條件 | 查詢條件 | 查詢條件 |
| contract_no | tb_deposit_interest_contract.contract_no | 議價編號 | 選填，<br>運算子：等於 |
| 查詢結果 | 查詢結果 | 查詢結果 | 查詢結果 |
| transactionStatus | 計算邏輯 | 交割狀態 | 依處理流程判斷該筆利率議價的交割狀態，<br>0:未交割/1:部分交割/2:已交割 |
| usedAmount | sum(amount) | 已使用額度 | 條件：QUOTA_TRANSACTION_STATUS='ACTUAL' |
| leftAmount | tb_deposit_interest_contract.dealing_amount - usedAmount | 剩餘額度 | DECIMAL(24,7) |

---

<a name="table-66"></a>

### 表 66

| 數位通知組件 – 發送外部通知 | 數位通知組件 – 發送外部通知 |
|---|---|
| Request | 收件人列表(recipientList)、收件人類型(recipientType)、收件人值(recipientValue)、特定變數資料(specificMetadata)、鍵(Key)、值(Value)、通知發送平台(notificationSendPlatform)、內容套件(contentPackages)、通知渠道(notificationChannel=EMAIL)、訊息主旨(messageSubject)、訊息內文( messageTextBody)、通知發送時間(notificationSendTime=IMMEDIATE)、發送指定時間(sendScheduledTime) |
| Response | 通知訊息識別碼(notificationMessageId) |

---

<a name="table-67"></a>

### 表格 1.3.1.3.1 異動的資料表

| 資料表英文名稱 | 資料表中文名稱 | 操作類型 | 說明 |
|---|---|---|---|
| tb_deposit_interest_contract | 利率議價主檔 | SELECT | 查詢合約資料進行檢核 |
| tb_deposit_interest_quota_usage | 利率議價額度使用明細檔 | SELECT | 查詢已使用額度 |
| tb_deposit_interest_quota_usage | 利率議價額度使用明細檔 | INSERT | 新增額度使用明細 |

---

<a name="table-68"></a>

### 表 68

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| 查詢條件 | 查詢條件 | 查詢條件 | 查詢條件 |
| contract_no | Request: contractNo | 議價編號 | VARCHAR(16)，<br>運算子：等於 |
| 查詢結果 | 查詢結果 | 查詢結果 | 查詢結果 |
| - | contract_status | 合約狀態 | VARCHAR(10)，<br>檢核是否已覆核 |
| - | expire_date | 到期日期 | DATE，<br>檢核是否過期 |
| - | contract_type | 合約類型 | VARCHAR(3)，<br>依合約類型判斷處理方式 |
| - | dealing_amount | 承作金額 | DECIMAL(24,7)，<br>判斷是否超過承作上限，及計算剩餘額度 |

---

<a name="table-69"></a>

### 表 69

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| 查詢條件 | 查詢條件 | 查詢條件 | 查詢條件 |
| contract_no | Request: contractNo | 議價編號 | VARCHAR(16)，<br>運算子：等於 |
| 查詢結果 | 查詢結果 | 查詢結果 | 查詢結果 |
| - | sum(amount) | 已交割金額 | 條件：quota_transaction_status='ACTUAL' |

---

<a name="table-70"></a>

### 表格 1.3.1.3.4 新增額度使用明細 tb_deposit_interest_quota_usage (Insert)

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| uuid | 系統產生 | 識別碼 | VARCHAR(30)，<br>系統產生唯一識別碼 |
| contract_no | Request: contractNo | 議價編號 | VARCHAR(16) |
| amount | Request: amount(定存) \| 0 (活存) | 交易金額 | DECIMAL(24,7)，<br>活存寫入0 |
| transaction_date | 系統日 | 額度交易日期 | DATE，<br>系統日期 |
| quota_transaction_status | Fixed: ACTUAL | 明細狀態 | VARCHAR(7)<br>，實佔 |
| userid_op | Request: userIdOp | 交易櫃員 | VARCHAR(35) |
| userid_verify | Request: userIdVerify | 覆核主管 | VARCHAR(35) |
| datetime_verify | Request: datetimeVerify | 覆核日期 | TIMESTAMP, UTC格式 |

---

<a name="table-71"></a>

### 表格 1.3.2.3.1 異動的資料表

| 資料表英文名稱 | 資料表中文名稱 | 操作類型 | 說明 |
|---|---|---|---|
| tb_deposit_interest_quota_usage | 利率議價額度使用明細檔 | SELECT | 查詢交易明細是否存在 |
| tb_deposit_interest_quota_usage | 利率議價額度使用明細檔 | UPDATE | 更新明細狀態為沖正 |

---

<a name="table-72"></a>

### 表格 1.3.2.3.2 查詢交易明細是否存在 tb_deposit_interest_quota_usage (Select)

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| 查詢條件 | 查詢條件 | 查詢條件 | 查詢條件 |
| uuid | Request: uuid | 識別碼 | VARCHAR(30)，<br>運算子：等於 |

---

<a name="table-73"></a>

### 表 73

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| 更新條件 | 更新條件 | 更新條件 | 更新條件 |
| uuid | Request: uuid | 識別碼 | VARCHAR(30)，<br>運算子：等於 |
| 更新欄位 | 更新欄位 | 更新欄位 | 更新欄位 |
| quota_transaction_status | Fixed: REVERSE | 明細狀態 | VARCHAR(7)，<br>更新為沖正 |

---

<a name="table-74"></a>

### 表格 1.4.1.3.1 異動的資料表

| 資料表英文名稱 | 資料表中文名稱 | 操作類型 | 說明 |
|---|---|---|---|
| tb_deposit_interest_contract | 利率議價主檔 | SELECT | 查詢合約總額度 |
| tb_deposit_interest_quota_usage | 利率議價額度使用明細檔 | SELECT | 查詢額度使用明細 |

---

<a name="table-75"></a>

### 表 75

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| 查詢條件 | 查詢條件 | 查詢條件 | 查詢條件 |
| contract_no | Request: contractNo | 議價編號 | VARCHAR(16)，<br>運算子：等於 |
| 查詢結果 | 查詢結果 | 查詢結果 | 查詢結果 |
| dealingAmount | dealing_amount | 合約總額度 | DECIMAL(24,7) |

---

<a name="table-76"></a>

### 表 76

| 目標欄位 | 欄位對應規則 | 說明 | 備註 |
|---|---|---|---|
| 查詢條件 | 查詢條件 | 查詢條件 | 查詢條件 |
| contract_no | Request: contractNo | 議價編號 | VARCHAR(16)，<br>運算子：等於 |
| 查詢結果(需進行分頁處理) | 查詢結果(需進行分頁處理) | 查詢結果(需進行分頁處理) | 查詢結果(需進行分頁處理) |
| contractNo | contract_no | 議價編號 | VARCHAR(16) |
| uuid | uuid | 交易流水號 | VARCHAR(30) |
| transactionDate | transaction_date | 交易日期 | DATE，<br>依此欄位由大到小排序 |
| userIdOp | userid_op | 交易櫃員 | VARCHAR(35) |
| userIdVerify | userid_verify | 覆核主管 | VARCHAR(35) |
| datetimeVerfiy | datetime_verify | 覆核日期 | TIMESTAMP |
| quotaTransactionStatus | quota_transaction_status | 額度使用狀態 | VARCHAR(7) |
| transactionAmount | amount | 交易金額 | DECIMAL(24,7) |
| usedAmount | sum(amount) | 已使用額度 | 條件：QUOTA_TRANSACTION_STATUS='ACTUAL' |
| leftAmount | tb_deposit_interest_contract.dealing_amount - usedAmount | 剩餘額度 | DECIMAL(24,7) |

---

<a name="table-77"></a>

### 表 77

| 介接系統 | API NAME | 說明 | 備註 |
|---|---|---|---|
| 中台-關係人組件 | 檢核利害關係人 | 檢核客戶是否為金控利害關係人 |  |
| GBP | GBP MIM-87 - Get latest Interest rate | 查詢FTP利率 |  |
| GBP | GBP BBP-45 - Get a specific Configurable Parameter record | 查詢基幣幣別 |  |
| GBP | GBP MIM-21 - Fetch exchange rates for a given date | 查詢匯率進行換匯 |  |
| GBP | GBP MIN - | 交叉幣別試算 | 待確認客製化規格 |

---

