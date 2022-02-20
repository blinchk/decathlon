package ee.laus.decathlon.domain.discipline;

import ee.laus.decathlon.common.Unit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisciplineTest {
    @Test
    public void disciplineRunning100m_Test() {
        Discipline discipline = Discipline.RUNNING_100_M;
        double expectedA = 25.4347;
        double expectedB = 18;
        double expectedC = 1.81;
        String expectedTitle = "100 m";
        assertEquals(discipline.getTitle(), expectedTitle);
        assertEquals(discipline.getMultiplier().getA(), expectedA);
        assertEquals(discipline.getMultiplier().getB(), expectedB);
        assertEquals(discipline.getMultiplier().getC(), expectedC);
    }

    @Test
    public void disciplinePoleVault_Test() {
        Discipline discipline = Discipline.POLE_VAULT;
        double expectedA = 0.2797;
        double expectedB = 100;
        double expectedC = 1.35;
        String expectedTitle = "Pole vault";
        Unit expectedUnit = Unit.CENTIMETER;
        assertEquals(expectedTitle, discipline.getTitle());
        assertEquals(expectedA, discipline.getMultiplier().getA());
        assertEquals(expectedB, discipline.getMultiplier().getB());
        assertEquals(expectedC, discipline.getMultiplier().getC());
        assertEquals(expectedUnit, discipline.getUnit());
    }
}