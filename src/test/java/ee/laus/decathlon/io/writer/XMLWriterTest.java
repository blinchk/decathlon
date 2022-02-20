package ee.laus.decathlon.io.writer;

import ee.laus.decathlon.domain.leaderboard.Leaderboard;
import ee.laus.decathlon.domain.leaderboard.io.LeaderboardDocumentFactory;
import org.junit.jupiter.api.Test;

import java.util.Collections;

class XMLWriterTest {
    @Test
    void write_Test() {
        Leaderboard leaderboard = new Leaderboard(Collections.emptySet());
        LeaderboardDocumentFactory factory = new LeaderboardDocumentFactory(leaderboard);
        XMLWriter writer = new XMLWriter(factory.build());
        writer.write("build/resources/main/decathlon.xml");
    }
}