package oncall.domain;

import java.util.List;

public class DayOffWorkers {

    private final List<String> nicknames;

    public DayOffWorkers(List<String> nicknames) {
        validateDuplicated(nicknames);

        this.nicknames = nicknames;
    }

    private void validateDuplicated(List<String> nicknames) {
        long distinctCount = nicknames.stream().distinct().count();
        if (nicknames.size() != distinctCount) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }
}
