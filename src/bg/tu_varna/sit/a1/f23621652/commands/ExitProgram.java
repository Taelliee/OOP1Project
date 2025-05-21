package bg.tu_varna.sit.a1.f23621652.commands;

import bg.tu_varna.sit.a1.f23621652.files.SVGFileWriter;
import bg.tu_varna.sit.a1.f23621652.interfaces.Command;

/**
 * Command implementation for exiting the application.
 */
public class ExitProgram implements Command {

    /**
     * Executes the exit operation.
     * If there are unsaved changes, this command invokes the {@link CloseFile} command
     * to prompt the user to save, discard, or cancel the operation.
     * If the user cancels or provides invalid input during the close process, the exit is aborted.
     * Otherwise, the program terminates after the file is properly closed or the user decides to discard changes.
     * @param arguments Not used in this command.
     */
    @Override
    public void execute(String[] arguments) {
        if(!SVGFileWriter.isSaved()) {
            Command close = new CloseFile();
            close.execute(null);
            if(CloseFile.isCommandAborted()) {
                System.out.println("Exit aborted.");
                return;
            }
        }
        System.out.println("Exiting the program...");
        System.exit(0);
    }
}
