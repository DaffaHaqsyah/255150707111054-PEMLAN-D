import java.util.*;

public class SoalB {

    static class Pemain {
        int no;
        String tim;
        int tinggiBadan;
        int beratBadan;

        Pemain(int no, String tim, int tinggi, int berat) {
            this.no = no;
            this.tim = tim;
            this.tinggiBadan = tinggi;
            this.beratBadan = berat;
        }
    }

    static void cetakTabel(String namaTim, String keterangan, List<Pemain> data) {
        System.out.println("\n  Tim : " + namaTim);
        System.out.println("  " + keterangan);
        System.out.println("| No   | Tim   | Tinggi (cm)    | Berat (kg)   |");
        for (int i = 0; i < data.size(); i++) {
            System.out.printf("| %-4d | %-5s | %-14d | %-12d |%n",
                i + 1, data.get(i).tim, data.get(i).tinggiBadan, data.get(i).beratBadan);
        }
    }

    public static void main(String[] args) {
        List<Pemain> timA = new ArrayList<>(Arrays.asList(
            new Pemain(1,  "A", 168, 50),
            new Pemain(2,  "A", 170, 60),
            new Pemain(3,  "A", 165, 56),
            new Pemain(4,  "A", 168, 55),
            new Pemain(5,  "A", 172, 60),
            new Pemain(6,  "A", 170, 70),
            new Pemain(7,  "A", 169, 66),
            new Pemain(8,  "A", 165, 56),
            new Pemain(9,  "A", 171, 72),
            new Pemain(10, "A", 166, 56)
        ));

        List<Pemain> timB = new ArrayList<>(Arrays.asList(
            new Pemain(1,  "B", 170, 66),
            new Pemain(2,  "B", 167, 60),
            new Pemain(3,  "B", 165, 59),
            new Pemain(4,  "B", 166, 58),
            new Pemain(5,  "B", 168, 58),
            new Pemain(6,  "B", 175, 71),
            new Pemain(7,  "B", 172, 68),
            new Pemain(8,  "B", 171, 68),
            new Pemain(9,  "B", 168, 65),
            new Pemain(10, "B", 169, 60)
        ));

        // --- TIM A ASCENDING ---
        Collections.sort(timA, (a, b) -> a.beratBadan - b.beratBadan);
        cetakTabel("A", "Berat Ascending (Menaik)", timA);

        // --- TIM A DESCENDING ---
        Collections.sort(timA, (a, b) -> b.beratBadan - a.beratBadan);
        cetakTabel("A", "Berat Descending (Menurun)", timA);

        // --- TIM B ASCENDING ---
        Collections.sort(timB, (a, b) -> a.beratBadan - b.beratBadan);
        cetakTabel("B", "Berat Ascending (Menaik)", timB);

        // --- TIM B DESCENDING ---
        Collections.sort(timB, (a, b) -> b.beratBadan - a.beratBadan);
        cetakTabel("B", "Berat Descending (Menurun)", timB);
    }
}