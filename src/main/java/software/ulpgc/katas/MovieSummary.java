package software.ulpgc.katas;

import software.ulpgc.katas.model.Movie;
import software.ulpgc.katas.model.Rating;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class MovieSummary {
    public Map<Rating, Long> calculate(List<Movie> movies) {
        return movies.stream()
                .collect(groupingBy(
                        Movie::rating,
                        TreeMap::new,
                        counting()
                ));
    }
}