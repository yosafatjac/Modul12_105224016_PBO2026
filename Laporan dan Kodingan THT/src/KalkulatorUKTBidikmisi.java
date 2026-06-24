import java.util.List;

// Perhitungan UKT untuk mahasiswa Bidikmisi — ada diskon penuh (OCP)
public class KalkulatorUKTBidikmisi implements KalkulatorUKT {

    public double hitungUKT(Mahasiswa mhs, List<MataKuliah> daftarMK) {
        double total = 0;
        System.out.println("UKT Bidikmisi untuk " + mhs.getNama() + ": Rp" + total + " (ditanggung negara)");
        return total;
    }
}