package ee.laus.decathlon.domain.athlete;

import ee.laus.decathlon.domain.discipline.Discipline;
import ee.laus.decathlon.domain.discipline.DisciplineRecord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class AthleteResult {
    private final Athlete athlete;
    private final Set<DisciplineRecord> records;
    private String place;
    public AthleteResult(Athlete athlete, Set<DisciplineRecord> records) {
        this.athlete = athlete;
        this.records = records;
    }

    public static AthleteResult fromRow(String[] columns) {
        Discipline[] disciplines = Discipline.values();
        String name = columns[0];
        String[] resultStrings = Arrays.stream(columns).skip(1).toArray(String[]::new);
        Collection<DisciplineRecord> records = new ArrayList<>();
        for (int i = 0; i < resultStrings.length; i++) {
            Discipline discipline = disciplines[i];
            String resultString = resultStrings[i];
            var record = DisciplineRecord.of(discipline, resultString);
            records.add(record);
        }
        return new AthleteResult(new Athlete(name), Set.copyOf(records));
    }

    public Set<DisciplineRecord> getRecords() {
        return records;
    }

    public DisciplineRecord getRecordByDiscipline(Discipline discipline) {
        return records.stream().filter(record -> record.getDiscipline() == discipline).findFirst().orElse(null);
    }

    public int getTotal() {
        return records.stream().mapToInt(DisciplineRecord::getPoints).sum();
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getName() {
        return this.athlete.getName();
    }
}
