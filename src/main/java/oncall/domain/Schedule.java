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

    private String lastNickname = null;

    public Schedule(WorkDate workDate, WeekdayWorkers weekdayWorkers, DayOffWorkers dayOffWorkers) {
        weekdayWorkersDeque.addAll(weekdayWorkers.getNicknames());
        dayOffWorkersDeque.addAll(dayOffWorkers.getNicknames());

        this.workDate = workDate;
    }

    public void printSchedule() {
        int month = workDate.getMonth();
        int lastDay = Month.findLastDay(month);
        int startIndex = Week.findIndex(workDate.getWeek());

        for (int i = 0; i < lastDay; i++) {
            int day = i + 1;
            int index = (startIndex + i) % 7;

            String worker = getWorker(month, day, index);
            worker = handleWorker(month, day, index, worker);
            lastNickname = worker;

            String formatted = String.format("%d월 %d일 %s %s", month, i + 1, Week.findWeek(index), worker);
            if (Holiday.isHoliday(month, i + 1)) {
                formatted = String.format("%d월 %d일 %s(휴일) %s", month, i + 1, Week.findWeek(index), worker);
            }
            System.out.println(formatted);
        }
    }

    private String handleWorker(int month, int day, int index, String worker) {
        if (worker.equals(lastNickname)) {
            if (!Holiday.isHoliday(month, day) &&
                    (index == 1 || index == 2 || index == 3 || index == 4 || index == 5)) {
                worker = weekdayWorkersDeque.pop();
                weekdayWorkersDeque.addFirst(lastNickname);
                return worker;
            }

            worker = dayOffWorkersDeque.pop();
            dayOffWorkersDeque.addFirst(lastNickname);
        }
        return worker;
    }

    private String getWorker(int month, int day, int index) {
        if (!Holiday.isHoliday(month, day) && (index == 1 || index == 2 || index == 3 || index == 4 || index == 5)) {
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
