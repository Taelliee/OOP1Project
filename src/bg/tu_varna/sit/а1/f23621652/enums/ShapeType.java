package bg.tu_varna.sit.а1.f23621652.enums;

public enum ShapeType {
    CIRCLE("circle"),
    LINE("line"),
    RECTANGLE("rectangle"),
    POLYGON("polygon");

    private final String inputText;

    ShapeType(String command) {
        this.inputText = command;
    }

    public String getInputText() {
        return inputText;
    }

    public static ShapeType convertFromText(String input) {
        for (ShapeType currentShape : values()) {
            if (currentShape.inputText.equalsIgnoreCase(input)) {
                return currentShape;
            }
        }
        return null;
    }
}
