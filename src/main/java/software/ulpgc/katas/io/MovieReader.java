package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Movie;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface MovieReader {
    List<Movie> load();
    List<Movie> loadFrom(InputStream is) throws IOException;
}