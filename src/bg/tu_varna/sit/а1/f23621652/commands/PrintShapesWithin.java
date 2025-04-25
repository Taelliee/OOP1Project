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
            if (shape instanceof Line) {
                pointsToCheck.add(((Line) shape).getStartPoint());
                pointsToCheck.add(((Line) shape).getEndPoint());
            }
            else if (shape instanceof Circle) {

            }
            else if (shape instanceof Rectangle) {
                pointsToCheck.addAll(((Rectangle) shape).getPoints());
            }
            else if (shape instanceof Polygon) {
                pointsToCheck.addAll(((Polygon) shape).getPoints());
            }

            if (shapeWithin == ShapeType.RECTANGLE) {
                int width = Integer.parseInt(arguments[2]);
                int height = Integer.parseInt(arguments[3]);
                int x1 = Integer.parseInt(arguments[4]);
                int y1 = Integer.parseInt(arguments[5]);
                try{
                    Rectangle rect = new Rectangle(width, height, new Point(x1, y1));
                    checkPointsWithinRectangle(pointsToCheck, rect);
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
                    checkPointsWithinCircle(pointsToCheck, circle);
                } catch (NumberFormatException | NegativeValueException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private boolean checkPointsWithinRectangle(List<Point> points, Rectangle rect){
        for (Point point : points) {
            if(true){

            }
        }

        return true;
    }

    private boolean checkPointsWithinCircle(List<Point> points, Circle circle){
        //double distanceSquared = Math.pow(xPoint - xCenter, 2) + Math.pow(yPoint - yCenter, 2);

        for (Point point : points) {

        }
        //return distanceSquared <= Math.pow(radius, 2);
        return true;
    }
}
