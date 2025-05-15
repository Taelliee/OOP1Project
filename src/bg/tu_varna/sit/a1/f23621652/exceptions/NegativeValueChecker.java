package bg.tu_varna.sit.a1.f23621652.exceptions;

/**
 * Utility class for checking if numeric values are negative.
 * Used for validating shape dimensions and coordinates.
 */
public final class NegativeValueChecker {

    /**
     * Default error message used when a negative value is detected.
     */
    public static final String message = "Values cannot be negative!";

    /**
     * Private constructor to prevent instantiation
     */
    private NegativeValueChecker(){}

    /**
     * Checks if the provided value is negative.
     *
     * @param value the value to check.
     * @return true if the value is negative, false otherwise.
     */
    public static boolean isValueNegative(double value){
        if(value < 0)
            return true;
        return false;
    }
}
