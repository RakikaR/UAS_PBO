// Kelas SistemPenyewaan
package UAS_PBO;
import java.util.ArrayList;
import java.util.List;

class SistemPenyewaan {
    private List<iPhone> daftarIPhone = new ArrayList<>();
    private List<Pesanan> daftarPesanan = new ArrayList<>();
    private List<Pelanggan> daftarPelanggan = new ArrayList<>();

    public void tambahIPhone(iPhone iphone) {
        daftarIPhone.add(iphone);
    }

    public void tambahPelanggan(Pelanggan pelanggan) {
        daftarPelanggan.add(pelanggan);
    }

    public List<iPhone> getDaftarIPhone() { // Tambahkan metode ini
        return daftarIPhone;
    }

    public List<Pesanan> getDaftarPesanan() { // Tambahkan metode ini
        return daftarPesanan;
    }

    public void tampilkanDaftarIPhone() {
        System.out.println("Daftar iPhone Tersedia:");
        for (iPhone iphone : daftarIPhone) {
            System.out.println("- " + iphone);
        }
    }

    public void tampilkanDaftarPesanan() {
        System.out.println("Daftar Pesanan:");
        for (Pesanan pesanan : daftarPesanan) {
            pesanan.tampilkanDetailPesanan();
        }
    }

    public Pesanan buatPesanan(Pelanggan pelanggan, iPhone iphone, int durasi) {
        if (daftarIPhone.remove(iphone)) { // Menghapus iPhone dari daftar saat disewa
            Pesanan pesanan = new Pesanan(daftarPesanan.size() + 1, pelanggan, iphone, durasi);
            daftarPesanan.add(pesanan);
            return pesanan;
        }
        return null; // Jika iPhone tidak ada di daftar, kembalikan null
    }
}