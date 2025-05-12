package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.interfaces.Command;
import bg.tu_varna.sit.а1.f23621652.parsers.SVGParser;
import bg.tu_varna.sit.а1.f23621652.files.ShapesFile;

import java.io.File;
import java.io.IOException;

public class OpenFile implements Command {
    //Всички останали команди могат да се изпълняват само ако има успешно зареден файл!
    private static boolean isOpened = false;

    public static boolean isOpened() {
        return isOpened;
    }

    public static void setIsOpened(boolean isOpened) {
        OpenFile.isOpened = isOpened;
    }

    @Override
    public void execute(String[] arguments) {
        if(arguments.length != 2){
            System.out.println("Invalid arguments for Open File command!");
            return;
        }
        try {
            ShapesFile.setFile(new File(arguments[1]));
            if(ShapesFile.getFile().exists()){
                System.out.println("Successfully opened " + ShapesFile.getFile().getName());
                SVGParser.parseShapes();
                isOpened = true;
            }
            else {
                if (ShapesFile.getFile().createNewFile()) {
                    System.out.println("Successfully created " + ShapesFile.getFile().getName());
                    isOpened = true;
                } else {
                    System.out.println("Failed to create file.");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
