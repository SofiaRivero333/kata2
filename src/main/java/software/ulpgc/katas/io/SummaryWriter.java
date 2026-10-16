package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Rating;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class SummaryWriter {

    public void write(
            Map<Rating, Long> summary,
            OutputStream output
    ) throws IOException {

        StringBuilder text = new StringBuilder();

        if (summary.isEmpty()) {
            text.append("Sin peliculas.\n");
        } else {
            text.append("Peliculas por clasificacion:\n");

            summary.forEach((rating, count) ->
                    text.append(rating)
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