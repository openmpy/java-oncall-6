package oncall;

import java.util.List;
import oncall.domain.DayOffWorkers;
import oncall.domain.Schedule;
import oncall.domain.WeekdayWorkers;
import oncall.domain.WorkDate;
import oncall.dto.ScheduleResponseDto;
import oncall.exception.InvalidWorkDateException;
import oncall.exception.InvalidWorkerException;
import oncall.utils.StringParser;
import oncall.utils.StringSplitter;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // 비상 근무 날짜 입력
        WorkDate workDate = readEmergencyWorkDate();

        // 비상 근무 사원 입력
        ScheduleResponseDto readWorkers = readWorkers();

        // 스케쥴 결과 출력
        Schedule schedule = new Schedule(workDate, readWorkers.weekdayWorkers(), readWorkers.dayOffWorkers());
        OutputView.printSchedule(schedule);
    }

    private static WorkDate readEmergencyWorkDate() {
        while (true) {
            try {
                String readEmergencyWorkDate = InputView.readEmergencyWorkDate();
                List<String> splitEmergencyWorkDate = StringSplitter.splitComma(readEmergencyWorkDate);
                return StringParser.parseWorkDate(splitEmergencyWorkDate);
            } catch (InvalidWorkDateException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    private static ScheduleResponseDto readWorkers() {
        while (true) {
            try {
                String readWeekdayWorker = InputView.readWeekdayWorker();
                List<String> splitWeekdayWorkers = StringSplitter.splitComma(readWeekdayWorker);
                WeekdayWorkers weekdayWorkers = StringParser.parseWeekdayWorkers(splitWeekdayWorkers);

                String readDayOffWorker = InputView.readDayOffWorker();
                List<String> splitDayOffWorkers = StringSplitter.splitComma(readDayOffWorker);
                DayOffWorkers dayOffWorkers = StringParser.parseDayOffWorkers(splitDayOffWorkers);
                return new ScheduleResponseDto(weekdayWorkers, dayOffWorkers);
            } catch (InvalidWorkerException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }
}
