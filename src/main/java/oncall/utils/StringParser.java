package oncall.utils;

import java.util.List;
import oncall.domain.DayOffWorkers;
import oncall.domain.WeekdayWorkers;
import oncall.domain.WorkDate;
import oncall.exception.InvalidWorkDateException;

public class StringParser {

    public static WorkDate parseWorkDate(List<String> strings) {
        try {
            int month = Integer.parseInt(strings.get(0));
            String week = strings.get(1);
            return new WorkDate(month, week);
        } catch (RuntimeException e) {
            throw new InvalidWorkDateException();
        }
    }

    public static WeekdayWorkers parseWeekdayWorkers(List<String> nicknames) {
        return new WeekdayWorkers(nicknames);
    }

    public static DayOffWorkers parseDayOffWorkers(List<String> nicknames) {
        return new DayOffWorkers(nicknames);
    }
}
