package ee.laus.decathlon.domain.discipline;

abstract class AbstractDisciplineRecord implements DisciplineRecord {
    private final Discipline discipline;
    private final DisciplineResult disciplineResult;

    public AbstractDisciplineRecord(Discipline discipline, double result) {
        this.discipline = discipline;
        this.disciplineResult = new DisciplineResult(result, discipline);
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public double getDisciplineResult() {
        return disciplineResult.getResult();
    }
}
