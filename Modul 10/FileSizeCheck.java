import java.io.File;

public class FileSizeCheck {

    public static void main(String[] args) {

        var file = new File("test.txt");

        if (file.exists()) {

            long sizeInBytes = file.length(); // ukuran file dalam byte
            System.out.println("Ukuran file: " + sizeInBytes + " bytes");

            if (sizeInBytes < 1024 * 1024) {

                // jika ukuran < 1 MB → tampilkan dalam KB
                double sizeInKB = sizeInBytes / 1024.0;

                System.out.printf("Format Output: %.2f KB%n", sizeInKB);

            } else {

                // jika ukuran >= 1 MB → tampilkan dalam MB
                double sizeInMB = sizeInBytes / (1024.0 * 1024.0);

                System.out.printf("Ukuran file: %.2f MB%n", sizeInMB);

            }

        } else {

            System.out.println("File tidak ditemukan.");

        }
    }
}