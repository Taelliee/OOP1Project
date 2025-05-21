package bg.tu_varna.sit.a1.f23621652.commands;

import bg.tu_varna.sit.a1.f23621652.SVGCanvas;
import bg.tu_varna.sit.a1.f23621652.files.SVGFileWriter;
import bg.tu_varna.sit.a1.f23621652.interfaces.Command;
import bg.tu_varna.sit.a1.f23621652.files.ShapesFile;

import java.util.Scanner;

/**
 * Command implementation that closes the currently opened SVG file.
 * After closing, no further commands can be executed except opening a file again.
 */
public class CloseFile implements Command {
    private static boolean isCommandAborted = false;

    public static boolean isCommandAborted() {
        return isCommandAborted;
    }

    public static void setIsCommandAborted(boolean isCommandAborted) {
        CloseFile.isCommandAborted = isCommandAborted;
    }

    /**
     * Executes the close file operation.
     If there are unsaved changes, it prompts the user to decide whether to:
     * <ul>
     *   <li>Save the changes before closing (by typing "yes" or "y")</li>
     *   <li>Close without saving (by typing "no" or "n")</li>
     *   <li>Cancel the operation entirely (by typing "cancel")</li>
     * </ul>
     * Any invalid input will also result in canceling the operation.
     * After a successful close, it clears all shapes from the canvas,
     * marks the file as closed, and resets the save state.
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
                case "yes", "y" -> {
                    Command save = new SaveFile();
                    save.execute(null);
                }
                case "no", "n" -> System.out.println("Closing the file without saving...");
                case "cancel" -> {
                    System.out.println("Operation cancelled by user.");
                    isCommandAborted = true;
                    return;
                }
                default -> {
                    System.out.println("Invalid argument!");
                    isCommandAborted = true;
                    return;
                }
            }
        }

        SVGCanvas.getInstance().clearShapes();
        OpenFile.setIsOpened(false);
        SVGFileWriter.setIsSaved(true);
        isCommandAborted = false;
        System.out.println("Successfully closed " + ShapesFile.getFile().getName());
    }
}
