public class MahasiswaFILKOM extends Manusia {
    private String nim;
    private double ipk;

    public MahasiswaFILKOM(String nama, boolean jenisKelamin, String nik, boolean menikah,
        String nim, double ipk) {
        super(nama, jenisKelamin, nik, menikah);
        this.nim = nim;
        this.ipk = ipk;
    }

    public void setNim(String nim) { this.nim = nim; }
    public void setIpk(double ipk) { this.ipk = ipk; }
    public String getNim()         { return nim; }
    public double getIpk()         { return ipk; }

    public double getBeasiswa() {
        if (ipk >= 3.5 && ipk <= 4.0) return 75.0;
        if (ipk >= 3.0 && ipk < 3.5)  return 50.0;
        return 0.0;
    }

    public String getStatus() {
        if (nim == null || nim.length() < 7) return "NIM tidak valid";

        String angkatan = "20" + nim.substring(0, 2);
        char kodeProdi  = nim.charAt(6);

        String prodi;
        switch (kodeProdi) {
            case '2': prodi = "Teknik Informatika";             break;
            case '3': prodi = "Teknik Komputer";                break;
            case '4': prodi = "Sistem Informasi";               break;
            case '6': prodi = "Pendidikan Teknologi Informasi"; break;
            case '7': prodi = "Teknologi Informasi";            break;
            default:  prodi = "Prodi Tidak Dikenal";            break;
        }
        return prodi + ", " + angkatan;
    }

    @Override
    public double getPendapatan() {
        return super.getTunjangan() + getBeasiswa();
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
            String.format(
                "NIM           : %s\n" +
                "IPK           : %.2f\n" +
                "Status        : %s\n" +
                "Beasiswa      : $%.2f",
                nim, ipk, getStatus(), getBeasiswa()
            );
    }
}