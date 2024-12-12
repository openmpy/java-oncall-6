package oncall.domain;

import oncall.domain.constants.Week;
import oncall.exception.InvalidWorkDateException;

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
            throw new InvalidWorkDateException();
        }
    }

    public int getMonth() {
        return month;
    }

    public Week getWeek() {
        return week;
    }
}
