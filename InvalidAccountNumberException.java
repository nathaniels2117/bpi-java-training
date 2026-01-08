package ph.com.bpi.hello;

public class InvalidAccountNumberException extends Exception {
    InvalidAccountNumberException(String message) {
        super(message);
    }
}
