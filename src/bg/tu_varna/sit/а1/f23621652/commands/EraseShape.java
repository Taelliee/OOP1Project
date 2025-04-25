package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.SVGCanvas;
import bg.tu_varna.sit.а1.f23621652.interfaces.Command;
import bg.tu_varna.sit.а1.f23621652.models.SVGShape;

import java.util.List;

public class EraseShape implements Command {
    @Override
    public void execute(String[] arguments) {
        int index = Integer.parseInt(arguments[1]);
        List<SVGShape> shapes = SVGCanvas.getInstance().getShapes();
        try{
            SVGShape shapeToErase = shapes.get(index - 1);
            SVGCanvas.getInstance().eraseShape(shapeToErase);
            System.out.println("Erased a " + shapeToErase.getClass().getSimpleName() + " (" + index+ ")");
        }catch (IndexOutOfBoundsException e){
            System.out.println("There is no shape with this index!");
        }
    }
}
