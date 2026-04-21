import java.util.Scanner;

public class MainIdentitas {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Input untuk Manusia
        System.out.print("Masukkan nama manusia: ");
        String namaManusia = input.nextLine();
        System.out.print("Masukkan umur manusia: ");
        int umurManusia = input.nextInt();
        input.nextLine();

        Manusia m = new Manusia(namaManusia, umurManusia);

        // Input untuk Hewan
        System.out.print("Masukkan nama hewan: ");
        String namaHewan = input.nextLine();
        System.out.print("Masukkan umur hewan: ");
        int umurHewan = input.nextInt();
        input.nextLine();

        Hewan h = new Hewan(namaHewan, umurHewan);

        // Input untuk Robot
        System.out.print("Masukkan model robot: ");
        String modelRobot = input.nextLine();
        System.out.print("Masukkan tahun produksi robot: ");
        int tahunRobot = input.nextInt();
        input.nextLine();

        Robot r = new Robot(modelRobot, tahunRobot);

        System.out.println("\n=== Data Manusia ===");
        m.makan();
        m.berjalan();
        m.bersuara();
        m.tampilkanNama();
        m.tampilkanUmur();

        System.out.println("\n=== Data Hewan ===");
        h.makan();
        h.berjalan();
        h.bersuara();
        h.tampilkanNama();
        h.tampilkanUmur();

        System.out.println("\n=== Data Robot ===");
        r.makan();
        r.berjalan();
        r.bersuara();
        r.tampilkanModel();
        r.tampilkanTahunProduksi();

        input.close();
    }
}