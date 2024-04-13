package exception;

/**
 * Возникла непредвиденная ошибка при работе с коллекцией
 */
public class CollectionException extends RuntimeException {
    public CollectionException() {
        super("Возникла ошибка при работе с коллекцией, проверьте её целостность!");
    }

    public CollectionException(String message) {
        super(message);
    }
}
