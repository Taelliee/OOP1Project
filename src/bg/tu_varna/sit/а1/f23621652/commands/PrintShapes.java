package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.SVGCanvas;
import bg.tu_varna.sit.а1.f23621652.interfaces.Command;
import bg.tu_varna.sit.а1.f23621652.models.SVGShape;

/**
 * Command implementation for printing all shapes currently on the SVG canvas.
 */
public class PrintShapes implements Command {
    /**
     * Executes the print shapes command.
     * Lists all shapes in the order they appear on the canvas.
     *
     * @param arguments Not used in this command.
     */
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
