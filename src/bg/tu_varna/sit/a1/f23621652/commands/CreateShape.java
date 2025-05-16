package bg.tu_varna.sit.a1.f23621652.commands;

import bg.tu_varna.sit.a1.f23621652.SVGCanvas;
import bg.tu_varna.sit.a1.f23621652.enums.ShapeType;
import bg.tu_varna.sit.a1.f23621652.interfaces.Command;
import bg.tu_varna.sit.a1.f23621652.models.*;

/**
 * Command implementation for creating different types of SVG shapes.
 * This class handles parsing of input arguments and assigns shape creation
 * to the corresponding static creation methods of each shape.
 * Supports rectangle, circle, line, and polygon.
 */
public class CreateShape implements Command {

     /**
     * Executes the command to create a shape.
     *
     * The second argument should specify the shape type.
     * Remaining arguments should match the parameters expected for that shape.
     * If the shape is successfully created, it is added to the SVG canvas.
     *
     * @param arguments array of string inputs representing the shape type and parameters
     *                  Expected formats vary by shape type:
     *                  - rectangle width height x y [rx ry] [fill]
     *                  - circle r [cx cy] [fill]
     *                  - line x1 y1 x2 y2 [stroke]
     *                  - polygon x1 y1 x2 y2 ... [fill]
     */
    @Override
    public void execute(String[] arguments) {
        if (!OpenFile.isOpened()) {
            System.out.println("File not opened! Cannot execute command.");
            return;
        }

        if (arguments.length < 2) {
            System.out.println("Please choose a valid shape and write its attributes. (rectangle, circle, line, polygon)");
            return;
        }

        ShapeType shapeType = ShapeType.convertFromText(arguments[1]);
        if (shapeType == null) {
            System.out.println("Invalid shape type.");
            return;
        }

        SVGShape shape;
        try {
            shape = switch (shapeType) { //expression switch -> The whole switch expression returns a value, which is assigned to shape.
                case CIRCLE -> Circle.createCircle(arguments);
                case RECTANGLE -> Rectangle.createRectangle(arguments);
                case LINE -> Line.createLine(arguments);
                case POLYGON -> Polygon.createPolygon(arguments);
            };
        } catch (Exception e) {
            System.out.println("Error creating shape: " + e.getMessage());
            return;
        }

        SVGCanvas.getInstance().addShape(shape);
        int index = SVGCanvas.getInstance().getShapes().indexOf(shape) + 1;
        System.out.println("Successfully created " + shapeType + " (" + index + ")");
    }

    //examples
    //1. create rectangle 5 5 -10 10 green
    //2. create circle 10 5 5 blue
    //3. create rectangle 10 10 100 -60
    //4. create line 0 0 300 200
    //5. create polygon 100 10 150 190 50 190 yellow

    // create rectangle 10 20 -1000 -1000 yellow
    // Successfully created rectangle (index)
}
