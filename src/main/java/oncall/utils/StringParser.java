package oncall.utils;

import java.util.List;
import oncall.domain.WeekdayWorkers;
import oncall.domain.WorkDate;

public class StringParser {

    public static WorkDate parseWorkDate(List<String> strings) {
        try {
            int month = Integer.parseInt(strings.get(0));
            String week = strings.get(1);
            return new WorkDate(month, week);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    public static WeekdayWorkers parseWeekdayWorkers(List<String> nicknames) {
        return new WeekdayWorkers(nicknames);
    }
}
