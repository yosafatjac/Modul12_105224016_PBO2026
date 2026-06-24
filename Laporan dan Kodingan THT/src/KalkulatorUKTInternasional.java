import java.util.List;

// Perhitungan UKT untuk mahasiswa Internasional
public class KalkulatorUKTInternasional implements KalkulatorUKT {
    private double tarifPerSKS = 1000000;

    public double hitungUKT(Mahasiswa mhs, List<MataKuliah> daftarMK) {
        int totalSKS = daftarMK.stream().mapToInt(MataKuliah::getSks).sum();
        double total = totalSKS * tarifPerSKS;
        System.out.println("UKT Internasional untuk " + mhs.getNama() + ": Rp" + total);
        return total;
    }
}