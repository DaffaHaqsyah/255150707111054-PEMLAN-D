import java.util.Scanner;

public class MainJaket {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        jaket jaket = new jaket();

        System.out.println("=== CV. Labkomdas ===");

        System.out.print("Masukkan jumlah jaket A yang dibeli : ");
        int jumlahA = in.nextInt();

        System.out.print("Masukkan jumlah jaket B yang dibeli : ");
        int jumlahB = in.nextInt();

        System.out.print("Masukkan jumlah jaket C yang dibeli : ");
        int jumlahC = in.nextInt();

        double totalA = jaket.hitungHargaA(jumlahA);
        double totalB = jaket.hitungHargaB(jumlahB);
        double totalC = jaket.hitungHargaC(jumlahC);

        double totalBayar = totalA + totalB + totalC;

        System.out.println("\n=== Rincian Pembelian ===");
        System.out.println("Total harga jaket A (" + jumlahA + " buah) : Rp " + String.format("%.0f", totalA));
        System.out.println("Total harga jaket B (" + jumlahB + " buah) : Rp " + String.format("%.0f", totalB));
        System.out.println("Total harga jaket C (" + jumlahC + " buah) : Rp " + String.format("%.0f", totalC));
        System.out.println("========================");
        System.out.println("Total bayar           : Rp " + String.format("%.0f", totalBayar));
    }
}