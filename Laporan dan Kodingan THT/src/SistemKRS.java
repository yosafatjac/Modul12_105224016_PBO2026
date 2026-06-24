import java.util.List;


// Kelas orkestrasi yang mengoordinasi seluruh proses KRS
// Setiap tanggung jawab didelegasikan ke kelas terpisah (SRP)
// Bergantung pada abstraksi, bukan implementasi konkret (DIP)
public class SistemKRS {
    private ValidatorPreSyarat validator;
    private KalkulatorUKT kalkulator;
    private PencetakKRS pencetak;
    private KRSRepository repository;

    // Dependency Injection melalui constructor — memudahkan penukaran implementasi (DIP)
    public SistemKRS(ValidatorPreSyarat validator, KalkulatorUKT kalkulator,
                     PencetakKRS pencetak, KRSRepository repository) {
        this.validator = validator;
        this.kalkulator = kalkulator;
        this.pencetak = pencetak;
        this.repository = repository;
    }

    public void prosesKRS(Mahasiswa mhs, List<MataKuliah> daftarMK) {
        // Validasi prasyarat setiap MK
        for (MataKuliah mk : daftarMK) {
            validator.validasi(mhs, mk);
        }
        // Hitung tagihan UKT
        kalkulator.hitungUKT(mhs, daftarMK);
        // Cetak draf KRS
        pencetak.cetakKRS(mhs, daftarMK);
        // Simpan ke database
        KRS krs = new KRS(mhs, daftarMK);
        repository.simpan(krs);
        System.out.println("Proses KRS selesai untuk " + mhs.getNama());
    }
}