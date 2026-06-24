import java.util.List;

// MK Praktikum — mengimplementasikan MataKuliah dan Praktikumable (ISP terpenuhi)
public class MataKuliahPraktikum implements MataKuliah, Praktikumable {
    private String namaMK;
    private int sks;
    private List<String> prasyarat;

    public MataKuliahPraktikum(String namaMK, int sks, List<String> prasyarat) {
        this.namaMK = namaMK;
        this.sks = sks;
        this.prasyarat = prasyarat;
    }

    public String getNamaMK() { return namaMK; }
    public int getSks() { return sks; }
    public List<String> getPreSyarat() { return prasyarat; }

    // Implementasi nyata karena Praktikum memang membutuhkan asisten lab
    public void alokasiAsistenLab() {
        System.out.println("Mengalokasikan asisten lab untuk " + namaMK);
    }

    // Implementasi nyata karena Praktikum memang membutuhkan peralatan
    public void cekPeralatanPraktikum() {
        System.out.println("Mengecek peralatan praktikum untuk " + namaMK);
    }
}