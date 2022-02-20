package ee.laus.decathlon.domain.discipline;

public class TrackDisciplineRecord extends AbstractDisciplineRecord {
    public TrackDisciplineRecord(Discipline discipline, double result) {
        super(discipline, result);
    }

    public int calculate(double performance) {
        int roundedPerformance = (int) performance;
        double total = getMultiplier().getA() * Math.pow(getMultiplier().getB() - roundedPerformance,
                getMultiplier().getC());
        return (int) total;
    }
}
