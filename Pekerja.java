import java.time.LocalDate;
import java.time.Period;

public class Pekerja extends Manusia {
    private double gaji;
    private LocalDate tahunmasuk;
    private int jumlahAnak;

    public Pekerja(String nama, boolean jenisKelamin, String nik, boolean menikah,
        double gaji, LocalDate tahunmasuk, int jumlahAnak) {
        super(nama, jenisKelamin, nik, menikah);
        this.gaji = gaji;
        this.tahunmasuk = tahunmasuk;
        this.jumlahAnak = jumlahAnak;
    }

    public void setGaji(double gaji)                { this.gaji = gaji; }
    public void setTahunMasuk(LocalDate tahunmasuk) { this.tahunmasuk = tahunmasuk; }
    public void setJumlahAnak(int jumlahAnak)       { this.jumlahAnak = jumlahAnak; }

    public double getGajiPokok()     { return gaji; }
    public LocalDate getTahunMasuk() { return tahunmasuk; }
    public int getJumlahAnak()       { return jumlahAnak; }

    public int getLamaKerja() {
        return Period.between(tahunmasuk, LocalDate.now()).getYears();
    }

    public double getBonus() {
        int lamaKerja = getLamaKerja();
        if (lamaKerja >= 10)     return gaji * 0.15;
        else if (lamaKerja >= 5) return gaji * 0.10;
        else                     return gaji * 0.05;
    }

    @Override
    public double getTunjangan() {
        return super.getTunjangan() + (jumlahAnak * 20.0);
    }

    @Override
    public double getPendapatan() {
        return gaji + getBonus() + getTunjangan();
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
            String.format(
                "Gaji          : $%.2f\n" +
                "Tahun Masuk   : %d\n" +
                "Jumlah Anak   : %d\n" +
                "Bonus         : $%.2f",
                gaji, tahunmasuk.getYear(), jumlahAnak, getBonus()
            );
    }
}