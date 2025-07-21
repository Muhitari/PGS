# 🥗 Personalized Nutrition Plan

**Personalized Nutrition Plan** adalah aplikasi desktop berbasis **Java** dan **JavaFX** yang dirancang untuk membantu pengguna merencanakan dan mengelola asupan nutrisi harian, mingguan, hingga bulanan. Aplikasi ini menyarankan makanan berdasarkan bahan yang tersedia, mencatat aktivitas, dan melacak pencapaian nutrisi pengguna — semuanya dalam satu platform yang interaktif dan mudah digunakan.

---

## ✨ Fitur Utama

- **👤 Profil Pengguna**  
  Kelola data pribadi seperti nama, usia, tinggi badan, berat badan, jenis kelamin, dan alergi makanan.

- **📅 Jadwal Kegiatan**  
  Tambah, ubah, dan hapus jadwal harian termasuk aktivitas, waktu, dan catatan.

- **📊 Laporan Visual**  
  Tampilkan data nutrisi dan anggaran dalam bentuk **bar chart** dan **tabel interaktif**.

- **🥦 Rencana Nutrisi**  
  Rekomendasi nutrisi berdasarkan tujuan (Diet, Bulking, Hemat Biaya) dan periode (Harian, Mingguan, Bulanan). Anda juga bisa menambahkan atau menghapus item secara manual.

- **💰 Rencana Anggaran**  
  Buat alokasi anggaran otomatis untuk kategori seperti Makanan, Transportasi, dan Tagihan & Utilitas. Kelola item anggaran sesuai kebutuhan.

- **🍽️ Rekomendasi Resep**  
  Temukan resep berdasarkan bahan yang tersedia dan kelola daftar resep favorit Anda.

---

## 🛠️ Teknologi yang Digunakan

| Teknologi      | Deskripsi                                                                 |
|----------------|---------------------------------------------------------------------------|
| **Java**       | Bahasa pemrograman inti aplikasi.                                          |
| **JavaFX**     | Untuk membangun antarmuka pengguna grafis (GUI) yang modern dan interaktif.|
| **FXML**       | Format XML untuk mendesain UI secara visual dengan Scene Builder.          |
| **Gson**       | Untuk serialisasi dan deserialisasi data JSON.                            |

---

## 📁 Struktur Proyek (src)

src/
├── CMain.java # Entry point awal (starter class)
├── MainApp.java # MainApp untuk menjalankan Scene JavaFX
├── controller/ # Berisi logic dari GUI dan interaksi pengguna
├── model/ # Class untuk data model (Profil, Nutrisi, Resep, dsb)
├── view/ # File FXML (UI layout)
├── data/ # File JSON data pengguna & konfigurasi


---

## 🚀 Cara Menjalankan

1. Clone repositori ini :
   - git clone https://github.com/Muhitari/PGS.git
2. Buka project di VS Code atau IntelliJ IDEA.
3. Pastikan sudah menginstal:
- JDK 17 atau lebih baru 
- JavaFX SDK 
- Gson library
- FXML SDK library 
4. Jalankan file MainApp.java.
