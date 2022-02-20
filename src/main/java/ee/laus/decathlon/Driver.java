package ee.laus.decathlon;

import ee.laus.decathlon.common.ResourceLoader;
import ee.laus.decathlon.domain.leaderboard.Leaderboard;
import ee.laus.decathlon.domain.leaderboard.io.LeaderboardCSVtoXMLConverter;

import java.io.File;

public class Driver {
    public static void main(String[] args) {
        LeaderboardCSVtoXMLConverter handler = new LeaderboardCSVtoXMLConverter();
        ResourceLoader loader = new ResourceLoader();
        File file = loader.loadByFileName("results.csv");
        Leaderboard board = handler.read(file);
        handler.write(board);
    }
}
