package bg.tu_varna.sit.a1.f23621652.parsers;

public class InputParser {
    private static final int defaultValue = 0;
    /**
     * Tries to parse an integer from a string input.
     * @param input The string to parse.
     * @return The parsed integer or the default value if a NumberFormatException occurs.
     */
    public static int parseIntegerSafely(String input) throws IllegalArgumentException{
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format for argument: \"" + input + "\" needs to be an integer!");
        }
    }
}
