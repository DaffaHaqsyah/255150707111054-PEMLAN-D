import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class Pemain {
    int no;
    int tinggi;
    int berat;
    String tim;

    public Pemain(int no, int tinggi, int berat, String tim) {
        this.no = no;
        this.tinggi = tinggi;
        this.berat = berat;
        this.tim = tim;
    }

    @Override
    public String toString() {
        return String.format(
            "Tim %s | No %-2d | Tinggi: %d cm | Berat: %d kg",
            tim, no, tinggi, berat
        );
    }
}


public class ProsesPencarian {

    public static void main(String[] args) {

        ArrayList<Pemain> timA = buatDataA();
        ArrayList<Pemain> timB = buatDataB();

        System.out.println("=== ANALISIS TIM B (Tinggi Badan) ===");
        cariFrekuensi(timB, "tinggi", 168);
        cariFrekuensi(timB, "tinggi", 160);

        System.out.println("\n=== ANALISIS TIM A (Berat Badan) ===");
        cariFrekuensi(timA, "berat", 56);
        cariFrekuensi(timA, "berat", 53);

        boolean tidakAdaYangSama = Collections.disjoint(timA, timB);

        System.out.println("\n=== PERBANDINGAN ANTAR TIM ===");
        System.out.println(
            "Apakah ada pemain yang sama persis? "
            + (!tidakAdaYangSama ? "Ya" : "Tidak")
        );
    }

    public static void cariFrekuensi(
            ArrayList<Pemain> list,
            String kriteria,
            int target
    ) {

        Comparator<Pemain> comp =
                kriteria.equals("tinggi")
                        ? Comparator.comparingInt(p -> p.tinggi)
                        : Comparator.comparingInt(p -> p.berat);

        Collections.sort(list, comp);

        Pemain dummy =
                kriteria.equals("tinggi")
                        ? new Pemain(0, target, 0, "")
                        : new Pemain(0, 0, target, "");

        int index = Collections.binarySearch(list, dummy, comp);

        if (index >= 0) {

            int jumlah = Collections.frequency(list, list.get(index));

            long count = list.stream()
                    .filter(p ->
                            (kriteria.equals("tinggi")
                                    ? p.tinggi
                                    : p.berat) == target
                    )
                    .count();

            System.out.println(
                "Jumlah pemain dengan "
                        + kriteria
                        + " "
                        + target
                        + " adalah: "
                        + count
            );

        } else {

            System.out.println(
                "Pemain dengan "
                        + kriteria
                        + " "
                        + target
                        + " tidak ditemukan."
            );
        }
    }

    private static ArrayList<Pemain> buatDataA() {

        ArrayList<Pemain> list = new ArrayList<>();

        int[][] data = {
            {1, 168, 50},
            {2, 170, 60},
            {3, 165, 56},
            {4, 168, 55},
            {5, 172, 60},
            {6, 170, 70},
            {7, 169, 66},
            {8, 165, 56},
            {9, 171, 72},
            {10, 166, 56}
        };

        for (int[] d : data) {
            list.add(new Pemain(d[0], d[1], d[2], "A"));
        }

        return list;
    }

    private static ArrayList<Pemain> buatDataB() {

        ArrayList<Pemain> list = new ArrayList<>();

        int[][] data = {
            {1, 170, 66},
            {2, 167, 60},
            {3, 165, 59},
            {4, 166, 58},
            {5, 168, 58},
            {6, 175, 71},
            {7, 172, 68},
            {8, 171, 68},
            {9, 168, 65},
            {10, 169, 60}
        };

        for (int[] d : data) {
            list.add(new Pemain(d[0], d[1], d[2], "B"));
        }

        return list;
    }
}