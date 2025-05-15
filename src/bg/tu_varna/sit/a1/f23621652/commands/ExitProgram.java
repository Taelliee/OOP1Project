package bg.tu_varna.sit.a1.f23621652.commands;

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
        System.out.println("Exiting the program...");
        System.exit(0);
    }
}
