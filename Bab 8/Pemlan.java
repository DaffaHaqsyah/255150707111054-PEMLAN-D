// Rumus : Tugas 20% + Kuis 15% + UTS 30% + UAS 35%
public class Pemlan extends MataKuliah {
    public Pemlan() { super("Pemlan"); }

    @Override
    public double hitungNilaiAkhir() {
        return tugas * 0.20 + kuis * 0.15 + uts * 0.30 + uas * 0.35;
    }

}