package CustomException;

public class InvalidPersonNameException extends RuntimeException {
    public InvalidPersonNameException(String message) {
        super(message);
    }

    public InvalidPersonNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
