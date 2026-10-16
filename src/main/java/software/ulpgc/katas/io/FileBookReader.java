package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Book;
import software.ulpgc.katas.model.Genre;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FileBookReader implements BookReader {
    private final String filename;

    public FileBookReader(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Book> load() {
        try {
            try (InputStream is = new FileInputStream(filename)) {
                return loadFrom(is);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> loadFrom(InputStream is) throws IOException {
        return loadFrom(
                new InputStreamReader(is, StandardCharsets.UTF_8)
        );
    }

    private List<Book> loadFrom(Reader reader) throws IOException {
        return loadFrom(new BufferedReader(reader).lines().toList());
    }

    private List<Book> loadFrom(List<String> lines) {
        return IntStream.range(1, lines.size())
                .mapToObj(i -> loadFrom(lines.get(i)))
                .collect(Collectors.toList());
    }

    private Book loadFrom(String line) {
        return loadFrom(line.split("\t", -1));
    }

    private Book loadFrom(String[] fields) {
        if (fields.length != 2 || fields[0].isBlank()) {
            throw new IllegalArgumentException(
                    "Fila invalida: se esperaban un nombre y un genero."
            );
        }

        return new Book(fields[0], genreOf(fields[1]));
    }

    private static Genre genreOf(String field) {
        return field.isEmpty() || field.equals("\\N")
                ? Genre.Unknown
                : Genre.valueOf(field);
    }
}