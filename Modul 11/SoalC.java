import java.util.*;

public class SoalC {

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

    static void cariMaxMin(String namaTim, List<Pemain> data) {

        // Comparator untuk tinggi badan
        Comparator<Pemain> byTinggi = Comparator.comparingInt(p -> p.tinggiBadan);

        // Comparator untuk berat badan
        Comparator<Pemain> byBerat = Comparator.comparingInt(p -> p.beratBadan);

        // Cari max dan min menggunakan Collections.max() dan Collections.min()
        Pemain tertinggi = Collections.max(data, byTinggi);
        Pemain terpendek = Collections.min(data, byTinggi);
        Pemain terberat  = Collections.max(data, byBerat);
        Pemain teringan  = Collections.min(data, byBerat);

        System.out.println( "==========  HASIL ANALISIS TIM " + namaTim + "  ==========");
        System.out.println( "  [TINGGI BADAN]                              ");
        System.out.printf ( "  Tertinggi : Pemain No.%-2d | %d cm | %d kg    %n",
            tertinggi.no, tertinggi.tinggiBadan, tertinggi.beratBadan);
        System.out.printf ( "  Terpendek : Pemain No.%-2d | %d cm | %d kg    %n",
            terpendek.no, terpendek.tinggiBadan, terpendek.beratBadan);
;
        System.out.println( "  [BERAT BADAN]                               ");
        System.out.printf ( "  Terberat  : Pemain No.%-2d | %d cm | %d kg    %n",
            terberat.no, terberat.tinggiBadan, terberat.beratBadan);
        System.out.printf ( "  Teringan  : Pemain No.%-2d | %d cm | %d kg    %n",
            teringan.no, teringan.tinggiBadan, teringan.beratBadan);
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

        cariMaxMin("A", timA);
        cariMaxMin("B", timB);
    }
}