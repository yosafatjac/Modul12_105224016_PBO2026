import java.util.List;

// Perhitungan UKT untuk mahasiswa Reguler
public class KalkulatorUKTReguler implements KalkulatorUKT {
    private double tarifPerSKS = 500000;

    public double hitungUKT(Mahasiswa mhs, List<MataKuliah> daftarMK) {
        int totalSKS = daftarMK.stream().mapToInt(MataKuliah::getSks).sum();
        double total = totalSKS * tarifPerSKS;
        System.out.println("UKT Reguler untuk " + mhs.getNama() + ": Rp" + total);
        return total;
    }
}