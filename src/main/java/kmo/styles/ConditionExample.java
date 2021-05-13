package kmo.styles;

import java.time.Month;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class ConditionExample {

    private static final Map<Month, String> SEASON_BY_MONTH = new EnumMap<>(Month.class);


    public static void main(String[] args) {
        System.out.println(getSeason1(Month.JANUARY));
        System.out.println(getSeason2(Month.JANUARY));
        System.out.println(getSeason3(Month.JANUARY));
    }

    static {
        SEASON_BY_MONTH.put(Month.JANUARY, "SEASON1");
        SEASON_BY_MONTH.put(Month.FEBRUARY, "SEASON1");
        SEASON_BY_MONTH.put(Month.MARCH, "SEASON1");
        SEASON_BY_MONTH.put(Month.APRIL, "SEASON2");
        SEASON_BY_MONTH.put(Month.MAY, "SEASON2");
        SEASON_BY_MONTH.put(Month.JUNE, "SEASON2");
        SEASON_BY_MONTH.put(Month.JULY, "SEASON3");
        SEASON_BY_MONTH.put(Month.AUGUST, "SEASON3");
        SEASON_BY_MONTH.put(Month.SEPTEMBER, "SEASON3");
        SEASON_BY_MONTH.put(Month.OCTOBER, "SEASON4");
        SEASON_BY_MONTH.put(Month.NOVEMBER, "SEASON4");
        SEASON_BY_MONTH.put(Month.DECEMBER, "SEASON4");
    }

    public static String getSeason1(final Month month) {
        return switch (month) {
            case JANUARY, FEBRUARY, MARCH -> "SEASON1";
            case APRIL, MAY, JUNE -> "SEASON2";
            case JULY, AUGUST, SEPTEMBER -> "SEASON3";
            case OCTOBER, NOVEMBER, DECEMBER -> "SEASON4";
        };
    }

    public static String getSeason2(final Month month) {
        if (month == Month.JANUARY || month == Month.FEBRUARY || month == Month.MARCH) {
            return "SEASON1";
        } else if (month == Month.APRIL || month == Month.MAY || month == Month.JUNE) {
            return "SEASON2";
        } else if (month == Month.JULY || month == Month.AUGUST || month == Month.SEPTEMBER) {
            return "SEASON3";
        } else if (month == Month.OCTOBER || month == Month.NOVEMBER || month == Month.DECEMBER) {
            return "SEASON4";
        }
        throw new IllegalArgumentException();
    }

    public static String getSeason3(final Month month) {
        return Optional.ofNullable(SEASON_BY_MONTH.get(month)).orElseThrow(IllegalArgumentException::new);
    }

}
