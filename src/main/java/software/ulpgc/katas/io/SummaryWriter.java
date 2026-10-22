package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Platform;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class SummaryWriter {
    public void write(Map<Platform, Long> summary, OutputStream output)
            throws IOException {
        StringBuilder text = new StringBuilder();

        if (summary.isEmpty()) {
            text.append("Sin videojuegos.\n");
        } else {
            text.append("Videojuegos por plataforma:\n");

            summary.forEach((platform, count) ->
                    text.append(platform)
                            .append(": ")
                            .append(count)
                            .append('\n')
            );
        }

        output.write(text.toString().getBytes(StandardCharsets.UTF_8));
        output.flush();
    }
}