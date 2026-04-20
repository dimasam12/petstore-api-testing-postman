🐞 Bug Report Summary
🟥 BUG STORE 01 — Critical
📝 Title

API menerima input quantity sangat besar pada endpoint POST /store/order menyebabkan Internal Server Error (500)

🆔 Bug ID

BUG_STORE_01

⚠️ Severity

Critical

📌 Priority

High

🌐 Environment
Base URL: https://petstore.swagger.io
Endpoint: /store/order
Method: POST

🔧 Pre-condition
API dalam keadaan aktif dan dapat diakses

📦 Test Data
{
  "id": 2,
  "petId": 1,
  "quantity": 999999999999,
  "shipDate": "2026-04-04T01:51:04.540Z",
  "status": "placed",
  "complete": true
}

▶️ Steps to Reproduce
Kirim request POST /store/order
Gunakan payload di atas
Amati response dari server

✅ Expected Result
Status Code: 400 Bad Request
Message: "Invalid quantity value"
Sistem menolak input tidak valid

❌ Actual Result
Status Code: 500 Internal Server Error
Server error muncul akibat input tidak divalidasi

💥 Impact
Risiko crash pada server akibat input ekstrem
Potensi DoS (Denial of Service)
Menunjukkan lemahnya validasi di backend

📎 Evidence

6.png

🟧 BUG USER 01 — High
📝 Title

API login menerima kredensial kosong dan tetap mengembalikan status 200 (login berhasil)

🆔 Bug ID

BUG_USER_01

⚠️ Severity

High

📌 Priority

High

🌐 Environment
Base URL: https://petstore.swagger.io
Endpoint: /user/login
Method: GET
🔧 Pre-condition

Service login aktif

📦 Test Data
username=
password=

▶️ Steps to Reproduce

Kirim request:

GET /user/login?username=&password=
Periksa response dari server

✅ Expected Result
Status Code: 400 Bad Request atau 401 Unauthorized
Message: "Username or password required"
Login gagal jika data kosong

❌ Actual Result
Status Code: 200 OK
Response mengindikasikan login berhasil tanpa kredensial

💥 Impact
Celah keamanan serius
Autentikasi dapat dilewati
Risiko akses tidak sah ke sistem

📎 Evidence

2.png

🟨 BUG PET 01 — Medium
📝 Title

Endpoint PUT /pet menerima data kosong tanpa validasi

🆔 Bug ID

BUG_PET_01

⚠️ Severity

Medium

📌 Priority

Medium

🌐 Environment
Base URL: https://petstore.swagger.io
Endpoint: /pet
Method: PUT

📦 Test Data
{
  "id": 2,
  "name": "",
  "photoUrls": [],
  "tags": [],
  "status": "sold"
}

▶️ Steps to Reproduce
Kirim request PUT /pet
Gunakan data dengan field name kosong
Amati response server

✅ Expected Result
Status Code: 400 Bad Request
Message: "Pet name cannot be empty"
Data kosong ditolak

❌ Actual Result
Status Code: 200 OK
Update tetap berhasil meskipun data tidak valid

💥 Impact
Data tidak konsisten di database
Potensi muncul record invalid (pet tanpa nama)
Lemahnya validasi input di backend

📎 Evidence

5.png
