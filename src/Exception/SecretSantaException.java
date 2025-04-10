package Exception;

public class SecretSantaException extends Exception {

    public SecretSantaException(String message) {
        super(message);
    }

    public SecretSantaException(String message, Throwable cause) {
        super(message, cause);
    }
}