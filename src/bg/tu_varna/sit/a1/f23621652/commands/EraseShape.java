package bg.tu_varna.sit.a1.f23621652.commands;

import bg.tu_varna.sit.a1.f23621652.SVGCanvas;
import bg.tu_varna.sit.a1.f23621652.interfaces.Command;
import bg.tu_varna.sit.a1.f23621652.models.SVGShape;
import bg.tu_varna.sit.a1.f23621652.parsers.InputParser;

import java.util.List;

/**
 * Command implementation for erasing a shape from the SVG canvas by index.
 */
public class EraseShape implements Command {

    /**
     * Executes the erase shape operation.
     * Removes the shape at the specified index from the canvas.
     *
     * @param arguments Array where the second element (index 1) is the index of the shape to erase.
     */
    @Override
    public void execute(String[] arguments) {
        if(OpenFile.isOpened()) {
            int index = 0;
            try {
                index = InputParser.parseIntegerSafely(arguments[1]);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            List<SVGShape> shapes = SVGCanvas.getInstance().getShapes();
            try {
                SVGShape shapeToErase = shapes.get(index - 1);
                SVGCanvas.getInstance().eraseShape(shapeToErase);
                System.out.println("Erased a " + shapeToErase.getClass().getSimpleName() + " (" + index + ")");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("There is no shape with this index!");
            }
        }
        else {
            System.out.println("File not opened! Cannot execute command.");
        }
    }
}
