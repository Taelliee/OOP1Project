package bg.tu_varna.sit.a1.f23621652.commands;

import bg.tu_varna.sit.a1.f23621652.SVGCanvas;
import bg.tu_varna.sit.a1.f23621652.exceptions.NegativeValueException;
import bg.tu_varna.sit.a1.f23621652.files.SVGFileWriter;
import bg.tu_varna.sit.a1.f23621652.interfaces.Command;
import bg.tu_varna.sit.a1.f23621652.models.*;
import bg.tu_varna.sit.a1.f23621652.parsers.InputParser;

/**
 * Command implementation for translating a specific shape or all shapes on the canvas.
 */
public class TranslateShape implements Command {

    /**
     * Executes the Translate command.
     * Moves shapes by a specified x and y offset.
     *
     * @param arguments Arguments include x and y offset, and optionally an index for a specific shape.
     */
    @Override
    public void execute(String[] arguments) {
        if (!OpenFile.isOpened()) {
            System.out.println("File not opened! Cannot execute command.");
            return;
        }

        if (arguments.length < 3) {
            System.out.println("Invalid arguments. Please choose a horizontal and vertical value.");
            return;
        }

        int transX = 0, transY = 0;
        //> translate 5 5
        //> translate 10 10 2
        try {
            transX = InputParser.parseIntegerSafely(arguments[1]);
            transY = InputParser.parseIntegerSafely(arguments[2]);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }

        if (arguments.length == 3) {
            for (SVGShape shape : SVGCanvas.getInstance().getShapes()) {
                try {
                    findInstanceAndTranslate(shape, transX, transY);
                } catch (NegativeValueException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
            System.out.println("Translated all shapes.");
            SVGFileWriter.setIsSaved(false);
        } else if (arguments.length == 4) {
            int indexToTranslate = 0;
            try {
                indexToTranslate = InputParser.parseIntegerSafely(arguments[3]);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            SVGShape shapeToTranslate = SVGCanvas.getInstance().getShapes().get(indexToTranslate - 1);
            try {
                findInstanceAndTranslate(shapeToTranslate, transX, transY);
            } catch (NegativeValueException e) {
                System.out.println(e.getMessage());
                return;
            }
            SVGFileWriter.setIsSaved(false);
            System.out.println("Translated " + shapeToTranslate);
        } else {
            System.out.println("Invalid number of arguments for translate command");
        }
    }

    /**
     * Applies the translation to the specific shape instance.
     *
     * @param shape The shape to translate.
     * @param transX Horizontal offset.
     * @param transY Vertical offset.
     */
    private void findInstanceAndTranslate(SVGShape shape, int transX, int transY) throws NegativeValueException {
        if(shape instanceof Line){
            Point newStartPoint = new Point((((Line) shape).getStartPoint().getX() + transX), ((Line) shape).getStartPoint().getY() + transY);
            ((Line) shape).setStartPoint(newStartPoint);
            Point newEndPoint = new Point((((Line) shape).getEndPoint().getX() + transX), ((Line) shape).getEndPoint().getY() + transY);
            ((Line) shape).setEndPoint(newEndPoint);
        }
        else if(shape instanceof Circle){
            Point newCentrePoint = new Point(((Circle) shape).getCenterPoint().getX() + transX, ((Circle) shape).getCenterPoint().getY() + transY);
            ((Circle) shape).setCenterPoint(newCentrePoint);
        }
        else if(shape instanceof Rectangle){
            Point newTopLeftPoint = new Point((((Rectangle) shape).getTopLeftPoint().getX() + transX), ((Rectangle) shape).getTopLeftPoint().getY() + transY);
            ((Rectangle) shape).setTopLeftPoint(newTopLeftPoint);
        }
        else if(shape instanceof Polygon){
            for (Point point : shape.getPoints()) {
                point.setX(point.getX() + transX);
                point.setY(point.getY() + transY);
            }
        }
    }
}
