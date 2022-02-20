package ee.laus.decathlon.common.util;

import java.util.regex.Pattern;

public class TimeUtil {
    private static final int MINUTES_POSITION = 0;
    private static final int SECONDS_POSITION = 1;
    private static final int MILLISECONDS_POSITION = 2;

    public static double convertMinuteStringToDouble(String result) {
        String DIVIDER_SYMBOL = Pattern.quote(".");
        String[] dividedResult = result.split(DIVIDER_SYMBOL);
        if (dividedResult.length > 2) {
            return convertMinutesPart(dividedResult[MINUTES_POSITION]) +
                    convertSecondsPart(dividedResult[SECONDS_POSITION]) +
                    convertMillisecondsPart(dividedResult[MILLISECONDS_POSITION]);
        } else {
            return convertSecondsPart(result);
        }
    }

    private static double convertMillisecondsPart(String millisecondString) {
        return Double.parseDouble(millisecondString) * Math.pow(10, -2);
    }

    private static double convertSecondsPart(String secondString) {
        return Double.parseDouble(secondString);
    }

    private static double convertMinutesPart(String minuteString) {
        return Double.parseDouble(minuteString) * 60;
    }
}
