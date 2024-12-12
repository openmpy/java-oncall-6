package oncall.domain;

import java.util.List;
import oncall.exception.InvalidWorkerException;

public class WeekdayWorkers {

    private final List<String> nicknames;

    public WeekdayWorkers(List<String> nicknames) {
        validateDuplicated(nicknames);

        this.nicknames = nicknames;
    }

    private void validateDuplicated(List<String> nicknames) {
        long distinctCount = nicknames.stream().distinct().count();
        if (nicknames.size() != distinctCount) {
            throw new InvalidWorkerException();
        }
    }

    public List<String> getNicknames() {
        return nicknames;
    }
}
