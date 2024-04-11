package exception;

/**
 * Команда не получила аргумент, который ожидался.
 */
public class CommandNeedArgumentException extends RuntimeException {
    public CommandNeedArgumentException() {
        super("Этой команде необходим аргумент.");
    }

    public CommandNeedArgumentException(String message) {
        super(message);
    }
}
