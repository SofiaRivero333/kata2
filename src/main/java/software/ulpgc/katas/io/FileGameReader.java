package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Game;
import software.ulpgc.katas.model.Platform;

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

public class FileGameReader implements GameReader {
    private final String filename;

    public FileGameReader(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Game> load() {
        try {
            try (InputStream is = new FileInputStream(filename)) {
                return loadFrom(is);
            }
        } catch (IOException e) {
            throw new RuntimeException(
                    "No se pudo leer el fichero: " + filename, e
            );
        }
    }

    @Override
    public List<Game> loadFrom(InputStream is) throws IOException {
        return loadFrom(new InputStreamReader(is, StandardCharsets.UTF_8));
    }

    private List<Game> loadFrom(Reader reader) throws IOException {
        return loadFrom(new BufferedReader(reader).lines().toList());
    }

    private List<Game> loadFrom(List<String> lines) {
        return IntStream.range(1, lines.size())
                .mapToObj(i -> loadFrom(lines.get(i)))
                .collect(Collectors.toList());
    }

    private Game loadFrom(String line) {
        return loadFrom(line.split("\t", -1));
    }

    private Game loadFrom(String[] fields) {
        if (fields.length != 2 || fields[0].isBlank()) {
            throw new IllegalArgumentException(
                    "Fila invalida: se esperaban un nombre y una plataforma."
            );
        }

        return new Game(fields[0], platformOf(fields[1]));
    }

    private static Platform platformOf(String field) {
        return field.isEmpty() || field.equals("\\N")
                ? Platform.Unknown
                : Platform.valueOf(field);
    }
}