// Kelas model data Mahasiswa — hanya bertanggung jawab menyimpan data mahasiswa (SRP)
public class Mahasiswa {
    private String nama;
    private String nim;
    private String jalurMasuk;

    public Mahasiswa(String nama, String nim, String jalurMasuk) {
        this.nama = nama;
        this.nim = nim;
        this.jalurMasuk = jalurMasuk;
    }

    public String getNama() { return nama; }
    public String getNim() { return nim; }
    public String getJalurMasuk() { return jalurMasuk; }
}