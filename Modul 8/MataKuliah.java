public abstract class MataKuliah {
    protected String nama;
    protected double tugas, kuis, uts, uas, nilaiAkhir;

    MataKuliah(String nama) { this.nama = nama; }

    void setNilai(double t, double k, double u1, double u2) {
        tugas = t; kuis = k; uts = u1; uas = u2;
        nilaiAkhir = hitungNilaiAkhir();
    }

    public abstract double hitungNilaiAkhir(); // nama method abstract

    String getGrade() {
        if (nilaiAkhir >= 85) {
            return "A";
        } else if (nilaiAkhir >= 75) {
            return "B";
        } else if (nilaiAkhir >= 65) {
            return "C";
        } else if (nilaiAkhir >= 55) {
            return "D";
        } else {
            return "E";
        }
    }
}