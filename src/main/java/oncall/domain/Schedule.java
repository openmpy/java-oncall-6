package oncall.domain;

import java.util.ArrayDeque;
import java.util.Deque;
import oncall.domain.constants.Holiday;
import oncall.domain.constants.Month;
import oncall.domain.constants.Week;

public class Schedule {

    private final Deque<String> weekdayWorkersDeque = new ArrayDeque<>();
    private final Deque<String> dayOffWorkersDeque = new ArrayDeque<>();

    private final WorkDate workDate;
    private final WeekdayWorkers weekdayWorkers;
    private final DayOffWorkers dayOffWorkers;
    private String lastNickname = null;

    public Schedule(WorkDate workDate, WeekdayWorkers weekdayWorkers, DayOffWorkers dayOffWorkers) {
        weekdayWorkersDeque.addAll(weekdayWorkers.getNicknames());
        dayOffWorkersDeque.addAll(dayOffWorkers.getNicknames());

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

            String worker = getWorker(month, day);
            worker = handleWorker(month, day, worker);

            String formatted = String.format("%d월 %d일 %s %s", month, i + 1, Week.findWeek(day), worker);
            if (Holiday.isHoliday(month, i + 1)) {
                formatted = String.format("%d월 %d일 %s(휴일) %s", month, i + 1, Week.findWeek(day), worker);
            }
            System.out.println(formatted);
        }
    }

    private String handleWorker(int month, int day, String worker) {
        if (worker.equals(lastNickname)) {
            if (!Holiday.isHoliday(month, day) && (day == 1 || day == 2 || day == 3 || day == 4 || day == 5)) {
                worker = weekdayWorkersDeque.pop();
                weekdayWorkersDeque.add(lastNickname);
                lastNickname = worker;
                return worker;
            }

            worker = dayOffWorkersDeque.pop();
            dayOffWorkersDeque.addFirst(lastNickname);
            lastNickname = worker;
        }
        return worker;
    }

    private String getWorker(int month, int day) {
        if (!Holiday.isHoliday(month, day) && (day == 1 || day == 2 || day == 3 || day == 4 || day == 5)) {
            return getWeekdayWorker();
        }
        return getDayOffWorker();
    }

    private String getWeekdayWorker() {
        String worker = weekdayWorkersDeque.pop();
        weekdayWorkersDeque.add(worker);
        return worker;
    }

    private String getDayOffWorker() {
        String worker = dayOffWorkersDeque.pop();
        dayOffWorkersDeque.add(worker);
        return worker;
    }
}
