package software.ulpgc.katas;

import software.ulpgc.katas.io.UrlMovieReader;
import software.ulpgc.katas.model.Movie;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = new URL(
                "https://raw.githubusercontent.com/ibm-watson-data-lab/open-data/master/movies/movies.tsv"

        );
        List<Movie> movies = new UrlMovieReader(url).load();
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}