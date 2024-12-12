package oncall.exception;

public class InvalidWorkDateException extends IllegalArgumentException {

    public InvalidWorkDateException() {
        super("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
    }
}
