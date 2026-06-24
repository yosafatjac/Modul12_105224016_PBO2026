// Interface tambahan khusus MK yang memiliki kegiatan lab (ISP)
// Dipisahkan agar kelas Teori dan KKN tidak dipaksa mengimplementasikannya
public interface Praktikumable {
    void alokasiAsistenLab();
    void cekPeralatanPraktikum();
}