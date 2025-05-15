package bg.tu_varna.sit.a1.f23621652.commands;

import bg.tu_varna.sit.a1.f23621652.SVGCanvas;
import bg.tu_varna.sit.a1.f23621652.interfaces.Command;
import bg.tu_varna.sit.a1.f23621652.files.ShapesFile;

/**
 * Command implementation that closes the currently opened SVG file.
 * After closing, no further commands can be executed except opening a file again.
 */
public class CloseFile implements Command {
    /**
     * Executes the close file operation.
     * Clears all shapes from the canvas and marks the file as closed.
     *
     * @param arguments Not used in this command.
     */
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
