package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.SVGCanvas;
import bg.tu_varna.sit.а1.f23621652.interfaces.Command;
import bg.tu_varna.sit.а1.f23621652.models.*;

public class TranslateShape implements Command {
    @Override
    public void execute(String[] arguments) {
        //> translate 10 100
        //> translate 10 100 2
        int transX = Integer.parseInt(arguments[1]);
        int transY = Integer.parseInt(arguments[2]);

        if(arguments.length == 3){
            //"Translated all shapes."
            for (SVGShape shape: SVGCanvas.getInstance().getShapes()) {
                if(shape instanceof Line){
                    //set
                }
                else if(shape instanceof Circle){
                    //setRadius();
                }
                else if(shape instanceof Rectangle){

                }
                else if(shape instanceof Polygon){

                }
            }
        }
        else if(arguments.length == 4){
            int indexToTranslate = Integer.parseInt(arguments[3]);
            SVGShape shapeToTranslate = SVGCanvas.getInstance().getShapes().get(indexToTranslate);
            //if instance ?
        }
        else{
            System.out.println("Invalid number of arguments for translate command");
        }
    }
}
