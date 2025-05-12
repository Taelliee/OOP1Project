package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.SVGCanvas;
import bg.tu_varna.sit.а1.f23621652.interfaces.Command;
import bg.tu_varna.sit.а1.f23621652.files.ShapesFile;

public class CloseFile implements Command {
    //След затваряне не може да изпълнява други команди, освен отваряне на файл!

    @Override
    public void execute(String[] arguments) {
        if(OpenFile.isOpened()){
            SVGCanvas.getInstance().clearShapes();
            OpenFile.setIsOpened(false);
            System.out.println("Successfully closed " + ShapesFile.getFile().getName());
        }
        else {
            System.out.println("File not opened! Cannot execute command.");
        }
    }
}
