package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.SVGCanvas;
import bg.tu_varna.sit.а1.f23621652.enums.ShapeType;
import bg.tu_varna.sit.а1.f23621652.exceptions.NegativeValueException;
import bg.tu_varna.sit.а1.f23621652.interfaces.Command;
import bg.tu_varna.sit.а1.f23621652.models.*;

import java.util.ArrayList;
import java.util.List;

public class PrintShapesWithin implements Command {
    @Override
    public void execute(String[] arguments) {
        ShapeType shapeWithin = ShapeType.convertFromText(arguments[1]);
        List<Point> pointsToCheck = new ArrayList<>();

        for (SVGShape shape: SVGCanvas.getInstance().getShapes()) {
            pointsToCheck.addAll(shape.getPoints());

            boolean isWithin = false;

            if (shapeWithin == ShapeType.RECTANGLE) {
                int width = Integer.parseInt(arguments[2]);
                int height = Integer.parseInt(arguments[3]);
                int x1 = Integer.parseInt(arguments[4]);
                int y1 = Integer.parseInt(arguments[5]);
                try{
                    Rectangle rect = new Rectangle(width, height, new Point(x1, y1));
                    if(shape instanceof Circle) {
                        isWithin = checkPointsWithinRectangle(pointsToCheck, rect, ((Circle) shape).getRadius());
                    }
                    else{
                        isWithin = checkPointsWithinRectangle(pointsToCheck, rect, 0);
                    }
                } catch (NumberFormatException | NegativeValueException e) {
                    System.out.println(e.getMessage());
                }
            }
            else if(shapeWithin == ShapeType.CIRCLE){
                int r = Integer.parseInt(arguments[2]);
                int cx = Integer.parseInt(arguments[3]);
                int cy = Integer.parseInt(arguments[4]);
                try{
                    Circle circle = new Circle(r, new Point(cx, cy));
                    if(shape instanceof Circle){
                        isWithin = checkPointsWithinCircle(pointsToCheck, circle, ((Circle) shape).getRadius());
                    }
                    else {
                        isWithin = checkPointsWithinCircle(pointsToCheck, circle, 0);
                    }

                } catch (NumberFormatException | NegativeValueException e) {
                    System.out.println(e.getMessage());
                }
            }

            if(isWithin){
                System.out.println(shape);
            }
        }
    }

    private boolean checkPointsWithinRectangle(List<Point> points, Rectangle rect, int radius){
        Point rectPoint = rect.getTopLeftPoint();
        for (Point circlePoint : points) {
            if(circlePoint.getX() - radius < rectPoint.getX() || circlePoint.getX() + radius > rectPoint.getX() + rect.getWidth() ||
                    circlePoint.getY() + radius > rectPoint.getY() || circlePoint.getY() - radius < rectPoint.getY() - rect.getHeight()){
                return false;
            }
        }
        return true;
    }

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
