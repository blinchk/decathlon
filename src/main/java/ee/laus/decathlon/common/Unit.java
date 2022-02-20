package ee.laus.decathlon.common;

public enum Unit {
    METER("m"),
    SECOND("s"),
    CENTIMETER("cm");

    Unit(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    private final String abbreviation;

    public String getAbbreviation() {
        return abbreviation;
    }
}
