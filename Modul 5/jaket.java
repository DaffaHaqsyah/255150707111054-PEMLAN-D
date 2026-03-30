public class jaket {

    private final double hargaA = 100000;
    private final double hargaB = 125000;
    private final double hargaC = 175000;

    private final double diskonA = 95000;
    private final double diskonB = 120000;
    private final double diskonC = 160000;

    public double hitungHargaA(int jumlah) {
        double total = 0;
        if (jumlah > 100) {
            total = jumlah * diskonA;
        } else {
            total = jumlah * hargaA;
        }
        return total;
    }

    public double hitungHargaB(int jumlah) {
        double total = 0;
        if (jumlah > 100) {
            total = jumlah * diskonB;
        } else {
            total = jumlah * hargaB;
        }
        return total;
    }

    public double hitungHargaC(int jumlah) {
        double total = 0;
        if (jumlah > 100) {
            total = jumlah * diskonC;
        } else {
            total = jumlah * hargaC;
        }
        return total;
    }
}