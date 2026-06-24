import java.util.List;

// MK KKN/Kuliah Lapangan — hanya mengimplementasikan MataKuliah, tanpa metode lab (LSP & ISP)
public class MataKuliahKKN implements MataKuliah {
    private String namaMK;
    private int sks;
    private List<String> prasyarat;

    public MataKuliahKKN(String namaMK, int sks, List<String> prasyarat) {
        this.namaMK = namaMK;
        this.sks = sks;
        this.prasyarat = prasyarat;
    }

    public String getNamaMK() { return namaMK; }
    public int getSks() { return sks; }
    public List<String> getPreSyarat() { return prasyarat; }
}