package oncall.domain;

import oncall.domain.constants.Holiday;
import oncall.domain.constants.Month;
import oncall.domain.constants.Week;

public class Schedule {

    private final WorkDate workDate;
    private final WeekdayWorkers weekdayWorkers;
    private final DayOffWorkers dayOffWorkers;

    public Schedule(WorkDate workDate, WeekdayWorkers weekdayWorkers, DayOffWorkers dayOffWorkers) {
        this.workDate = workDate;
        this.weekdayWorkers = weekdayWorkers;
        this.dayOffWorkers = dayOffWorkers;
    }

    public void printSchedule() {
        int month = workDate.getMonth();
        int lastDay = Month.findLastDay(month);
        int index = Week.findIndex(workDate.getWeek());

        for (int i = 0; i < lastDay; i++) {
            int day = (index + i) % 7;
            String formatted = String.format("%d월 %d일 %s", month, i + 1, Week.findWeek(day));

            if (Holiday.isHoliday(month, i + 1)) {
                formatted = String.format("%d월 %d일 %s(휴일)", month, i + 1, Week.findWeek(day));
            }
            System.out.println(formatted);
        }
    }
}
