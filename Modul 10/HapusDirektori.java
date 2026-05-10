import java.io.File;

public class HapusDirektori {

    public static void main(String[] args) {

        File folder = new File("Nyoba");

        if (folder.exists() && folder.isDirectory()) {

            File[] daftarFile = folder.listFiles();

            if (daftarFile != null) {

                for (File file : daftarFile) {

                    if (file.delete()) {

                        System.out.println("Terhapus: " + file.getName());

                    } else {

                        System.out.println(
                            "Gagal menghapus: " + file.getName()
                        );

                    }
                }
            }

            if (folder.delete()) {

                System.out.println(
                    "--- Direktori '" + folder.getName()
                    + "' berhasil dihapus ---"
                );

            } else {

                System.out.println(
                    "Gagal menghapus direktori. Pastikan tidak ada file yang sedang terbuka."
                );

            }

        } else {

            System.out.println(
                "Direktori tidak ditemukan atau bukan merupakan folder."
            );

        }
    }
}