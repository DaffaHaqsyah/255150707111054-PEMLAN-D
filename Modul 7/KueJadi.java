public class KueJadi extends Kue {
    public double jumlah;

    public KueJadi(String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    @Override
    public double hitungHarga() {
        return super.harga * jumlah;
    }

    @Override
    public String toString() {  
        return super.toString() + String.format(" | Jumlah: %-5.0f | Jenis: Kue Jadi", jumlah);
    }
}