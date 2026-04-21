public class Robot implements MakhlukHidup {

    private String model;
    private int tahunProduksi;

    // Konstruktor Robot
    public Robot(String model, int tahunProduksi) {
        this.model = model;
        this.tahunProduksi = tahunProduksi;
    }

    @Override
    public void makan() {
        System.out.println("Robot tidak makan, tapi butuh listrik untuk isi daya.");
    }

    @Override
    public void berjalan() {
        System.out.println("Robot berjalan dengan roda atau mesin otomatis.");
    }

    @Override
    public void bersuara() {
        System.out.println("Robot bersuara dengan suara sintetis.");
    }

    public void tampilkanModel() {
        System.out.println("Model robot: " + this.model);
    }

    public void tampilkanTahunProduksi() {
        System.out.println("Tahun produksi: " + this.tahunProduksi);
    }
}