package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Movie;
import software.ulpgc.katas.model.Rating;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UrlMovieReader implements MovieReader {
    private final URL url;

    public UrlMovieReader(URL url) {
        this.url = url;
    }

    @Override
    public List<Movie> load() {
        try {
            try (InputStream is = url.openStream()) {
                return loadFrom(is);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Movie> loadFrom(InputStream is) throws IOException {
        return loadFrom(
                new InputStreamReader(is, StandardCharsets.UTF_8)
        );
    }

    private List<Movie> loadFrom(Reader reader) throws IOException {
        return loadFrom(new BufferedReader(reader).lines().toList());
    }

    private List<Movie> loadFrom(List<String> lines) {
        return IntStream.range(1, lines.size())
                .mapToObj(i -> loadFrom(lines.get(i)))
                .collect(Collectors.toList());
    }

    private Movie loadFrom(String line) {
        return loadFrom(line.split("\t", -1));
    }

    private Movie loadFrom(String[] fields) {
        if (fields.length != 7) {
            throw new IllegalArgumentException(
                    "Fila invalida: se esperaban 7 columnas."
            );
        }

        return new Movie(
                fields[1],
                ratingOf(fields[3])
        );
    }

    private static Rating ratingOf(String field) {
        return field.isEmpty() || field.equals("\\N")
                ? Rating.Unknown
                : Rating.valueOf(field.replace("-", ""));
    }
}