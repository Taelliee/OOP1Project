package bg.tu_varna.sit.a1.f23621652.commands;

import bg.tu_varna.sit.a1.f23621652.SVGCanvas;
import bg.tu_varna.sit.a1.f23621652.exceptions.CommandAbortedException;
import bg.tu_varna.sit.a1.f23621652.files.SVGFileWriter;
import bg.tu_varna.sit.a1.f23621652.interfaces.Command;
import bg.tu_varna.sit.a1.f23621652.files.ShapesFile;

import java.util.Scanner;

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
        if (!OpenFile.isOpened()) {
            System.out.println("File not opened! Cannot execute command.");
            return;
        }
        if(!SVGFileWriter.isSaved()){
            System.out.println("Do you want to save changes before closing the file? (yes/no/cancel)");
            Scanner input = new Scanner(System.in);
            String[] inputTokens = input.nextLine().trim().split("\\s+");

            switch (inputTokens[0]) {
                case "yes":
                case "y":
                    Command save = new SaveFile();
                    save.execute(null);
                    break;
                case "no":
                case "n":
                    System.out.println("Closing the file without saving...");
                    break;
                case "cancel":
                    //Unchecked exceptions do not require a try-catch block where they are thrown.
                    throw new CommandAbortedException("Close file operation cancelled by user.");
                default:
                    System.out.println("Invalid argument!");
                    throw new CommandAbortedException("Invalid input for close file.");
            }
        }

        SVGCanvas.getInstance().clearShapes();
        OpenFile.setIsOpened(false);
        System.out.println("Successfully closed " + ShapesFile.getFile().getName());
    }
}
