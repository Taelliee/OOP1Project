package bg.tu_varna.sit.a1.f23621652.commands;

import bg.tu_varna.sit.a1.f23621652.interfaces.Command;
import bg.tu_varna.sit.a1.f23621652.parsers.SVGParser;
import bg.tu_varna.sit.a1.f23621652.files.ShapesFile;

import java.io.File;
import java.io.IOException;

/**
 * Command implementation for opening an existing SVG file or creating a new one.
 * All other commands require a file to be opened first.
 */
public class OpenFile implements Command {
    private static boolean isOpened = false;

    /**
     * Returns whether a file is currently opened.
     *
     * @return true if a file is opened, false otherwise.
     */
    public static boolean isOpened() {
        return isOpened;
    }

    /**
     * Sets the open state of the file.
     *
     * @param isOpened The new open state.
     */
    public static void setIsOpened(boolean isOpened) {
        OpenFile.isOpened = isOpened;
    }

    /**
     * Executes the open file command.
     * Tries to open or create a file and parses its contents.
     *
     * @param arguments The second argument should be the file path.
     */
    @Override
    public void execute(String[] arguments) {
        if (OpenFile.isOpened()) {
            System.out.println("File is already opened (" + ShapesFile.getFile() + ")");
            return;
        }
        if(arguments.length != 2){
            System.out.println("Invalid arguments for Open File command!");
            return;
        }

        String filename = arguments[1];
        if (!ShapesFile.isSVGFile(filename)) {
            System.out.println("Invalid file format. Only .svg files are supported.");
            return;
        }
        try {
            ShapesFile.setFile(new File(filename));
            if(ShapesFile.getFile().exists()){
                SVGParser.parseShapes();
                System.out.println("Successfully opened " + ShapesFile.getFile().getName());
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
