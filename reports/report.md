🐞 Bug Report 1 — Critical Severity
Title: API menerima input quantity berlebihan pada endpoint POST /store/order menyebabkan Internal Server Error (500)
ID: BUG_STORE_01
Severity: Critical
Priority: High

Environment
Base URL: petstore.swagger.io
petstore.swagger.io
Endpoint: /store/order
Method: POST
Prerequisite / Pre-condition
API aktif dan dapat diakses.

Test Data
json

{
  "id": 2,
  "petId": 1,
  "quantity": 999999999999,
  "shipDate": "2026-04-04T01:51:04.540Z",
  "status": "placed",
  "complete": true
}

Steps to Reproduce
Kirim request POST /store/order dengan data di atas.
Amati respon dari server.

Expected Result
API menolak input besar tidak wajar dan mengembalikan:

Status code 400 (Bad Request)
Message: "Invalid quantity value"

Actual Result
Status code 500 (Internal Server Error)
Response body menunjukkan kesalahan validasi di sisi server.

Impact
Kesalahan validasi input memungkinkan server crash untuk data ekstrem.
Dapat dimanfaatkan untuk DoS (Denial of Service).

Evidence
6.png

🐞 Bug Report 2 — High Severity
Title: API login menerima kredensial kosong dan tetap mengembalikan status 200 (berhasil login)
ID: BUG_USER_01
Severity: High
Priority: High

Environment
Base URL: petstore.swagger.io
petstore.swagger.io
Endpoint: /user/login
Method: GET
Prerequisite / Pre-condition
Server login aktif.

Test Data
username=
password=
Steps to Reproduce
Kirim request GET /user/login?username=&password=
Amati response status dan pesan.

Expected Result
API seharusnya mengembalikan:
Status code 400 (Bad Request) atau 401 (Unauthorized)
Message: "Username or password required"

Actual Result
Status code 200 (OK)
Response menunjukkan user berhasil login meski tanpa data.

Impact
Serius pada keamanan sistem.
User tak terautentik dapat mengakses endpoint yang dilindungi.

Evidence
2.png

🐞 Bug Report 3 — Medium Severity
Title: Endpoint PUT /pet menerima data kosong tanpa validasi (update tetap berhasil)
ID: BUG_PET_01
Severity: Medium
Priority: Medium

Environment
Base URL: petstore.swagger.io
petstore.swagger.io
Endpoint: /pet
Method: PUT
Test Data
json

{
  "id": 2,
  "name": "",
  "photoUrls": [],
  "tags": [],
  "status": "sold"
}

Steps to Reproduce
Kirim request PUT /pet dengan data name kosong.
Amati hasil respon.

Expected Result
Status code 400 (Bad Request)
Message: "Pet name cannot be empty"

Actual Result
Status code 200 (OK)
Response menunjukkan update berhasil walau field kosong.

Impact
Validasi data kurang ketat, dapat menyebabkan inkonsistensi data (pet tanpa nama dalam database).

Evidence
5.png
