package ee.laus.decathlon.domain.discipline;

public class FieldDisciplineRecord extends AbstractDisciplineRecord {
    public FieldDisciplineRecord(Discipline discipline, double result) {
        super(discipline, result);
    }

    public int calculate(double performance) {
        int roundedPerformance = (int) performance;
        double total = getMultiplier().getA() * Math.pow(roundedPerformance - getMultiplier().getB(),
                getMultiplier().getC());
        return (int) total;
    }
}
