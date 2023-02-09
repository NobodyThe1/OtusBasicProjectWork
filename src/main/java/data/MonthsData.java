package data;

import org.junit.platform.commons.JUnitException;

import java.util.Arrays;

public enum MonthsData {

    JANUARY("января", 1),
    FEBRUARY("февраля", 2),
    MARCH("марта", 3),
    APRIL("апреля", 4),
    MAY ("мая", 5),
    JUNE ("июня", 6),
    JULY ("июля", 7),
    AUGUST ("августа", 8),
    SEPTEMBER ("сентября", 9),
    OCTOBER ("октября", 10),
    NOVEMBER ("ноября", 11),
    DECEMBER ("декабря", 12);

    private String name;
    private int number;

    MonthsData (String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public static MonthsData getDate(String name) {
        return Arrays.stream(MonthsData.values())
                .filter((MonthsData monthsData) -> monthsData.getName().equals(name))
                .findFirst().get();
    }
}