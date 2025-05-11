package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.SVGCanvas;
import bg.tu_varna.sit.а1.f23621652.enums.ShapeType;
import bg.tu_varna.sit.а1.f23621652.exceptions.NegativeValueException;
import bg.tu_varna.sit.а1.f23621652.interfaces.Command;
import bg.tu_varna.sit.а1.f23621652.models.*;

public class CreateShape implements Command {
    @Override
    public void execute(String[] arguments) {
        if(arguments.length < 2 || ShapeType.convertFromText(arguments[1]) == null){
            System.out.println("Please choose a valid shape and write its attributes. (rectangle, circle, line, polygon)");
            return;
        }
        ShapeType shapeType = ShapeType.convertFromText(arguments[1]);
        int x1, x2, y1, y2, cx, cy, r, width, height;
        String fill;
        SVGShape shape = null;
        //examples
        //1. create rectangle 5 5 -10 10 green
        //2. create circle 10 5 5 blue
        //3. create rectangle 10 10 100 -60
        //4. create line 0 0 300 200
        //5. create polygon 100 10 150 190 50 190 yellow

        // > create rectangle 10 20 -1000 -1000 yellow
        // Successfully created rectangle (index)
        switch (shapeType){
            case LINE:
                if(arguments.length == 6 || arguments.length == 7){
                    x1 = Integer.parseInt(arguments[2]);
                    y1 = Integer.parseInt(arguments[3]);
                    x2 = Integer.parseInt(arguments[4]);
                    y2 = Integer.parseInt(arguments[5]);
                    shape = new Line(new Point(x1, y1), new Point(x2, y2));
                    if(arguments.length == 7){
                        shape.setStroke(arguments[6]);
                    }
                }
                else{
                    System.out.println("Invalid number of arguments for line. (x1 y1 x2 y2 [stroke])");
                }
                break;
            case CIRCLE:
                if(arguments.length < 3){
                    System.out.println("You haven's chosen a radius for the circle!");
                    return;
                }
                r = Integer.parseInt(arguments[2]);
                try {
                    switch (arguments.length) {
                        case 3: // circle r
                            shape = new Circle(r);
                            break;
                        case 4: // circle r fill
                            fill = arguments[3];
                            shape = new Circle(r);
                            shape.setFill(fill);
                            break;
                        case 5: // circle r cx cy
                            cx = Integer.parseInt(arguments[3]);
                            cy = Integer.parseInt(arguments[4]);
                            shape = new Circle(r, new Point(cx, cy));
                            break;
                        case 6: // circle r cx cy fill
                            cx = Integer.parseInt(arguments[3]);
                            cy = Integer.parseInt(arguments[4]);
                            fill = arguments[5];
                            shape = new Circle(r, new Point(cx, cy));
                            shape.setFill(fill);
                            break;
                        default:
                            System.out.println("Invalid number of arguments for circle.");
                            return;
                    }
                } catch (NumberFormatException | NegativeValueException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case RECTANGLE:
                if(arguments.length < 6){
                    System.out.println("You haven't put the required rectangle arguments! (width height x y)");
                    return;
                }
                width = Integer.parseInt(arguments[2]);
                height = Integer.parseInt(arguments[3]);
                x1 = Integer.parseInt(arguments[4]);
                y1 = Integer.parseInt(arguments[5]);

                try {
                    switch (arguments.length) {
                        case 6: // rect width height x y
                            shape = new Rectangle(width, height, new Point(x1, y1));
                            break;
                        case 7: // rect width height x y fill
                            fill = arguments[6];
                            shape = new Rectangle(width, height, new Point(x1, y1));
                            shape.setFill(fill);
                            break;
                        case 8: // rect width height x y rx ry
                            x2 = Integer.parseInt(arguments[6]);
                            y2 = Integer.parseInt(arguments[7]);
                            shape = new Rectangle(width, height, new Point(x1, y1), new Point(x2, y2));
                            break;
                        case 9: // rect width height x y rx ry fill
                            x2 = Integer.parseInt(arguments[6]);
                            y2 = Integer.parseInt(arguments[7]);
                            fill = arguments[8];
                            shape = new Rectangle(width, height, new Point(x1, y1), new Point(x2, y2));
                            shape.setFill(fill);
                            break;
                        default:
                            System.out.println("Invalid number of arguments for rectangle.");
                            return;
                    }
                } catch (NumberFormatException | NegativeValueException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case POLYGON:
                shape = new Polygon();
                int numPoints = arguments.length;
                if(arguments.length % 2 != 0){
                    numPoints--;
                    shape.setFill(arguments[arguments.length - 1]);
                }
                for (int i = 2; i < numPoints; i += 2) {
                    String[] points = {arguments[i], arguments[i+1]};
                    Point point = new Point(Integer.parseInt(points[0]), Integer.parseInt(points[1]));
                    ((Polygon) shape).addPoint(point);
                }
                break;
            default:
                System.out.println("Invalid shape or arguments");
                break;
        }
        if(shape!= null) {
            SVGCanvas.getInstance().addShape(shape);
            int index = SVGCanvas.getInstance().getShapes().indexOf(shape) + 1;
            //System.out.println(shape);
            System.out.println("Successfully created " + shapeType + " (" + index+ ")");
        }
    }
}
