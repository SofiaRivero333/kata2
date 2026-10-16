package software.ulpgc.katas;

import software.ulpgc.katas.io.BookReader;
import software.ulpgc.katas.io.FileBookReader;
import software.ulpgc.katas.io.SummaryWriter;
import software.ulpgc.katas.model.Book;
import software.ulpgc.katas.model.Genre;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            BookReader reader = new FileBookReader("books.tsv");
            BookSummary calculator = new BookSummary();
            SummaryWriter writer = new SummaryWriter();

            List<Book> fileBooks = reader.load();

            System.out.println("Desde fichero:");
            writer.write(
                    calculator.calculate(fileBooks),
                    System.out
            );

            byte[] data = Files.readAllBytes(Path.of("books.tsv"));

            List<Book> memoryBooks;

            try (InputStream is = new ByteArrayInputStream(data)) {
                memoryBooks = reader.loadFrom(is);
            }

            Map<Genre, Long> summary =
                    calculator.calculate(memoryBooks);

            System.out.println("\nDesde memoria:");
            writer.write(summary, System.out);

            try (
                    OutputStream os =
                            new FileOutputStream("books-summary.txt")
            ) {
                writer.write(summary, os);
            }

            System.out.println(
                    "\nResumen guardado en books-summary.txt"
            );

        } catch (IOException | RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}