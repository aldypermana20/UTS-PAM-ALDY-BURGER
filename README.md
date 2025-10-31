# aplikasi pemesanan makanan online yang berfokus pada menu burger.  
Aplikasi ini dibuat untuk UTS Pengembangan Aplikasi Mobile
---

## Pada tahap Awal yaitu Splash Screen dan Welcome

### 🔹 Splash Screen (`MainActivity`)
Saat pengguna pertama kali membuka aplikasi, akan muncul tampilan **Splash Screen** selama 2–3 detik yang menampilkan **logo aplikasi**.

### 🔹 Welcome Screen (`WelcomeActivity`)
Setelah Splash Screen, pengguna diarahkan ke halaman **Welcome** yang berisi:
- Gambar burger dan judul aplikasi.
- Dua tombol utama:
  - **Login** – untuk pengguna yang sudah memiliki akun.
  - **Register** – untuk pengguna baru yang ingin membuat akun.

---

## 🧾 Proses Registrasi dan Login

### 🔹 Register Activity
Pengguna baru dapat membuat akun dengan mengisi:
- Nama  
- Email  
- Password  

Setelah menekan tombol **Register**, data akan **disimpan sementara (tanpa database)** dan pengguna otomatis diarahkan ke **Login Activity**.

### 🔹 Login Activity
Pengguna memasukkan **email** dan **password** yang telah didaftarkan.  
Jika validasi berhasil, pengguna akan diarahkan ke halaman utama yaitu **Home Activity**.

---

## 🏠 Halaman Utama dan Daftar Menu

### 🔹 Home Activity
Menampilkan **HomeFragment** yang berisi daftar burger dalam bentuk **RecyclerView**.

Setiap item menampilkan:
- Gambar burger  
- Nama burger (contoh: *Cheese Burger*, *Beef Burger*, dll)  
- Deskripsi singkat  
- Harga  

### 🔹 Bottom Navigation
Terdapat tiga menu utama di bagian bawah:
1. **Home** 🏠  
2. **Order** 🛒  
3. **Profile** 👤  

Pengguna dapat memilih burger yang diinginkan dengan mengklik salah satu item dari daftar.

---

## 🍔 Detail Produk dan Pemesanan

### 🔹 Food Detail Activity
Setelah burger diklik, pengguna akan melihat halaman detail berisi:
- Gambar burger ukuran besar  
- Nama, deskripsi, dan harga burger  
- Tombol **Order Now**

### 🔹 Order Confirm Activity
Setelah menekan **Order Now**, pengguna mengisi formulir pemesanan yang berisi:
- Jumlah porsi  
- Nama pemesan  
- Alamat pengiriman  

⚠️ Jika ada kolom yang belum diisi, aplikasi akan menampilkan **Toast peringatan**.  
Setelah lengkap, pengguna menekan **Pesan Sekarang**, dan data pesanan disimpan ke **Order Manager (memori sementara)**, lalu diarahkan ke **Success Activity**.

---

## ✅ Konfirmasi dan Riwayat Pesanan

### 🔹 Success Activity
Menampilkan pesan sukses seperti:

> "Halo Aldy, Pesananmu Berhasil Diterima! 🎉"

Halaman ini juga menampilkan detail pesanan:
- Nama makanan  
- Jumlah porsi  
- Nama pemesan  
- Alamat pengiriman  

Terdapat tombol **Oke** yang mengembalikan pengguna ke **Home Activity**.

### 🔹 Order Fragment
Dapat diakses melalui ikon **keranjang belanja** di Bottom Navigation.  
Berisi daftar pesanan dalam bentuk **CardView**, yang menampilkan:
- Gambar burger  
- Nama burger  
- Jumlah porsi  
- Harga total  
- Nama & alamat pemesan  
- Waktu pemesanan  

Jika belum ada pesanan, akan muncul pesan:
> “Belum ada pesanan. Yuk pesan burger favoritmu!”

---

## 👤 Profil Pengguna dan Logout

### 🔹 Profile Activity
Menampilkan informasi pengguna:
- Foto profil  
- Nama (misal: *Aldy*)  
- Email (misal: *aldy@example.com*)  

Terdapat dua kategori menu:
- **Akun Saya:** Edit Profile, Alamat, Riwayat Pesanan  
- **Pengaturan:** Notifikasi, Bantuan, dan tombol **Keluar** (berwarna merah)

### 🔹 Logout Process
Saat pengguna menekan **Keluar**, aplikasi akan:
- Melakukan proses logout  
- Mengarahkan kembali ke **Login Activity**  
- Menghapus seluruh data pesanan dari memori (karena tidak menggunakan database)  

➡️ Setelah login kembali, pengguna harus melakukan pemesanan ulang untuk melihat riwayat baru.

---

## 💡 Tentang Pengembang
**Dibuat oleh:** Aldy Permana  
**Tujuan:** Proyek aplikasi Android sederhana untuk UTS pembuatan aplikasi pemesanan makanan (burger).






