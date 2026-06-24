// Interface abstraksi penyimpanan data KRS — modul tingkat tinggi bergantung pada ini (DIP)
public interface KRSRepository {
    void simpan(KRS krs);
}