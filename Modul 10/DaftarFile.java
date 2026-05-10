import java.io.File;

public class DaftarFile {

    public static void main(String[] args) {

        var directory = new File("D:\\Tugas\\File Belajar");

        if (directory.exists() && directory.isDirectory()) {

            File[] files = directory.listFiles();

            System.out.println("Daftar file di dalam direktori:");

            for (var file : files) {
                if (file.isDirectory()) {
                    System.out.println("[FOLDER] " + file.getName());
                } else {
                    System.out.println("[FILE]   " + file.getName());
                }
            }

        } else {
            System.out.println("Direktori tidak ditemukan.");
        }
    }
}