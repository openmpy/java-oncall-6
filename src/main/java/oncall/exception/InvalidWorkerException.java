package oncall.exception;

public class InvalidWorkerException extends IllegalArgumentException {

    public InvalidWorkerException() {
        super("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
    }
}
