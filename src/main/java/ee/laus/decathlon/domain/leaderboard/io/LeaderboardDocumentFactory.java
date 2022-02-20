package ee.laus.decathlon.domain.leaderboard.io;

import ee.laus.decathlon.domain.athlete.AthleteResult;
import ee.laus.decathlon.domain.discipline.DisciplineRecord;
import ee.laus.decathlon.domain.leaderboard.Leaderboard;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.Set;

public class LeaderboardDocumentFactory {
    private final Document document;
    private final Leaderboard leaderboard;

    public LeaderboardDocumentFactory(Leaderboard leaderboard) {
        this.leaderboard = leaderboard;
        this.leaderboard.calculatePlaces();
        this.document = createNewDocument();
    }

    public Leaderboard getLeaderboard() {
        return leaderboard;
    }

    public Document build() {
        Element root = createRoot();
        this.document.appendChild(root);
        return this.document;
    }

    private Element createRoot() {
        Element root = document.createElement("leaderboard");
        this.leaderboard.getAthleteResults().forEach(result -> root.appendChild(createAthleteResultElement(result)));
        return root;
    }

    private Element createAthleteResultElement(AthleteResult result) {
        Element athleteElement = document.createElement("athlete");
        athleteElement.appendChild(createTextNode("place", result.getPlace()));
        athleteElement.appendChild(createTextNode("name", result.getName()));
        athleteElement.appendChild(createDisciplineRecordsElement(result.getRecords()));
        athleteElement.appendChild(createTextNode("total", String.valueOf(result.getTotal())));
        return athleteElement;
    }

    private Element createDisciplineRecordsElement(Set<DisciplineRecord> records) {
        Element recordsElement = document.createElement("disciplines");
        records.forEach(record -> recordsElement.appendChild(createDisciplineRecordElement(record)));
        return recordsElement;
    }

    private Element createDisciplineRecordElement(DisciplineRecord record) {
        Element recordElement = document.createElement("discipline");
        recordElement.appendChild(createTextNode("title", record.getDiscipline().getTitle()));
        recordElement.appendChild(createTextNode("result", String.valueOf(record.getDisciplineResult())));
        recordElement.appendChild(createTextNode("unit", record.getDiscipline().getUnit().getAbbreviation()));
        recordElement.appendChild(createTextNode("points", String.valueOf(record.getPoints())));
        return recordElement;
    }

    private Document createNewDocument() {
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Element createTextNode(String fieldName, String text) {
        var textNode = this.document.createElement(fieldName);
        textNode.setTextContent(text);
        return textNode;
    }
}
