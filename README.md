# 🧪 Petstore API Testing – Postman (Pet Wager)

Proyek ini merupakan implementasi pengujian API menggunakan Postman pada layanan Swagger Petstore. Repository ini dibuat sebagai bagian dari portofolio Quality Assurance (QA) untuk menunjukkan kemampuan dalam melakukan API testing, validasi response, serta penyusunan test case yang terstruktur.

---

## 🎯 Tujuan

* Menguji endpoint API (GET, POST, PUT, DELETE)
* Memvalidasi response API sesuai expected result
* Melakukan pengujian positif & negatif
* Mengidentifikasi potensi bug atau error
* Membuat dokumentasi pengujian API

---

## 🔗 API Source

API yang digunakan berasal dari Swagger Petstore:

https://petstore.swagger.io/

---

## 🧰 Tools & Teknologi

* Postman (API Testing Tool)
* Swagger (API Documentation)
* JSON
* JavaScript (Postman Test Script)

---

## 📌 Endpoint yang Diuji

### 👤 User API

* Create User
* Get User by Username
* Update User
* Delete User

### 🐶 Pet API

* Add New Pet
* Find Pet by ID
* Update Pet
* Delete Pet

### 🛒 Store API

* Place Order
* Get Order by ID
* Delete Order

---

## 🧪 Jenis Pengujian

* ✅ Positive Testing
* ❌ Negative Testing
* ⚠️ Boundary Testing
* 🔁 CRUD Testing

---

## 📁 Struktur Project

```
petstore-api-testing-postman/
│
├── collection/
├── environment/
├── test-case/
└── README.md
```

---

## 🧾 Contoh Test Script (Postman)

```javascript
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response time is less than 500ms", function () {
    pm.expect(pm.response.responseTime).to.be.below(500);
});
```

---

## 🚀 Cara Menjalankan

1. Import file collection ke Postman
2. Import environment (jika ada)
3. Jalankan request sesuai endpoint
4. Lihat hasil pada tab "Tests" dan "Response"

---

## 📊 Hasil

* Endpoint utama berhasil diuji
* Validasi response berjalan dengan baik
* Test case terdokumentasi dengan rapi

---

## 💼 Nilai Portofolio

Proyek ini menunjukkan kemampuan dalam:

* API Testing menggunakan Postman
* Penulisan Test Case
* Validasi Response API
* Dokumentasi QA
* Pemahaman REST API

---

## 📌 Catatan

API yang digunakan adalah API publik (Swagger Petstore), sehingga pengujian dilakukan dalam konteks simulasi (testing environment).

---

## 👨‍💻 Author

Dimas Akbar
QA Engineer Enthusiast 🚀
