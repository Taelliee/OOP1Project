package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.SVGCanvas;
import bg.tu_varna.sit.а1.f23621652.interfaces.Command;
import bg.tu_varna.sit.а1.f23621652.models.*;

public class TranslateShape implements Command {
    @Override
    public void execute(String[] arguments) {
        //> translate 5 5
        //> translate 10 10 2
        int transX = Integer.parseInt(arguments[1]);
        int transY = Integer.parseInt(arguments[2]);

        if(arguments.length == 3){
            for (SVGShape shape: SVGCanvas.getInstance().getShapes()) {
                findInstanceAndTranslate(shape, transX, transY);
            }
            System.out.println("Translated all shapes.");
        }
        else if (arguments.length == 4){
            int indexToTranslate = Integer.parseInt(arguments[3]);
            SVGShape shapeToTranslate = SVGCanvas.getInstance().getShapes().get(indexToTranslate-1);
            findInstanceAndTranslate(shapeToTranslate, transX, transY);
            System.out.println("Translated " + shapeToTranslate);
        }
        else{
            System.out.println("Invalid number of arguments for translate command");
        }
    }

    private void findInstanceAndTranslate(SVGShape shape, int transX, int transY){
        if(shape instanceof Line){
            Point newStartPoint = new Point((((Line) shape).getStartPoint().getX() + transX), ((Line) shape).getStartPoint().getY() + transY);
            ((Line) shape).setStartPoint(newStartPoint);
            Point newEndPoint = new Point((((Line) shape).getEndPoint().getX() + transX), ((Line) shape).getEndPoint().getY() + transY);
            ((Line) shape).setEndPoint(newEndPoint);
        }
        else if(shape instanceof Circle){
            Point newCentrePoint = new Point(((Circle) shape).getCentrePoint().getX() + transX, ((Circle) shape).getCentrePoint().getY() + transY);
            ((Circle) shape).setCentrePoint(newCentrePoint);
        }
        else if(shape instanceof Rectangle){
            Point newTopLeftPoint = new Point((((Rectangle) shape).getTopLeftPoint().getX() + transX), ((Rectangle) shape).getTopLeftPoint().getY() + transY);
            ((Rectangle) shape).setTopLeftPoint(newTopLeftPoint);
        }
        else if(shape instanceof Polygon){
            for (Point point : ((Polygon) shape).getPoints()) {
                point.setX(point.getX() + transX);
                point.setY(point.getY() + transY);
            }
        }
    }
}
