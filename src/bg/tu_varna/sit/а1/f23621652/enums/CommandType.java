package bg.tu_varna.sit.а1.f23621652.enums;

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

    public String getInputText() {
        return inputText;
    }

    public static CommandType convertFromText(String input) {
        for (CommandType currentCommand : values()) {
            if (currentCommand.inputText.equalsIgnoreCase(input)) {
                return currentCommand;
            }
        }
        return null;
    }
}
