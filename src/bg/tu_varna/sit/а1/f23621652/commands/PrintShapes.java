package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.SVGCanvas;
import bg.tu_varna.sit.а1.f23621652.interfaces.Command;
import bg.tu_varna.sit.а1.f23621652.models.SVGShape;

public class PrintShapes implements Command {
    @Override
    public void execute(String[] arguments) {
        int index = 0;
        for (SVGShape shape: SVGCanvas.getInstance().getShapes()) {
            index = SVGCanvas.getInstance().getShapes().indexOf(shape) + 1;
            System.out.println(index + ". " + shape);
        }
    }
}
