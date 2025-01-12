package UAS_PBO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemPenyewaan sistem = new SistemPenyewaan();

        // Tambah data iPhone
        iPhone iphone13 = new iPhone(1, "iPhone 13", 500000);
        iPhone iphone12 = new iPhone(2, "iPhone 12", 400000);
        sistem.tambahIPhone(iphone13);
        sistem.tambahIPhone(iphone12);

        // Tambah data pelanggan
        System.out.print("Masukkan ID Pelanggan: ");
        int idPelanggan = scanner.nextInt();
        scanner.nextLine(); // Bersihkan buffer
        System.out.print("Masukkan Nama Pelanggan: ");
        String namaPelanggan = scanner.nextLine();
        System.out.print("Masukkan Kontak Pelanggan: ");
        String kontakPelanggan = scanner.nextLine();
        Pelanggan pelanggan = new Pelanggan(idPelanggan, namaPelanggan, kontakPelanggan);
        sistem.tambahPelanggan(pelanggan);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Sewa iPhone");
            System.out.println("2. Kembalikan iPhone");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int opsi = scanner.nextInt();
            scanner.nextLine(); // Bersihkan buffer

            if (opsi == 1) {
                sewaIPhone(scanner, sistem, pelanggan);
            } else if (opsi == 2) {
                kembalikanIPhone(scanner, sistem);
            } else if (opsi == 3) {
                System.out.println("Terima kasih!");
                break;
            } else {
                System.out.println("Opsi tidak valid, silakan coba lagi.");
            }
        }

        scanner.close();
    }

    private static void sewaIPhone(Scanner scanner, SistemPenyewaan sistem, Pelanggan pelanggan) {
        sistem.tampilkanDaftarIPhone();
        System.out.print("Masukkan ID iPhone yang ingin disewa: ");
        int idIPhone = scanner.nextInt();
        iPhone iphoneDipilih = null;
        for (iPhone iphone : sistem.getDaftarIPhone()) {
            if (iphone.getId() == idIPhone) {
                iphoneDipilih = iphone;
                break;
            }
        }

        if (iphoneDipilih != null) {
            System.out.print("Masukkan durasi sewa (dalam hari): ");
            int durasi = scanner.nextInt();
            Pesanan pesanan = sistem.buatPesanan(pelanggan, iphoneDipilih, durasi);
            if (pesanan != null) {
                pesanan.tampilkanDetailPesanan();
            } else {
                System.out.println("iPhone tidak tersedia.");
            }
        } else {
            System.out.println("ID iPhone tidak ditemukan.");
        }
    }

    private static void kembalikanIPhone(Scanner scanner, SistemPenyewaan sistem) {
        System.out.print("Masukkan ID Pesanan yang ingin dikembalikan: ");
        int idPesanan = scanner.nextInt();
        Pesanan pesananDikembalikan = null;
        for (Pesanan pesanan : sistem.getDaftarPesanan()) {
            if (pesanan.getId() == idPesanan) {
                pesananDikembalikan = pesanan;
                break;
            }
        }

        if (pesananDikembalikan != null) {
            System.out.print("Apakah ada kerusakan pada iPhone? (ya/tidak): ");
            String adaKerusakan = scanner.next();
            Kerusakan kerusakan = null;
            if (adaKerusakan.equalsIgnoreCase("ya")) {
                System.out.print("Masukkan deskripsi kerusakan: ");
                scanner.nextLine(); // Bersihkan buffer
                String deskripsiKerusakan = scanner.nextLine();
                System.out.print("Masukkan biaya perbaikan: ");
                double biayaPerbaikan = scanner.nextDouble();
                kerusakan = new Kerusakan(deskripsiKerusakan, biayaPerbaikan);
            }

            pesananDikembalikan.kembalikaniPhone(kerusakan == null ? "Baik" : "Rusak", kerusakan);
            pesananDikembalikan.tampilkanDetailPesanan();
        } else {
            System.out.println("ID Pesanan tidak ditemukan.");
        }
    }
}
