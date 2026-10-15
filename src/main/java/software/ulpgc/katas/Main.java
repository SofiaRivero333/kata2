package software.ulpgc.katas;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        try (InputStream is = new FileInputStream("movies.tsv")) {
            byte[] bytes = is.readAllBytes();
            System.out.println("Bytes leidos: " + bytes.length);
        }
    }
}