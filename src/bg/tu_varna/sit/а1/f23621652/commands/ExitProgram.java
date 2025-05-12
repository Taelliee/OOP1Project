package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.interfaces.Command;

public class ExitProgram implements Command {
    @Override
    public void execute(String[] arguments) {
        System.out.println("Exiting the program...");
        System.exit(0);
    }
}
