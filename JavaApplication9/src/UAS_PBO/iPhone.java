// Kelas iPhone
package UAS_PBO;

class iPhone {
    private int id;
    private String model;
    private double hargaSewa;
    private String kondisi;

    public iPhone(int id, String model, double hargaSewa) {
        this.id = id;
        this.model = model;
        this.hargaSewa = hargaSewa;
        this.kondisi = "Baik"; // Default
    }

    public String getModel() {
        return model;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public double getHargaSewa() {
        return hargaSewa;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return model + " (Kondisi: " + kondisi + ")";
    }
}