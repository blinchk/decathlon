package ee.laus.decathlon.domain.athlete;

import ee.laus.decathlon.common.Unit;
import ee.laus.decathlon.domain.discipline.Discipline;
import ee.laus.decathlon.domain.discipline.DisciplineRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AthleteResultTest {

    @Test
    void fromRow_Test() {
        String[] columns = new String[] {
          "Kevin Meyer",
                "10.55",
                "7.80",
                "16",
                "2.05",
                "48.42",
                "13.75",
                "50.54",
                "5.45",
                "71.90",
                "4.36.11"
        };
        AthleteResult actual = AthleteResult.fromRow(columns);
        DisciplineRecord actualRunning100m = actual.getRecordByDiscipline(Discipline.RUNNING_100_M);
        String expectedAthleteName = "Kevin Meyer";
        assertEquals(expectedAthleteName, actual.getName());
        assertEquals(10.55, actualRunning100m.getDisciplineResult());
        assertEquals(Unit.SECOND, actualRunning100m.getMultiplier().getUnit());
        assertEquals(Discipline.RUNNING_100_M, actualRunning100m.getDiscipline());
    }

    @Test
    void getTotal_Test() {
        String[] columns = new String[] {
                "John Smith",
                "12.61",
                "5",
                "9.22",
                "1.50",
                "60.39",
                "16.43",
                "21.60",
                "2.60",
                "35.81",
                "5.25.72"
        };
        AthleteResult actual = AthleteResult.fromRow(columns);
        int expectedTotal = 4343;
        String expectedName = "John Smith";
        assertEquals(expectedName, actual.getName());
        assertEquals(expectedTotal, actual.getTotal());
    }
}