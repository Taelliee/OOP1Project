package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.SVGCanvas;
import bg.tu_varna.sit.а1.f23621652.interfaces.Command;
import bg.tu_varna.sit.а1.f23621652.models.SVGShape;

public class PrintShapes implements Command {
    @Override
    public void execute(String[] arguments) {
        if(SVGCanvas.getInstance().getShapes().isEmpty()){
            System.out.println("No shapes added yet!");
        }
        else {
            int index = 0;
            for (SVGShape shape : SVGCanvas.getInstance().getShapes()) {
                index = SVGCanvas.getInstance().getShapes().indexOf(shape) + 1;
                System.out.println(index + ". " + shape);
            }
        }
    }
}
