package oncall.domain;

import oncall.domain.constants.Week;

public class WorkDate {

    private final int month;
    private final Week week;

    public WorkDate(int month, String week) {
        validateMonth(month);

        this.month = month;
        this.week = Week.of(week);
    }

    private void validateMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    public int getMonth() {
        return month;
    }

    public Week getWeek() {
        return week;
    }
}
