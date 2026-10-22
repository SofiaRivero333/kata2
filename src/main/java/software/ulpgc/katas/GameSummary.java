package software.ulpgc.katas;

import software.ulpgc.katas.model.Game;
import software.ulpgc.katas.model.Platform;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class GameSummary {
    public Map<Platform, Long> calculate(List<Game> games) {
        return games.stream()
                .collect(groupingBy(
                        Game::platform,
                        TreeMap::new,
                        counting()
                ));
    }
}