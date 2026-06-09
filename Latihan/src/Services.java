import java.util.ArrayList;
import java.util.List;

interface KeretaRepository {
    List<KeretaApi> getSemuaKereta();
    KeretaApi cariBerdasarkanKode(String kodeKereta) throws RuteTidakDitemukanException;
}

interface PenumpangValidator {
    void validasiNIK(String nik);
}

interface JadwalFormatter {
    String format(List<KeretaApi> daftarKereta);
}

interface TiketFormatter {
    String format(PesananTiket pesanan);
}

class InMemoryKeretaRepository implements KeretaRepository {
    private List<KeretaApi> daftarKereta = new ArrayList<>();

    public InMemoryKeretaRepository() {
        daftarKereta.add(new KeretaApi("K01", "Argo Bromo", "JKT - SBY", 50));
        daftarKereta.add(new KeretaApi("K02", "Parahyangan", "JKT - BDG", 15));
    }

    @Override
    public List<KeretaApi> getSemuaKereta() {
        return daftarKereta;
    }

    @Override
    public KeretaApi cariBerdasarkanKode(String kodeKereta) throws RuteTidakDitemukanException {
        for (KeretaApi kereta : daftarKereta) {
            if (kereta.getKodeKereta().equalsIgnoreCase(kodeKereta)) {
                return kereta;
            }
        }

        throw new RuteTidakDitemukanException(kodeKereta);
    }
}

class NIKPenumpangValidator implements PenumpangValidator {
    @Override
    public void validasiNIK(String nik) {
        if (nik.length() != 16) {
            throw new DataPenumpangTidakValidException(
                    "NIK tidak valid! Harus tepat 16 karakter. "
                    + "NIK Anda memiliki " + nik.length() + " karakter."
            );
        }

        if (!nik.matches("\\d+")) {
            throw new DataPenumpangTidakValidException(
                    "NIK tidak valid! NIK hanya boleh mengandung angka."
            );
        }
    }
}

class ConsoleJadwalFormatter implements JadwalFormatter {
    @Override
    public String format(List<KeretaApi> daftarKereta) {
        StringBuilder output = new StringBuilder();

        output.append("\nJADWAL KERETA JAVA EXPRESS\n");
        output.append(String.format("%-6s  %-20s  %-12s  %s%n",
                "Kode", "Nama Kereta", "Rute", "Sisa Kursi"));

        for (KeretaApi kereta : daftarKereta) {
            output.append(String.format("%-6s  %-20s  %-12s  %d kursi%n",
                    kereta.getKodeKereta(),
                    kereta.getNamaKereta(),
                    kereta.getRute(),
                    kereta.getSisaKursi()));
        }

        return output.toString();
    }
}

class ConsoleTiketFormatter implements TiketFormatter {
    @Override
    public String format(PesananTiket pesanan) {
        KeretaApi kereta = pesanan.getKereta();

        return "\nPemesanan berhasil!\n"
                + String.format("Penumpang  : %s%n", pesanan.getNamaPenumpang())
                + String.format("NIK        : %s%n", pesanan.getNik())
                + String.format("Kereta     : %s%n", kereta.getNamaKereta())
                + String.format("Rute       : %s%n", kereta.getRute())
                + String.format("Jumlah     : %d tiket%n", pesanan.getJumlahTiket())
                + String.format("Sisa Kursi : %d kursi%n", kereta.getSisaKursi());
    }
}