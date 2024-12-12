package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.view.constants.ViewMessage;

public class InputView {

    public static String readEmergencyWorkDate() {
        System.out.println(ViewMessage.INPUT_EMERGENCY_WORK_DATE.getMessage());
        return Console.readLine();
    }

    public static String readWeekdayWorker() {
        System.out.println(ViewMessage.INPUT_WEEKDAY_WORKER.getMessage());
        return Console.readLine();
    }

    public static String readDayOffWorker() {
        System.out.println(ViewMessage.INPUT_DAY_OFF_WORK.getMessage());
        return Console.readLine();
    }
}
