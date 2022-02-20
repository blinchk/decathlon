package ee.laus.decathlon.domain.leaderboard;

import ee.laus.decathlon.domain.athlete.AthleteResult;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

public class Leaderboard {
    private Collection<AthleteResult> athleteResults;

    public Leaderboard(Collection<AthleteResult> athleteResults) {
        this.athleteResults = athleteResults;
    }

    public Collection<AthleteResult> getAthleteResults() {
        return athleteResults;
    }

    public void calculatePlaces() {
        this.athleteResults = athleteResults.stream().sorted(Comparator.comparing(AthleteResult::getTotal).reversed()).toList();

        long count = this.athleteResults.size();
        var athleteResults = this.athleteResults.toArray(AthleteResult[]::new);

        for (int i = 0; i < count; i++) {
            String place = String.valueOf(i + 1);
            final int total = athleteResults[i].getTotal();
            if (Arrays.stream(athleteResults).anyMatch(result -> result.getTotal() == total && !Objects.isNull(result.getPlace()))) {
                athleteResults[i - 1].setPlace(i + "-" + place);
                athleteResults[i].setPlace(i + "-" + place);
                continue;
            }
            athleteResults[i].setPlace(place);
        }
        this.athleteResults = Arrays.stream(athleteResults).toList();
    }
}
