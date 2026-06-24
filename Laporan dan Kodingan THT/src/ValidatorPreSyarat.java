// Kelas terpisah yang hanya bertanggung jawab memvalidasi prasyarat MK (SRP)
public class ValidatorPreSyarat {
    public boolean validasi(Mahasiswa mhs, MataKuliah mk) {
        System.out.println("Memvalidasi prasyarat " + mk.getNamaMK() + " untuk " + mhs.getNama());
        // Logika validasi prasyarat
        return true;
    }
}