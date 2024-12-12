package oncall.domain.constants;

import java.util.Arrays;

public enum Holiday {

    JANUARY_1(1, 1),
    MARCH_1(3, 1),
    MAY_5(5, 5),
    JUNE_6(6, 6),
    AUGUST_15(8, 15),
    OCTOBER_3(10, 3),
    OCTOBER_9(10, 9),
    DECEMBER_25(12, 25),
    ;

    private final int month;
    private final int day;

    Holiday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isHoliday(int month, int day) {
        return Arrays.stream(values())
                .anyMatch(it -> it.getMonth() == month && it.getDay() == day);
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
