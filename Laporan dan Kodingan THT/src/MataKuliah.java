import java.util.List;

// Interface dasar untuk semua jenis mata kuliah — hanya berisi operasi umum (ISP)
public interface MataKuliah {
    String getNamaMK();
    int getSks();
    List<String> getPreSyarat();
}