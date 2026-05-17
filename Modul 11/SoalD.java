import java.util.ArrayList;
import java.util.Collections;

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


public class SoalD {
    public static void main(String[] args) {

        ArrayList<Pemain> timB = new ArrayList<>();

        int[][] dataB = {
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

        for (int[] d : dataB) {
            timB.add(new Pemain(d[0], d[1], d[2], "B"));
        }

        ArrayList<Pemain> timC =
            new ArrayList<>(Collections.nCopies(timB.size(), null));

        Collections.copy(timC, timB);

        System.out.println(
            "========== DAFTAR ANGGOTA TIM C =========="
        );

        timC.forEach(System.out::println);
    }
}