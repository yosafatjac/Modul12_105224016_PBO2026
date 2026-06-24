
import java.util.Arrays;
import java.util.List;

// Kelas utama untuk mendemonstrasikan sistem SIAKAD yang telah dirancang ulang dengan SOLID
public class Main {
    public static void main(String[] args) {
        // Membuat objek mahasiswa
        Mahasiswa mhs = new Mahasiswa("Yosafat Jacobus", "105224016", "Reguler");

        // Membuat daftar mata kuliah dengan berbagai jenis (LSP & ISP terpenuhi)
        List<MataKuliah> daftarMK = Arrays.asList(
            new MataKuliahTeori("Pemrograman Berorientasi Objek", 3, Arrays.asList("Dasar Pemrograman")),
            new MataKuliahPraktikum("Praktikum PBO", 1, Arrays.asList("PBO")),
            new MataKuliahKKN("Kuliah Kerja Nyata", 4, Arrays.asList())
        );

        // === Skenario 1: Menggunakan MySQL (sebelum migrasi) ===
        System.out.println("\n=== SKENARIO 1: MySQL + Mahasiswa Reguler ===");
        SistemKRS sistemMySQL = new SistemKRS(
            new ValidatorPreSyarat(),
            new KalkulatorUKTReguler(),     // Strategi UKT Reguler (OCP)
            new PencetakKRS(),
            new MySQLKRSRepository()         // Implementasi MySQL (DIP)
        );
        sistemMySQL.prosesKRS(mhs, daftarMK);

        System.out.println();

        // === Skenario 2: Migrasi ke Cloud NoSQL (tanpa ubah kode SistemKRS) ===
        System.out.println("=== SKENARIO 2: Cloud NoSQL + Mahasiswa Bidikmisi ===");
        Mahasiswa mhsBidikmisi = new Mahasiswa("Pradana Akbar Razan", "105224043", "Bidikmisi");
        SistemKRS sistemCloud = new SistemKRS(
            new ValidatorPreSyarat(),
            new KalkulatorUKTBidikmisi(),     // Strategi UKT Bidikmisi (OCP)
            new PencetakKRS(),
            new CloudNoSQLKRSRepository()     // Implementasi Cloud NoSQL (DIP)
        );
        sistemCloud.prosesKRS(mhsBidikmisi, daftarMK);

        System.out.println();

        // === Skenario 3: Program MBKM (penambahan jalur baru tanpa modifikasi) ===
        System.out.println("=== SKENARIO 3: Cloud NoSQL + Mahasiswa MBKM ===");
        Mahasiswa mhsMBKM = new Mahasiswa("Dwi Setiawan", "105224015", "MBKM");
        SistemKRS sistemMBKM = new SistemKRS(
            new ValidatorPreSyarat(),
            new KalkulatorUKTMBKM(),          // Jalur baru tanpa modifikasi kelas lama (OCP)
            new PencetakKRS(),
            new CloudNoSQLKRSRepository()
        );
        sistemMBKM.prosesKRS(mhsMBKM, daftarMK);
    }
}