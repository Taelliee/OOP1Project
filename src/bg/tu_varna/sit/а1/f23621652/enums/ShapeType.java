package bg.tu_varna.sit.а1.f23621652.enums;

/**
 * Enum representing the types of shapes supported by the application.
 * Each enum constant corresponds to a string identifier used in user commands.
 */
public enum ShapeType {
    CIRCLE("circle"),
    LINE("line"),
    RECTANGLE("rectangle"),
    POLYGON("polygon");

    private final String inputText;

    ShapeType(String command) {
        this.inputText = command;
    }

    /**
     * Returns the text representation of the shape type.
     *
     * @return the input text for the shape type.
     */
    public String getInputText() {
        return inputText;
    }

    /**
     * Converts a text input to the corresponding ShapeType enum.
     *
     * @param input the shape type string to match.
     * @return the matching ShapeType, or null if no match is found.
     */
    public static ShapeType convertFromText(String input) {
        for (ShapeType currentShape : values()) {
            if (currentShape.inputText.equalsIgnoreCase(input)) {
                return currentShape;
            }
        }
        return null;
    }
}
