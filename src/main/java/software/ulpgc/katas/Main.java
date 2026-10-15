package software.ulpgc.katas;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        try (InputStream is = new FileInputStream("movies.tsv")) {
            String text = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            System.out.print(text);
        }
    }
}