package ee.laus.decathlon.domain.leaderboard.io;

import ee.laus.decathlon.domain.leaderboard.Leaderboard;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeaderboardDocumentFactoryTest {

    @Test
    void getLeaderboard_Test() {
        Leaderboard leaderboard = new Leaderboard(Collections.emptySet());
        LeaderboardDocumentFactory factory = new LeaderboardDocumentFactory(leaderboard);
        assertEquals(factory.getLeaderboard(), leaderboard);
    }

    @Test
    void build_Test() {
        Leaderboard leaderboard = new Leaderboard(Collections.emptySet());
        LeaderboardDocumentFactory factory = new LeaderboardDocumentFactory(leaderboard);
        Document document = factory.build();
        String expectedFirstNodeName = "leaderboard";
        String actualFirstNodeName = document.getFirstChild().getNodeName();
        assertEquals(expectedFirstNodeName, actualFirstNodeName);
    }
}