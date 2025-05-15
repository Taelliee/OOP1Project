package bg.tu_varna.sit.a1.f23621652.commands;

import bg.tu_varna.sit.a1.f23621652.SVGCanvas;
import bg.tu_varna.sit.a1.f23621652.enums.ShapeType;
import bg.tu_varna.sit.a1.f23621652.exceptions.NegativeValueException;
import bg.tu_varna.sit.a1.f23621652.interfaces.Command;
import bg.tu_varna.sit.a1.f23621652.models.Circle;
import bg.tu_varna.sit.a1.f23621652.models.Point;
import bg.tu_varna.sit.a1.f23621652.models.Rectangle;
import bg.tu_varna.sit.a1.f23621652.models.SVGShape;

import java.util.ArrayList;
import java.util.List;

/**
 * Command implementation for printing all shapes in the canvas within a specified circle or rectangle.
 */
public class PrintShapesWithin implements Command {
    /**
     * Executes the "within" command.
     * This command checks all shapes currently on the canvas and prints those that are entirely located
     * within a specified boundary shape. The boundary can be either a rectangle or a circle, and its
     * dimensions and position must be provided as arguments.
     *
     * @param arguments The arguments that specify the boundary shape type and its parameters.
     *                  For a rectangle: width, height, x, y.
     *                  For a circle: radius, cx, cy.
     */
    @Override
    public void execute(String[] arguments) {
        if(OpenFile.isOpened()) {
            if (arguments.length < 3 || ShapeType.convertFromText(arguments[1]) == null) {
                System.out.println("Please choose a valid shape and write its attributes. (rectangle, circle, line, polygon)");
                return;
            }
            ShapeType shapeWithin = ShapeType.convertFromText(arguments[1]);
            List<Point> pointsToCheck = new ArrayList<>();

            boolean isAnythingWithin = false;

            for (SVGShape shape : SVGCanvas.getInstance().getShapes()) {
                pointsToCheck.clear();
                pointsToCheck.addAll(shape.getPoints());

                boolean isWithin = false;

                if (shapeWithin == ShapeType.RECTANGLE) {
                    if (arguments.length != 6) {
                        System.out.println("Please write the width, height and top left point! (width height x y)");
                        return;
                    }
                    int width = Integer.parseInt(arguments[2]);
                    int height = Integer.parseInt(arguments[3]);
                    int x1 = Integer.parseInt(arguments[4]);
                    int y1 = Integer.parseInt(arguments[5]);
                    try {
                        Rectangle rect = new Rectangle(width, height, new Point(x1, y1));
                        if (shape instanceof Circle) {
                            isWithin = checkPointsWithinRectangle(pointsToCheck, rect, ((Circle) shape).getRadius());
                        } else {
                            isWithin = checkPointsWithinRectangle(pointsToCheck, rect, 0);
                        }
                    } catch (NumberFormatException | NegativeValueException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (shapeWithin == ShapeType.CIRCLE) {
                    if (arguments.length != 5) {
                        System.out.println("Please write the radius and center point! (circle r cx cy)");
                        return;
                    }
                    int r = Integer.parseInt(arguments[2]);
                    int cx = Integer.parseInt(arguments[3]);
                    int cy = Integer.parseInt(arguments[4]);
                    try {
                        Circle circle = new Circle(r, new Point(cx, cy));
                        if (shape instanceof Circle) {
                            isWithin = checkPointsWithinCircle(pointsToCheck, circle, ((Circle) shape).getRadius());
                        } else {
                            isWithin = checkPointsWithinCircle(pointsToCheck, circle, 0);
                        }

                    } catch (NumberFormatException | NegativeValueException e) {
                        System.out.println(e.getMessage());
                    }
                }

                if (isWithin) {
                    System.out.println(shape);
                    isAnythingWithin = true;
                }
            }
            if (!isAnythingWithin) {
                System.out.println("No shapes within!");
            }
        }
        else {
            System.out.println("File not opened! Cannot execute command.");
        }
    }

    /**
     * Checks if the given points (optionally with radius) are entirely within a rectangle.
     * If the shape is a circle, its radius is taken into account by expanding the area each point occupies.
     *
     * @param points List of points to check.
     * @param rect The rectangle boundary.
     * @param radius Optional radius offset (used for circles).
     * @return true if all points are within the rectangle, false otherwise.
     */
    private boolean checkPointsWithinRectangle(List<Point> points, Rectangle rect, int radius){
        Point rectPoint = rect.getTopLeftPoint();
        for (Point shapePoint : points) {
            if(shapePoint.getX() - radius < rectPoint.getX() || shapePoint.getX() + radius > rectPoint.getX() + rect.getWidth() ||
                    shapePoint.getY() + radius > rectPoint.getY() || shapePoint.getY() - radius < rectPoint.getY() - rect.getHeight()){
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the given points (optionally with radius for circles) are entirely within a circle.
     * For each point, the distance from the center of the boundary circle is calculated.
     * If the distance (plus the circle's own radius) exceeds the boundary circle’s radius, the shape does not fit.
     * Uses the Euclidean distance formula: d = sqrt((x2 – x1)^2 + (y2 – y1)^2)
     *
     * @param points List of points to check.
     * @param circle The circle boundary.
     * @param radius Optional radius offset (used for circles).
     * @return true if all points are within the circle, false otherwise.
     */
    private boolean checkPointsWithinCircle(List<Point> points, Circle circle, int radius){
        double distance;
        Point circlePoint = circle.getCentrePoint();

        for (Point shapePoint : points) {
            distance = Math.sqrt(Math.pow(shapePoint.getX() - circlePoint.getX(), 2) + Math.pow(shapePoint.getY() - circlePoint.getY(), 2));
            if(distance + radius > circle.getRadius()){
                return false;
            }
        }
        return true;
    }
}
