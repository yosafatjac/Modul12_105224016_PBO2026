import java.util.List;

public class SistemReservasi {
    private KeretaRepository keretaRepository;
    private PenumpangValidator penumpangValidator;

    public SistemReservasi(KeretaRepository keretaRepository,
                           PenumpangValidator penumpangValidator) {
        this.keretaRepository = keretaRepository;
        this.penumpangValidator = penumpangValidator;
    }

    public List<KeretaApi> getJadwalKereta() {
        return keretaRepository.getSemuaKereta();
    }

    public PesananTiket pesanTiket(String kodeKereta, String nik, String namaPenumpang, int jumlahTiket)
            throws RuteTidakDitemukanException, TiketHabisException {

        penumpangValidator.validasiNIK(nik);

        KeretaApi kereta = keretaRepository.cariBerdasarkanKode(kodeKereta);

        if (jumlahTiket > kereta.getSisaKursi()) {
            throw new TiketHabisException(kereta.getNamaKereta(), kereta.getSisaKursi());
        }

        kereta.kurangiKursi(jumlahTiket);

        return new PesananTiket(namaPenumpang, nik, kereta, jumlahTiket);
    }
}