package ee.laus.decathlon.domain.leaderboard.io;

import ee.laus.decathlon.domain.athlete.AthleteResult;
import ee.laus.decathlon.domain.leaderboard.Leaderboard;
import ee.laus.decathlon.io.reader.CSVReader;
import ee.laus.decathlon.io.writer.XMLWriter;
import org.w3c.dom.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

public class LeaderboardCSVtoXMLConverter {
    private Document createDocument(Leaderboard leaderboard) {
        LeaderboardDocumentFactory factory = new LeaderboardDocumentFactory(leaderboard);
        return factory.build();
    }

    public void write(Leaderboard leaderboard) {
        Document document = createDocument(leaderboard);
        XMLWriter writer = new XMLWriter(document);
        writer.write("build/resources/main/decathlon.xml");
    }

    public Leaderboard read(File file) {
        CSVReader reader = new CSVReader();
        Collection<String[]> content = new ArrayList<>();
        try {
            content = reader.read(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        var results = content.stream().map(AthleteResult::fromRow).toList();
        return new Leaderboard(results);
    }
}
