# 🍔 Detail Produk dan Pemesanan

## Food Detail Activity
Setelah burger diklik, pengguna akan melihat halaman detail berisi:

- Gambar burger ukuran besar  
- Nama, deskripsi, dan harga burger  
- Tombol **Order Now**  

---

## Order Confirm Activity
Setelah menekan **Order Now**, pengguna mengisi formulir pemesanan:

- Jumlah porsi  
- Nama pemesan  
- Alamat pengiriman  

⚠️ Jika ada kolom yang belum diisi, akan muncul **Toast peringatan**.  
Setelah lengkap, pengguna menekan **Pesan Sekarang**, dan data pesanan disimpan ke **Order Manager (memori sementara)**, lalu diarahkan ke **Success Activity**.

---

# ✅ Konfirmasi dan Riwayat Pesanan

## Success Activity
Menampilkan pesan sukses seperti:  
> "Halo Aldy, Pesananmu Berhasil Diterima! 🎉"

Halaman ini juga menampilkan detail pesanan:
- Nama makanan  
- Jumlah porsi  
- Nama pemesan  
- Alamat pengiriman  

Terdapat tombol **Oke** yang mengembalikan pengguna ke **Home Activity**.

---

## Order Fragment
Dapat diakses melalui ikon **keranjang belanja** di Bottom Navigation.  
Berisi daftar pesanan dalam bentuk **CardView**:

- Gambar burger  
- Nama burger  
- Jumlah porsi  
- Harga total  
- Nama dan alamat pemesan  
- Waktu pemesanan  

Jika belum ada pesanan, akan muncul pesan:  
> “Belum ada pesanan. Yuk pesan burger favoritmu!”

---

# 👤 Profil Pengguna dan Logout

## Profile Activity
Menampilkan informasi pengguna:

- Foto profil  
- Nama (misal: *Aldy*)  
- Email (misal: *Aldy@example.com*)  

Terdapat dua kategori menu:
- **Akun Saya:** Edit Profile, Alamat, Riwayat Pesanan  
- **Pengaturan:** Notifikasi, Bantuan, dan tombol **Keluar** (warna merah)

---

## Logout Process
Saat pengguna menekan **Keluar**, aplikasi akan:
- Melakukan proses logout  
- Mengarahkan kembali ke **Login Activity**  
- Menghapus seluruh data pesanan dari memori (karena tidak menggunakan database)  

➡️ Setelah login kembali, pengguna harus melakukan pemesanan ulang untuk melihat riwayat baru.
