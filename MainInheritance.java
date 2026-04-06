import java.time.LocalDate;

public class MainInheritance {
    public static void main(String[] args) {
        Manusia manusia1 = new Manusia("Budi Santoso", true, "3174051204900001", true);
        
        MahasiswaFILKOM mhs1 = new MahasiswaFILKOM(
            "Ayu Wijaya", false, "3273056505030002", false,
            "225150207", 3.78
        );
        
        Pekerja pekerja1 = new Pekerja(
            "Citra Dewi", false, "3578046708950003", true,
            5000000, LocalDate.of(2018, 3, 15), 2
        );
        
        Manajer manajer1 = new Manajer(
            "Dian Pratama", true, "3671021509880004", true,
            8500000, LocalDate.of(2015, 6, 10), 3, "IT"
        );
        
        System.out.println(manusia1);
        System.out.println();
        System.out.println(mhs1);
        System.out.println();
        System.out.println(pekerja1);
        System.out.println();
        System.out.println(manajer1);
    }
}