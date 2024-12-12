package oncall.domain.constants;

import java.util.Arrays;
import oncall.exception.InvalidWorkDateException;

public enum Week {

    SUNDAY(0, "일"),
    MONDAY(1, "월"),
    TUESDAY(2, "화"),
    WEDNESDAY(3, "수"),
    THURSDAY(4, "목"),
    FRIDAY(5, "금"),
    SATURDAY(6, "토"),
    ;

    private final int index;
    private final String value;

    Week(int index, String value) {
        this.index = index;
        this.value = value;
    }

    public static Week of(String value) {
        return Arrays.stream(values())
                .filter(it -> it.getValue().equals(value))
                .findFirst()
                .orElseThrow(InvalidWorkDateException::new);
    }

    public static int findIndex(Week week) {
        return Arrays.stream(values())
                .filter(it -> it.getIndex() == week.getIndex())
                .findFirst()
                .orElseThrow(InvalidWorkDateException::new)
                .getIndex();
    }

    public static String findWeek(int day) {
        return Arrays.stream(values())
                .filter(it -> it.getIndex() == day)
                .findFirst()
                .orElseThrow(InvalidWorkDateException::new)
                .getValue();
    }

    public static boolean isWeekday(int index) {
        return index == 1 || index == 2 || index == 3 || index == 4 || index == 5;
    }

    public int getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }
}
