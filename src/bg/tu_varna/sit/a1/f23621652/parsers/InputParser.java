package bg.tu_varna.sit.a1.f23621652.parsers;

/**
 * Utility class for parsing user input values safely.
 *
 * Provides methods to convert strings to integers while handling invalid input.
 */
public class InputParser {
    /**
     * Parses a string input into an integer.
     *
     * If the input cannot be parsed as an integer, an IllegalArgumentException is thrown
     * with a descriptive error message.
     *
     * @param input the string to parse
     * @return the parsed integer
     * @throws IllegalArgumentException if the input is not a valid integer
     */
    public static int parseIntegerSafely(String input) throws IllegalArgumentException{
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format for argument: \"" + input + "\" needs to be an integer!");
        }
    }
}
