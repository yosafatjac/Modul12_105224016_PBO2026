class KeretaApi {
    private String kodeKereta;
    private String namaKereta;
    private String rute;
    private int sisaKursi;

    public KeretaApi(String kodeKereta, String namaKereta, String rute, int kapasitas) {
        this.kodeKereta = kodeKereta;
        this.namaKereta = namaKereta;
        this.rute = rute;
        this.sisaKursi = kapasitas;
    }

    public String getKodeKereta() {
        return kodeKereta;
    }

    public String getNamaKereta() {
        return namaKereta;
    }

    public String getRute() {
        return rute;
    }

    public int getSisaKursi() {
        return sisaKursi;
    }

    public void kurangiKursi(int jumlah) {
        this.sisaKursi -= jumlah;
    }
}

class PesananTiket {
    private String namaPenumpang;
    private String nik;
    private KeretaApi kereta;
    private int jumlahTiket;

    public PesananTiket(String namaPenumpang, String nik, KeretaApi kereta, int jumlahTiket) {
        this.namaPenumpang = namaPenumpang;
        this.nik = nik;
        this.kereta = kereta;
        this.jumlahTiket = jumlahTiket;
    }

    public String getNamaPenumpang() {
        return namaPenumpang;
    }

    public String getNik() {
        return nik;
    }

    public KeretaApi getKereta() {
        return kereta;
    }

    public int getJumlahTiket() {
        return jumlahTiket;
    }
}