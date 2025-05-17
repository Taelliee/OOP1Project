package bg.tu_varna.sit.a1.f23621652.commands;

import bg.tu_varna.sit.a1.f23621652.exceptions.CommandAbortedException;
import bg.tu_varna.sit.a1.f23621652.files.SVGFileWriter;
import bg.tu_varna.sit.a1.f23621652.interfaces.Command;

/**
 * Command implementation for exiting the application.
 */
public class ExitProgram implements Command {

    /**
     * Executes the exit operation.
     * Terminates the program immediately.
     *
     * @param arguments Not used in this command.
     */
    @Override
    public void execute(String[] arguments) {
        if(!SVGFileWriter.isSaved()) {
            Command close = new CloseFile();
            try {
                close.execute(null);
            } catch (CommandAbortedException e) {
                System.out.println("Exit aborted: " + e.getMessage());
                return;
            }
        }
        System.out.println("Exiting the program...");
        System.exit(0);
    }
}
