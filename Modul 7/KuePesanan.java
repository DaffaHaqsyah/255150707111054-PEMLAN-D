class KuePesanan extends Kue {
    public double berat;

    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }

    public double hitungHarga() {
        return super.harga * berat;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Berat: %-5.1f | Jenis: Kue Pesanan", berat);
    }
}