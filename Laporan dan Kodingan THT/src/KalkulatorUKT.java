import java.util.List;

// Interface strategi perhitungan UKT — memungkinkan penambahan jalur baru tanpa modifikasi (OCP)
public interface KalkulatorUKT {
    double hitungUKT(Mahasiswa mhs, List<MataKuliah> daftarMK);
}