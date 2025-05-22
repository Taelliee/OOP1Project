package bg.tu_varna.sit.a1.f23621652.commands;

import bg.tu_varna.sit.a1.f23621652.files.SVGFileWriter;
import bg.tu_varna.sit.a1.f23621652.files.ShapesFile;
import bg.tu_varna.sit.a1.f23621652.interfaces.Command;

import java.io.File;
import java.io.IOException;

/**
 * Command implementation for saving the current canvas to a new file.
 */
public class SaveAsAnotherFile implements Command {

    /**
     * Executes the save-as command.
     * Saves the SVG shapes to a file specified in the argument.
     *
     * @param arguments The second argument should be the new file path.
     */
    @Override
    public void execute(String[] arguments) {
        if (!OpenFile.isOpened()) {
            System.out.println("File not opened! Cannot execute command.");
            return;
        }
        if(SVGFileWriter.isSaved()){
            System.out.println("No changes were made!");
            return;
        }
        if (arguments.length == 2) {
            String filename = arguments[1];
            if (!ShapesFile.isSVGFile(filename)) {
                System.out.println("Invalid file format. Only .svg files are supported.");
                return;
            }
            File newFile = new File(filename);
            try {
                SVGFileWriter.saveToFile(newFile);
                SVGFileWriter.setIsSaved(true);
                System.out.println("Successfully saved as " + newFile.getName());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Invalid number of arguments for Save As command (saveas path.svg)");
        }
    }
}
