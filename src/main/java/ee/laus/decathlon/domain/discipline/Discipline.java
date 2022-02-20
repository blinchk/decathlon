package ee.laus.decathlon.domain.discipline;

import ee.laus.decathlon.common.Unit;

public enum Discipline {
    RUNNING_100_M("100 m",
            new DisciplineMultiplier(25.4347, 18, 1.81, Unit.SECOND)),
    LONG_JUMP("Long jump",
            new DisciplineMultiplier(0.14354, 220, 1.4, Unit.CENTIMETER)),
    SHOT_PUT("Shot put",
            new DisciplineMultiplier(51.39, 1.5, 1.05, Unit.METER)),
    HIGH_JUMP("High jump",
            new DisciplineMultiplier(0.8465, 75, 1.42, Unit.CENTIMETER)),
    RUNNING_400_M("400 m",
            new DisciplineMultiplier(1.53775, 82, 1.81, Unit.SECOND)),
    RUNNING_110_M_HURDLES("110 m hurdles",
            new DisciplineMultiplier(5.74352, 28.5, 1.92, Unit.SECOND)),
    DISCUS_THROW("Discus throw",
            new DisciplineMultiplier(12.91, 4, 1.1, Unit.METER)),
    POLE_VAULT("Pole vault",
            new DisciplineMultiplier(0.2797, 100, 1.35, Unit.CENTIMETER)),
    JAVELIN_THROW("Javelin throw",
            new DisciplineMultiplier(10.14, 7, 1.08, Unit.METER)),
    RUNNING_1500_M("1500 m",
            new DisciplineMultiplier(0.03768, 480, 1.85, Unit.SECOND));

    private final String title;
    private final DisciplineMultiplier multiplier;

    Discipline(String title, DisciplineMultiplier multiplier) {
        this.title = title;
        this.multiplier = multiplier;
    }

    public String getTitle() {
        return title;
    }

    public DisciplineMultiplier getMultiplier() {
        return multiplier;
    }

    public Unit getUnit() {
        return multiplier.getUnit();
    }

    public boolean isFieldEvent() {
        return multiplier.getUnit() == Unit.METER || multiplier.getUnit() == Unit.CENTIMETER;
    }
}
