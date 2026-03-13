import java.util.Scanner;

public class Bank {
    private String nama;
    private String noRekening;
    private String password;
    private double saldo;
    private Scanner scanner;

    public Bank(String nama, String noRekening, String password, double saldo) {
        this.nama = nama;
        this.noRekening = noRekening;
        this.password = password;
        this.saldo = saldo;
        this.scanner = new Scanner(System.in);
    }

    public String getNama() {
        return nama;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    private boolean validasiPassword() {
        System.out.print("Masukkan password: ");
        String inputPassword = scanner.nextLine();
        if (!this.password.equals(inputPassword)) {
            System.out.println("Password salah!");
            return false;
        }
        return true;
    }

    private String formatSaldo(double jumlah) {
        return "Rp " + String.format("%,.0f", jumlah);
    }

    public void cekSaldo() {
        if (!validasiPassword()) return;
        System.out.println("Saldo Anda: " + formatSaldo(getSaldo()));
    }

    public void tarikTunai() {
        if (!validasiPassword()) return;
        System.out.print("Masukkan jumlah tarik tunai: Rp ");
        double jumlah = scanner.nextDouble();
        scanner.nextLine();
        if (jumlah <= 0) {
            System.out.println("Jumlah tidak valid!");
        } else if (getSaldo() - jumlah < 0) {
            System.out.println("Saldo tidak cukup! Saldo Anda: " + formatSaldo(getSaldo()));
        } else {
            setSaldo(getSaldo() - jumlah);
            System.out.println("Tarik tunai berhasil! Saldo sekarang: " + formatSaldo(getSaldo()));
        }
    }

    public void lihatInfo() {
        if (!validasiPassword()) return;
        System.out.println("=== Info Nasabah ===");
        System.out.println("Nama Nasabah : " + getNama());
        System.out.println("No Rekening  : " + getNoRekening());
        System.out.println("Saldo        : " + formatSaldo(getSaldo()));
    }

    public void jalankan() {
        int pilihan = 0;
        do {
            System.out.println("=== Menu Bank Indonesia ===");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Tarik Tunai");
            System.out.println("3. Lihat Info Nasabah");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    cekSaldo();
                    break;
                case 2:
                    tarikTunai();
                    break;
                case 3:
                    lihatInfo();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
            System.out.println();

        } while (pilihan != 4);

        scanner.close();
    }

}
