import java.util.List;

// Kelas model data KRS — menyimpan data KRS mahasiswa
public class KRS {
    private Mahasiswa mahasiswa;
    private List<MataKuliah> daftarKRS;

    public KRS(Mahasiswa mahasiswa, List<MataKuliah> daftarKRS) {
        this.mahasiswa = mahasiswa;
        this.daftarKRS = daftarKRS;
    }

    public Mahasiswa getMahasiswa() { return mahasiswa; }
    public List<MataKuliah> getDaftarKRS() { return daftarKRS; }
}