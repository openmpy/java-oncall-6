package oncall.domain.constants;

import java.util.Arrays;

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
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."));
    }

    public static int findIndex(Week week) {
        return Arrays.stream(values())
                .filter(it -> it.getIndex() == week.getIndex())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."))
                .getIndex();
    }

    public static String findWeek(int day) {
        return Arrays.stream(values())
                .filter(it -> it.getIndex() == day)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."))
                .getValue();
    }

    public int getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }
}
