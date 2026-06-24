// Implementasi penyimpanan Cloud NoSQL — bisa ditukar tanpa ubah kode tingkat tinggi (DIP)
public class CloudNoSQLKRSRepository implements KRSRepository {
    public void simpan(KRS krs) {
        System.out.println("Menyimpan KRS " + krs.getMahasiswa().getNama() + " ke Cloud NoSQL...");
    }
}