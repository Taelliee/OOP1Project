package bg.tu_varna.sit.a1.f23621652.commands;

import bg.tu_varna.sit.a1.f23621652.files.SVGFileWriter;
import bg.tu_varna.sit.a1.f23621652.interfaces.Command;
import bg.tu_varna.sit.a1.f23621652.files.ShapesFile;

import java.io.IOException;

/**
 * Command implementation for saving changes to the currently opened SVG file.
 */
public class SaveFile implements Command {

    /**
     * Executes the save command.
     * Writes the current SVG canvas to the file opened by the user.
     *
     * @param arguments Not used in this command.
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
        try {
            SVGFileWriter.saveToFile(ShapesFile.getFile());
            SVGFileWriter.setIsSaved(true);
            System.out.println("Successfully saved changes to " + ShapesFile.getFile().getName());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
