package oncall.domain.constants;

import java.util.Arrays;

public enum Week {

    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일"),
    ;

    private final String value;

    Week(String value) {
        this.value = value;
    }

    public static Week of(String value) {
        return Arrays.stream(values())
                .filter(it -> it.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."));
    }

    public String getValue() {
        return value;
    }
}
