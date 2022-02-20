package ee.laus.decathlon.domain.discipline;

import ee.laus.decathlon.common.Unit;
import ee.laus.decathlon.common.util.TimeUtil;

public interface DisciplineRecord {
    double getDisciplineResult();
    int calculate(double performance);
    Discipline getDiscipline();

    default DisciplineMultiplier getMultiplier() {
        return getDiscipline().getMultiplier();
    }

    default int getPoints() {
        double performance = getDisciplineResult();
        return calculate(performance);
    }

    static DisciplineRecord of(Discipline discipline, double result) {
        if (discipline.getUnit() == Unit.METER) {
            return new FieldDisciplineRecord(discipline, result);
        } else if (discipline.getUnit() == Unit.CENTIMETER) {
            return new FieldDisciplineRecord(discipline, result * 100);
        }
        return new TrackDisciplineRecord(discipline, result);
    }

    static DisciplineRecord of(Discipline discipline, String result) {
        if (discipline.isFieldEvent()) {
            return of(discipline, Double.parseDouble(result));
        }
        return of(discipline, TimeUtil.convertMinuteStringToDouble(result));
    }
}
