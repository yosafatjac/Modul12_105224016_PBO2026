import java.util.List;

// Perhitungan UKT untuk program MBKM — siap ditambahkan tanpa modifikasi kelas lain (OCP)
public class KalkulatorUKTMBKM implements KalkulatorUKT {
    private double tarifPerSKS = 350000;

    public double hitungUKT(Mahasiswa mhs, List<MataKuliah> daftarMK) {
        int totalSKS = daftarMK.stream().mapToInt(MataKuliah::getSks).sum();
        double total = totalSKS * tarifPerSKS;
        System.out.println("UKT MBKM untuk " + mhs.getNama() + ": Rp" + total);
        return total;
    }
}