package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.interfaces.Command;

public class HelpMenu implements Command {
    private static final StringBuilder mainMenu = new StringBuilder()
            .append("The following commands are supported:\n")
            .append("open <file>                opens <file>\n")
            .append("close                      closes currently opened file\n")
            .append("save                       saves the currently open file\n")
            .append("saveas <file>              saves the currently open file in <file>\n")
            .append("help                       prints this information\n")
            .append("exit                       exits the program\n")
            .append("print                      prints all shapes\n")
            .append("create <t> <attributes>    creates a new shape\n")
            .append("   -> rectangle width height topLeftX topLeftY [cornerRadiusX cornerRadiusY] [fill]\n")
            .append("   -> circle radius [centerX centerY] [fill]\n")
            .append("   -> line startPointX startPointY endPointX endPointY [stroke]\n")
            .append("   -> polygon polygon x1 y1 x2 y2 x3 y3 [fill]\n")
            .append("erase <n>                  erase a shape with index n\n")
            .append("translate <x> <y> [<n>]    translates a shape/shapes horizontally and vertically\n")
            .append("within <option>            prints all shapes within a circle or rectangle\n");
    @Override
    public void execute(String[] arguments) {
        System.out.println(mainMenu);
    }
}
