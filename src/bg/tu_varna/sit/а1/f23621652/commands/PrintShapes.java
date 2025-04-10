package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.SVGCanvas;
import bg.tu_varna.sit.а1.f23621652.interfaces.Command;
import bg.tu_varna.sit.а1.f23621652.models.SVGShape;

public class PrintShapes implements Command {
    @Override
    public void execute(String[] arguments) {
        for (SVGShape shape: SVGCanvas.getInstance().getShapes()) {
            System.out.println(shape);
        }
    }
}
