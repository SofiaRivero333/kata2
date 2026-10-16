package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Genre;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class SummaryWriter {

    public void write(
            Map<Genre, Long> summary,
            OutputStream output
    ) throws IOException {

        StringBuilder text = new StringBuilder();

        if (summary.isEmpty()) {
            text.append("Sin libros.\n");
        } else {
            text.append("Libros por genero:\n");

            summary.forEach((genre, count) ->
                    text.append(genre)
                            .append(": ")
                            .append(count)
                            .append('\n')
            );
        }

        output.write(
                text.toString().getBytes(StandardCharsets.UTF_8)
        );

        output.flush();
    }
}