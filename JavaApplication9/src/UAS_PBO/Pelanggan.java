// Kelas Pelanggan
package UAS_PBO;
class Pelanggan {
    private int id;
    private String nama;
    private String kontak;

    public Pelanggan(int id, String nama, String kontak) {
        this.id = id;
        this.nama = nama;
        this.kontak = kontak;
    }

    public String getNama() {
        return nama;
    }
}