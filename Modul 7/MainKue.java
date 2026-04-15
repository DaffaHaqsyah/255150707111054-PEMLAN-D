public class MainKue {
    public static void main(String[] args) {
        Kue[] daftarKue = new Kue[20];
        
        daftarKue[0] = new KuePesanan("Lapis Legit", 20000, 2.5);
        daftarKue[1] = new KueJadi("Donat JCO", 10000, 12);
        daftarKue[2] = new KuePesanan("Brownies", 50000, 1.2);
        daftarKue[3] = new KueJadi("Roti Tawar", 15000, 2);
        daftarKue[4] = new KuePesanan("Bika Ambon", 45000, 0.8);
        daftarKue[5] = new KueJadi("Bakpia", 25000, 5);
        daftarKue[6] = new KuePesanan("Kue Lumpur", 5000, 10);
        daftarKue[7] = new KueJadi("Klepon", 2000, 20);
        daftarKue[8] = new KuePesanan("Risoles", 3000, 15);
        daftarKue[9] = new KueJadi("Pastel", 4000, 10);
        daftarKue[10] = new KuePesanan("Nagasari", 2500, 20);
        daftarKue[11] = new KueJadi("Onde-onde", 3000, 8);
        daftarKue[12] = new KuePesanan("Kue Cucur", 2000, 25);
        daftarKue[13] = new KueJadi("Putu Ayu", 1500, 30);
        daftarKue[14] = new KuePesanan("Kue Cubit", 15000, 0.5);
        daftarKue[15] = new KueJadi("Lemper", 4000, 15);
        daftarKue[16] = new KuePesanan("Kue Bugis", 3000, 12);
        daftarKue[17] = new KueJadi("Bolu Kukus", 5000, 6);
        daftarKue[18] = new KuePesanan("Dadargulung", 2500, 18);
        daftarKue[19] = new KueJadi("Terang Bulan", 35000, 1);

        double totalHargaSemua = 0;
        double totalHargaPesanan = 0, totalBeratPesanan = 0;
        double totalHargaJadi = 0, totalJumlahJadi = 0;
        Kue kueTermahal = daftarKue[0];

        System.out.println("=== DAFTAR SEMUA KUE ===");
        for (Kue k : daftarKue) {
            System.out.println(k);
            
            double hargaAkhir = k.hitungHarga();
            totalHargaSemua += hargaAkhir;

            if (k instanceof KuePesanan) {
                KuePesanan kp = (KuePesanan) k;
                totalHargaPesanan += hargaAkhir;
                totalBeratPesanan += kp.berat; 
            } else if (k instanceof KueJadi) {
                KueJadi kj = (KueJadi) k;
                totalHargaJadi += hargaAkhir;
                totalJumlahJadi += kj.jumlah;
            }

            if (hargaAkhir > kueTermahal.hitungHarga()) {
                kueTermahal = k;
            }
        }

        System.out.println("\n=== RESUME PERHITUNGAN ===");
        System.out.printf("Total Harga (Semua Jenis)   : Rp %.0f\n", totalHargaSemua);
        System.out.printf("Total Harga Kue Pesanan     : Rp %.0f\n", totalHargaPesanan);
        System.out.printf("Total Berat Kue Pesanan     : %.1f kg\n", totalBeratPesanan);
        System.out.printf("Total Harga Kue Jadi        : Rp %.0f\n", totalHargaJadi);
        System.out.printf("Total Jumlah Kue Jadi       : %.0f pcs\n", totalJumlahJadi);
        
        System.out.println("\n=== KUE DENGAN HARGA TERMAHAL ===");
        System.out.println(kueTermahal);
        System.out.printf("Harga Akhir: Rp %.0f\n", kueTermahal.hitungHarga());
    }
}