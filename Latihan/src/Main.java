import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        KeretaRepository keretaRepository = new InMemoryKeretaRepository();
        PenumpangValidator penumpangValidator = new NIKPenumpangValidator();
        JadwalFormatter jadwalFormatter = new ConsoleJadwalFormatter();
        TiketFormatter tiketFormatter = new ConsoleTiketFormatter();

        SistemReservasi reservasi = new SistemReservasi(
                keretaRepository,
                penumpangValidator
        );

        boolean isRunning = true;

        System.out.println("Selamat datang di JAVA EXPRESS");
        System.out.println("Sistem Pemesanan Tiket Kereta Api");

        try {
            while (isRunning) {
                System.out.println("\nMenu Utama");
                System.out.println("1. Lihat Jadwal Kereta");
                System.out.println("2. Pesan Tiket");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu: ");

                try {
                    int pilihan = scanner.nextInt();
                    scanner.nextLine();

                    switch (pilihan) {
                        case 1:
                            System.out.println(jadwalFormatter.format(reservasi.getJadwalKereta()));
                            break;
                        case 2:
                            prosesPemesanan(scanner, reservasi, tiketFormatter);
                            break;
                        case 3:
                            isRunning = false;
                            break;
                        default:
                            System.out.println("Pilihan tidak valid. Masukkan angka 1, 2, atau 3.");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Input tidak valid! Harap masukkan angka.");
                    scanner.nextLine();
                }
            }
        } finally {
            System.out.println("\nTerima kasih telah menggunakan JAVA EXPRESS.");
            System.out.println("Sampai jumpa!");
            scanner.close();
        }
    }

    private static void prosesPemesanan(Scanner scanner,
                                        SistemReservasi reservasi,
                                        TiketFormatter tiketFormatter) {
        System.out.println("\nForm Pemesanan Tiket");

        try {
            System.out.print("Kode Kereta    : ");
            String kode = scanner.nextLine().trim().toUpperCase();

            System.out.print("NIK Penumpang  : ");
            String nik = scanner.nextLine().trim();

            System.out.print("Nama Penumpang : ");
            String nama = scanner.nextLine().trim();

            System.out.print("Jumlah Tiket   : ");
            int jumlah = scanner.nextInt();
            scanner.nextLine();

            PesananTiket pesanan = reservasi.pesanTiket(kode, nik, nama, jumlah);
            System.out.println(tiketFormatter.format(pesanan));

        } catch (InputMismatchException e) {
            System.out.println("Jumlah tiket harus berupa angka!");
            scanner.nextLine();

        } catch (DataPenumpangTidakValidException e) {
            System.out.println("Data tidak valid: " + e.getMessage());

        } catch (RuteTidakDitemukanException e) {
            System.out.println("Rute tidak ditemukan: " + e.getMessage());

        } catch (TiketHabisException e) {
            System.out.println("Tiket tidak mencukupi: " + e.getMessage());
            System.out.println("Coba kurangi jumlah tiket atau pilih kereta lain.");
        }
    }
}