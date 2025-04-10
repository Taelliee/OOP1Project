package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.SVGCanvas;
import bg.tu_varna.sit.а1.f23621652.exceptions.NegativeValueException;
import bg.tu_varna.sit.а1.f23621652.interfaces.Command;
import bg.tu_varna.sit.а1.f23621652.models.*;
import bg.tu_varna.sit.а1.f23621652.models.Point;
import bg.tu_varna.sit.а1.f23621652.models.Polygon;

public class CreateShape implements Command {
    @Override
    public void execute(String[] arguments) {
        String shapeName = arguments[1].toLowerCase();
        int x1, x2, y1, y2, cx, cy;
        double r, width, height;
        String fill;
        SVGShape shape = null;
        //examples
        //1. rectangle 5 5 10 10 green
        //2. circle 5 5 10 blue
        //3. rectangle 100 60 10 10
        //4. line 0 0 300 200
        //5. polygon 100,10 150,190 50,190

        // > create rectangle -1000 -1000 10 20 yellow
        // Successfully created rectangle (4)
        switch (shapeName){
            case "line":
                x1 = Integer.parseInt(arguments[2]);
                y1 = Integer.parseInt(arguments[3]);
                x2 = Integer.parseInt(arguments[4]);
                y2 = Integer.parseInt(arguments[5]);
                shape = new Line(new Point(x1, y1), new Point(x2, y2));
                break;
            case "circle":
                r = Double.parseDouble(arguments[2]);
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
            case "rectangle":
                width = Double.parseDouble(arguments[2]);
                height = Double.parseDouble(arguments[3]);
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
                            System.out.println("Invalid number of arguments for circle.");
                            return;
                    }
                } catch (NumberFormatException | NegativeValueException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "polygon":
                shape = new Polygon();
                for (int i = 2; i < arguments.length; i++) {
                    String[] points = arguments[i].split(",");
                    Point point = new Point(Integer.parseInt(points[0]), Integer.parseInt(points[1]));
                    ((Polygon) shape).addPoint(point);
                }
                break;
            default:
                //...
                break;
        }
        SVGCanvas.getInstance().addShape(shape);
        System.out.println(shape);
        //System.out.println("Successfully created" + shapeName + "index");
    }
}
