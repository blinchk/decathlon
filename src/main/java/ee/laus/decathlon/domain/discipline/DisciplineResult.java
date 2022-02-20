package ee.laus.decathlon.domain.discipline;

import ee.laus.decathlon.common.Unit;

public class DisciplineResult {
    private final double result;
    private final Unit unit;

    public DisciplineResult(double result, Unit unit) {
        this.result = result;
        this.unit = unit;
    }

    public DisciplineResult(double result, Discipline discipline) {
        this.result = result;
        this.unit = discipline.getUnit();
    }

    public double getResult() {
        return result;
    }
}
