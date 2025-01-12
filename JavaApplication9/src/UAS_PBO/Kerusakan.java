// Kelas Kerusakan
package UAS_PBO;

class Kerusakan {
    private String deskripsi;
    private double biayaPerbaikan;

    public Kerusakan(String deskripsi, double biayaPerbaikan) {
        this.deskripsi = deskripsi;
        this.biayaPerbaikan = biayaPerbaikan;
    }

    public double getBiayaPerbaikan() {
        return biayaPerbaikan;
    }

    @Override
    public String toString() {
        return deskripsi + " (Biaya: Rp " + biayaPerbaikan + ")";
    }
}