package software.ulpgc.katas.io;

import software.ulpgc.katas.model.Book;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface BookReader {
    List<Book> load();

    List<Book> loadFrom(InputStream is) throws IOException;
}