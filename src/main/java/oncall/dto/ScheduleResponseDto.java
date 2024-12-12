package oncall.dto;

import oncall.domain.DayOffWorkers;
import oncall.domain.WeekdayWorkers;

public record ScheduleResponseDto(
        WeekdayWorkers weekdayWorkers,
        DayOffWorkers dayOffWorkers
) {
}
