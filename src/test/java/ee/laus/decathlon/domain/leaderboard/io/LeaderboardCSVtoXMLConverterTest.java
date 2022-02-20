package ee.laus.decathlon.domain.leaderboard.io;

import ee.laus.decathlon.common.ResourceLoader;
import ee.laus.decathlon.domain.athlete.AthleteResult;
import ee.laus.decathlon.domain.leaderboard.Leaderboard;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LeaderboardCSVtoXMLConverterTest {

    @Test
    void read_Test() {
        LeaderboardCSVtoXMLConverter converter = new LeaderboardCSVtoXMLConverter();
        ResourceLoader loader = new ResourceLoader();
        File resource = loader.loadByFileName("results.csv");
        Leaderboard leaderboard = converter.read(resource);
        String[] expectedNames = new String[] {"John Smith", "Jane Doe", "Jaan Lepp", "Foo Bar", "John Doe"};
        String[] actualNames = leaderboard.getAthleteResults().stream().map(AthleteResult::getName).toArray(String[]::new);
        assertArrayEquals(expectedNames, actualNames);
    }
}