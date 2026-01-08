package ph.com.bpi.hello;

public class InvalidAccountFormatException extends RuntimeException {
    InvalidAccountFormatException(String message) {
        super(message);
    }
}
