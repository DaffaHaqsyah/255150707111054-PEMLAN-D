import java.time.LocalDate;

public class Manajer extends Pekerja {
    private String departemen;

    public Manajer(String nama, boolean jenisKelamin, String nik, boolean menikah,
        double gaji, LocalDate tahunMasuk, int jumlahAnak, String departemen) {
        super(nama, jenisKelamin, nik, menikah, gaji, tahunMasuk, jumlahAnak);
        this.departemen = departemen;
    }

    public void setDepartemen(String departemen) { this.departemen = departemen; }
    public String getDepartemen()                { return departemen; }

    @Override
    public double getTunjangan() {
        return super.getTunjangan() + (getGajiPokok() * 0.10);
    }

    @Override
    public double getPendapatan() {
        return getGajiPokok() + getBonus() + getTunjangan();
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
            String.format(
                "Departemen    : %s",
                departemen
            );
    }
}