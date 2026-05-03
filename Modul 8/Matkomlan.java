// Rumus : Tugas 15% + Kuis 10% + UTS 35% + UAS 40%
public class Matkomlan extends MataKuliah {
    public Matkomlan() { super("Matkomlan"); }

    @Override
    public double hitungNilaiAkhir() {
        return tugas * 0.15 + kuis * 0.10 + uts * 0.35 + uas * 0.40;
    }

}