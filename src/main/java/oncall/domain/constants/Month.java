package oncall.domain.constants;

import java.util.Arrays;

public enum Month {

    JANUARY(1, 31),
    FEBRUARY(2, 28),
    MARCH(3, 31),
    APRIL(4, 30),
    MAY(5, 31),
    JUNE(6, 30),
    JULY(7, 31),
    AUGUST(8, 31),
    SEPTEMBER(9, 30),
    OCTOBER(10, 31),
    NOVEMBER(11, 30),
    DECEMBER(12, 31),
    ;

    private final int month;
    private final int lastDay;

    Month(int month, int lastDay) {
        this.month = month;
        this.lastDay = lastDay;
    }

    public static int findLastDay(int month) {
        return Arrays.stream(values())
                .filter(it -> it.getMonth() == month)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."))
                .getLastDay();
    }

    public int getMonth() {
        return month;
    }

    public int getLastDay() {
        return lastDay;
    }
}
