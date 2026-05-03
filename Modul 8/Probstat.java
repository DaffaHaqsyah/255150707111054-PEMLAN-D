// Rumus : Tugas 20% + Kuis 20% + UTS 25% + UAS 35%
public class Probstat extends MataKuliah {
    public Probstat() { super("Probstat"); }

    @Override
    public double hitungNilaiAkhir() {
        return tugas * 0.20 + kuis * 0.20 + uts * 0.25 + uas * 0.35;
    }

}