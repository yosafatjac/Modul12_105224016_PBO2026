import java.util.List;

// Kelas terpisah yang hanya bertanggung jawab mencetak KRS ke format PDF (SRP)
public class PencetakKRS {
    public void cetakKRS(Mahasiswa mhs, List<MataKuliah> daftarMK) {
        System.out.println("=== DRAF KRS ===");
        System.out.println("Nama: " + mhs.getNama());
        System.out.println("NIM: " + mhs.getNim());
        for (MataKuliah mk : daftarMK) {
            System.out.println("- " + mk.getNamaMK() + " (" + mk.getSks() + " SKS)");
        }
        System.out.println("Mencetak ke format PDF...");
    }
}