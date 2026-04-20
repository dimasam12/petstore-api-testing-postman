# 🧪 API Testing – Swagger Petstore

## 📌 Deskripsi Project

Project ini merupakan pengujian API menggunakan Postman pada Swagger Petstore.
Tujuan dari pengujian ini adalah untuk memastikan fungsi API berjalan dengan baik, respon sesuai, dan validasi input bekerja dengan benar.

## 🛠 Tools yang Digunakan

* Postman
* Swagger Petstore API
* JSON

## 🎯 Ruang Lingkup Pengujian

Pengujian dilakukan pada beberapa endpoint berikut:

* User API
* Pet API
* Store API

## 📊 Hasil Pengujian

* Total Test Case: 29
* Passed: 22
* Failed: 7
* Pass Rate: 76%

## 🐞 Ringkasan Bug

Ditemukan **7 bug** selama proses pengujian.
Sebagian besar bug terkait dengan:

* Validasi input yang tidak berjalan
* Response API yang tidak sesuai
* Error handling yang kurang tepat

Detail bug dapat dilihat pada folder `/bug-reports`.

## 📂 Struktur Project

* `/collection` → File Postman collection
* `/environment` → Konfigurasi environment Postman
* `/testcases` → Dokumen test case
* `/bug-reports` → Detail laporan bug
* `/evidence` → Screenshot hasil testing (fail)
* `/test-summary` → Ringkasan hasil pengujian

## 🚀 Cara Menjalankan

1. Import file collection ke Postman
2. Import environment
3. Jalankan menggunakan Collection Runner
4. Lihat hasil pengujian

## ✅ Kesimpulan

Sistem sudah berjalan dengan cukup baik, namun masih terdapat beberapa bug terutama pada validasi dan response API yang perlu diperbaiki sebelum digunakan secara optimal.
