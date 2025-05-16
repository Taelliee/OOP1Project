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
        if (!OpenFile.isOpened()) {
            System.out.println("File not opened! Cannot execute command.");
            return;
        }

        if (arguments.length < 3 || ShapeType.convertFromText(arguments[1]) == null) {
            System.out.println("Please choose a valid shape and write its attributes. (rectangle, circle, line, polygon)");
            return;
        }
        ShapeType shapeWithin = ShapeType.convertFromText(arguments[1]);
        SVGShape boundaryShape = getBoundaryShape(arguments, shapeWithin);
        if (boundaryShape == null) {
            return;
        }

        List<Point> pointsToCheck = new ArrayList<>();

        boolean isAnythingWithin = false;

        for (SVGShape shape : SVGCanvas.getInstance().getShapes()) {
            pointsToCheck.clear();
            pointsToCheck.addAll(shape.getPoints());

            boolean isWithin = false;

            if(boundaryShape instanceof Rectangle) {
                if (shape instanceof Circle) {
                    isWithin = checkPointsWithinRectangle(pointsToCheck, ((Rectangle) boundaryShape), ((Circle) shape).getRadius());
                }
                else {
                    isWithin = checkPointsWithinRectangle(pointsToCheck, ((Rectangle) boundaryShape), 0);
                }
            }

            if(boundaryShape instanceof Circle) {
                if (shape instanceof Circle) {
                    isWithin = checkPointsWithinCircle(pointsToCheck, ((Circle) boundaryShape), ((Circle) shape).getRadius());
                } else {
                    isWithin = checkPointsWithinCircle(pointsToCheck, ((Circle) boundaryShape), 0);
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

    /**
     * Creates a boundary shape (rectangle or circle) from the given arguments.
     *
     * Used for commands that require checking whether other shapes lie within a boundary shape.
     *
     * @param arguments the input arguments to create the shape
     * @param shapeWithin  the shape type to use as boundary (only rectangle or circle)
     * @return a shape instance representing the boundary, or null if creation fails
     */
    private SVGShape getBoundaryShape(String[] arguments, ShapeType shapeWithin){
        SVGShape boundaryShape = null;

        if (shapeWithin == ShapeType.RECTANGLE) {
            try {
                boundaryShape = Rectangle.createRectangle(arguments);
            } catch (IllegalArgumentException | NegativeValueException e) {
                System.out.println(e.getMessage());
            }
        } else if (shapeWithin == ShapeType.CIRCLE) {
            try {
                boundaryShape = Circle.createCircle(arguments);
            } catch (IllegalArgumentException | NegativeValueException e) {
                System.out.println(e.getMessage());
            }
        }
        return boundaryShape;
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
        Point circlePoint = circle.getCenterPoint();

        for (Point shapePoint : points) {
            distance = Math.sqrt(Math.pow(shapePoint.getX() - circlePoint.getX(), 2) + Math.pow(shapePoint.getY() - circlePoint.getY(), 2));
            if(distance + radius > circle.getRadius()){
                return false;
            }
        }
        return true;
    }
}
