// Kelas Pesanan
package UAS_PBO;
import java.util.Date;

class Pesanan {
    private int id;
    private Pelanggan pelanggan;
    private iPhone iphone;
    private Date tanggalPemesanan;
    private int durasi;
    private double totalBiaya;
    private Kerusakan kerusakan;

    public Pesanan(int id, Pelanggan pelanggan, iPhone iphone, int durasi) {
        this.id = id;
        this.pelanggan = pelanggan;
        this.iphone = iphone;
        this.durasi = durasi;
        this.totalBiaya = durasi * iphone.getHargaSewa();
        this.tanggalPemesanan = new Date(); // Mengatur tanggal pemesanan saat objek dibuat
    }

    public int getId() { // Tambahkan metode ini
        return id;
    }

    public void kembalikaniPhone(String kondisi, Kerusakan kerusakan) {
        iphone.setKondisi(kondisi);
        this.kerusakan = kerusakan;
        if (kerusakan != null) {
            this.totalBiaya += kerusakan.getBiayaPerbaikan();
        }
    }

    public void tampilkanDetailPesanan() {
        System.out.println("Pesanan #" + id);
        System.out.println("Pelanggan: " + pelanggan.getNama());
        System.out.println("iPhone: " + iphone.getModel());
        System.out.println("Tanggal Pemesanan: " + tanggalPemesanan);
        System.out.println("Durasi: " + durasi + " hari");
        System.out.println("Total Biaya: Rp " + totalBiaya);
        if (kerusakan != null) {
            System.out.println("Kerusakan: " + kerusakan);
        }
    }
}