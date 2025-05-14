package bg.tu_varna.sit.а1.f23621652.enums;

/**
 * Enum representing the types of commands supported by the application.
 * Each enum constant is associated with its string representation as used in user input.
 */
public enum CommandType {
    OPEN("open"),
    CLOSE("close"),
    SAVE("save"),
    SAVE_AS("saveas"),
    HELP("help"),
    EXIT("exit"),
    PRINT("print"),
    CREATE("create"),
    ERASE("erase"),
    TRANSLATE("translate"),
    WITHIN("within");

    private final String inputText;

    CommandType(String command) {
        this.inputText = command;
    }

    /**
     * Returns the text representation of the command, as expected from user input.
     *
     * @return the input text for the command.
     */
    public String getInputText() {
        return inputText;
    }

    /**
     * Converts a text input to the corresponding CommandType enum.
     *
     * @param input the command string to match.
     * @return the matching CommandType, or null if no match is found.
     */
    public static CommandType convertFromText(String input) {
        for (CommandType currentCommand : values()) {
            if (currentCommand.inputText.equalsIgnoreCase(input)) {
                return currentCommand;
            }
        }
        return null;
    }
}
