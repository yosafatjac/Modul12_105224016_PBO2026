import java.util.List;

// Perhitungan UKT untuk mahasiswa Karyawan
public class KalkulatorUKTKaryawan implements KalkulatorUKT {
    private double tarifPerSKS = 600000;

    public double hitungUKT(Mahasiswa mhs, List<MataKuliah> daftarMK) {
        int totalSKS = daftarMK.stream().mapToInt(MataKuliah::getSks).sum();
        double total = totalSKS * tarifPerSKS;
        System.out.println("UKT Karyawan untuk " + mhs.getNama() + ": Rp" + total);
        return total;
    }
}