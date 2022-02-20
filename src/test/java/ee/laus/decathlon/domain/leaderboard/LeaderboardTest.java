package ee.laus.decathlon.domain.leaderboard;

import ee.laus.decathlon.domain.athlete.Athlete;
import ee.laus.decathlon.domain.athlete.AthleteResult;
import ee.laus.decathlon.domain.discipline.Discipline;
import ee.laus.decathlon.domain.discipline.DisciplineRecord;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeaderboardTest {

    @Test
    void getAthleteResults_Test() {
        Athlete athlete = new Athlete("Erki Nool");
        DisciplineRecord record = DisciplineRecord.of(Discipline.POLE_VAULT, 2.40);
        Set<AthleteResult> results = Set.of(new AthleteResult(
                athlete,
                Set.of(record)
        ));
        Leaderboard leaderboard = new Leaderboard(results);
        Long expectedLength = 1L;
        Discipline expectedDiscipline = Discipline.POLE_VAULT;
        Double expectedResult = 240.0;
        String expectedName = "Erki Nool";
        AthleteResult actualFirstAthlete = leaderboard.getAthleteResults().stream().findFirst().get();
        assertEquals(expectedLength,
                leaderboard.getAthleteResults().size());
        assertEquals(expectedName,
                actualFirstAthlete.getName());
        assertEquals(expectedDiscipline,
                actualFirstAthlete.getRecords().stream().findFirst().get().getDiscipline());
        assertEquals(expectedResult,
                actualFirstAthlete.getRecordByDiscipline(Discipline.POLE_VAULT).getDisciplineResult());
    }

    @Test
    void calculatePlaces_Test() {
        Athlete firstAthlete = new Athlete("Erki Nool");
        Athlete secondAthlete = new Athlete("Kevin Meyer");
        DisciplineRecord record = DisciplineRecord.of(Discipline.POLE_VAULT, 2.40);
        Set<AthleteResult> results = Set.of(new AthleteResult(
                firstAthlete,
                Set.of(record)
        ), new AthleteResult(
                secondAthlete,
                Set.of(record)
        ));
        Leaderboard leaderboard = new Leaderboard(results);
        leaderboard.calculatePlaces();
        AthleteResult actualFirstAthlete = leaderboard.getAthleteResults().stream().findFirst().get();
        AthleteResult actualSecondAthlete = leaderboard.getAthleteResults().stream().skip(1).findFirst().get();
        String expected = "1-2";
        assertEquals(expected, actualFirstAthlete.getPlace());
        assertEquals(expected, actualSecondAthlete.getPlace());
    }
}