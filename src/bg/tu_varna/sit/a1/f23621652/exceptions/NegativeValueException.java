package bg.tu_varna.sit.a1.f23621652.exceptions;

/**
 * Exception thrown when a negative value is provided where it is not allowed.
 * Used to enforce validation rules for shape dimensions or coordinates.
 */
public class NegativeValueException extends Exception{
    /**
     * Constructs a new NegativeValueException with the specified detail message.
     *
     * @param message the detail message explaining the cause of the exception.
     */
    public NegativeValueException(String message) {
        super(message);
    }
}
