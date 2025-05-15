package bg.tu_varna.sit.a1.f23621652.commands;

import bg.tu_varna.sit.a1.f23621652.files.SVGFileWriter;
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
        if(OpenFile.isOpened()){
            if (arguments.length == 2) {
                File newFile = new File(arguments[1]);
                try {
                    SVGFileWriter.saveToFile(newFile);
                    System.out.println("Successfully saved as " + newFile.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Invalid number of arguments for Save As command (saveas path.svg)");
            }
        }
        else {
            System.out.println("File not opened! Cannot execute command.");
        }
    }
}
