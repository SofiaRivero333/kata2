package software.ulpgc.katas;

import software.ulpgc.katas.io.FileGameReader;
import software.ulpgc.katas.io.GameReader;
import software.ulpgc.katas.io.SummaryWriter;
import software.ulpgc.katas.model.Game;
import software.ulpgc.katas.model.Platform;

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
            GameReader reader = new FileGameReader("games.tsv");
            GameSummary calculator = new GameSummary();
            SummaryWriter writer = new SummaryWriter();

            List<Game> fileGames = reader.load();

            System.out.println("Desde fichero:");
            writer.write(calculator.calculate(fileGames), System.out);

            byte[] data = Files.readAllBytes(Path.of("games.tsv"));
            List<Game> memoryGames;

            try (InputStream is = new ByteArrayInputStream(data)) {
                memoryGames = reader.loadFrom(is);
            }

            Map<Platform, Long> summary = calculator.calculate(memoryGames);

            System.out.println("\nDesde memoria:");
            writer.write(summary, System.out);

            try (OutputStream os = new FileOutputStream("games-summary.txt")) {
                writer.write(summary, os);
            }

            System.out.println("\nResumen guardado en games-summary.txt");
        } catch (IOException | RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}