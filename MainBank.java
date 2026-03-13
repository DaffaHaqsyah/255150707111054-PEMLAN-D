public class MainBank {
    public static void main(String[] args) {
        Bank atm = new Bank("Muhammad Daffa Haqsyah", "2244896743", "Bank2025", 10000000);

        System.out.println("Selamat datang, " + atm.getNama() + "!");
        System.out.println("No Rekening  : " + atm.getNoRekening());
        System.out.println();

        atm.jalankan();
    }
}