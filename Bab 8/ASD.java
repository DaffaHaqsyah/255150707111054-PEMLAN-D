// Rumus : Tugas 15% + Kuis 20% + UTS 30% + UAS 35%
public class ASD extends MataKuliah {
    public ASD() { super("ASD"); }

    @Override
    public double hitungNilaiAkhir() {
        return tugas * 0.15 + kuis * 0.20 + uts * 0.30 + uas * 0.35;
    }

}