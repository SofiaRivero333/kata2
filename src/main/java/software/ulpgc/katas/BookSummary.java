package software.ulpgc.katas;

import software.ulpgc.katas.model.Book;
import software.ulpgc.katas.model.Genre;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class BookSummary {

    public Map<Genre, Long> calculate(List<Book> books) {
        return books.stream()
                .collect(groupingBy(
                        Book::genre,
                        TreeMap::new,
                        counting()
                ));
    }
}