// Implementasi penyimpanan MySQL sebagai detail tingkat rendah (DIP)
public class MySQLKRSRepository implements KRSRepository {
    public void simpan(KRS krs) {
        System.out.println("Menyimpan KRS " + krs.getMahasiswa().getNama() + " ke MySQL Database...");
    }
}