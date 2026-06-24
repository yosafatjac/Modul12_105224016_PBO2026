import java.util.List;

// MK Teori — hanya mengimplementasikan MataKuliah, tanpa metode lab (LSP & ISP terpenuhi)
public class MataKuliahTeori implements MataKuliah {
    private String namaMK;
    private int sks;
    private List<String> prasyarat;

    public MataKuliahTeori(String namaMK, int sks, List<String> prasyarat) {
        this.namaMK = namaMK;
        this.sks = sks;
        this.prasyarat = prasyarat;
    }

    public String getNamaMK() { return namaMK; }
    public int getSks() { return sks; }
    public List<String> getPreSyarat() { return prasyarat; }
}