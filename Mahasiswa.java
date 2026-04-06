public class Mahasiswa {
    private String nama;
    private int kataPerHari;

    public Mahasiswa(String nama, int kataPerHari) {
        this.nama = nama;
        this.kataPerHari = kataPerHari;
    }

    public String getNama() { return nama; }
    public int getKataPerHari() { return kataPerHari; }

    public String toString() {
        return nama + " (menulis " + kataPerHari + " kata/hari)";
    }
}
