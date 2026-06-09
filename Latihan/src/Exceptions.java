class DataPenumpangTidakValidException extends RuntimeException {
    public DataPenumpangTidakValidException(String pesan) {
        super(pesan);
    }
}

class RuteTidakDitemukanException extends Exception {
    public RuteTidakDitemukanException(String kodeKereta) {
        super("Rute dengan kode kereta '" + kodeKereta + "' tidak ditemukan dalam sistem.");
    }
}

class TiketHabisException extends Exception {
    private String namaKereta;
    private int sisaKursi;

    public TiketHabisException(String namaKereta, int sisaKursi) {
        super("Tiket untuk kereta '" + namaKereta + "' tidak mencukupi. "
                + "Sisa kursi tersedia: " + sisaKursi);
        this.namaKereta = namaKereta;
        this.sisaKursi = sisaKursi;
    }

    public String getNamaKereta() {
        return namaKereta;
    }

    public int getSisaKursi() {
        return sisaKursi;
    }
}