package software.ulpgc.katas.io;
import software.ulpgc.katas.model.Game;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface GameReader {
    List<Game> load();

    List<Game> loadFrom(InputStream is) throws IOException;
}