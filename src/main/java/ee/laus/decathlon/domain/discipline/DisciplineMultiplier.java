package ee.laus.decathlon.domain.discipline;

import ee.laus.decathlon.common.Unit;

public class DisciplineMultiplier {
    private final double a;
    private final double b;
    private final double c;
    private final Unit unit;

    public DisciplineMultiplier(double a, double b, double c, Unit unit) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.unit = unit;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public Unit getUnit() {
        return unit;
    }
}
