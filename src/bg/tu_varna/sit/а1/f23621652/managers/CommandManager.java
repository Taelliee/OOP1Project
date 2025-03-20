package bg.tu_varna.sit.а1.f23621652.managers;

import bg.tu_varna.sit.а1.f23621652.commands.*;
import bg.tu_varna.sit.а1.f23621652.enums.CommandType;
import bg.tu_varna.sit.а1.f23621652.interfaces.Command;

import java.util.*;

public class CommandManager {
    private static final Map<CommandType, Command> commands = new HashMap<>(); //belongs to the class (not instances); can't be reassigned

    static { //initializes the commands map before any method is called, runs only once when loaded into memory
        commands.put(CommandType.OPEN, new OpenFile()); //<file>
        commands.put(CommandType.CLOSE, new CloseFile());
        commands.put(CommandType.SAVE, new SaveFile());
        commands.put(CommandType.SAVE_AS, new SaveAsAnotherFile()); //<file>
        commands.put(CommandType.HELP, new HelpMenu());
        commands.put(CommandType.EXIT, new ExitProgram());
        commands.put(CommandType.PRINT, new PrintShapes());
        commands.put(CommandType.CREATE, new AddShape());
        commands.put(CommandType.ERASE, new EraseShape()); //<n>
        commands.put(CommandType.TRANSLATE, new TranslateShape()); //[<n>]
        commands.put(CommandType.WITHIN, new PrintShapesWithin()); //<option>
    }

    public static void chooseCommand(){
        System.out.print("Write your command: \n> ");
        Scanner input = new Scanner(System.in);
        String[] inputTokens = input.nextLine().split(" ");

        CommandType commandType = CommandType.convertFromText(inputTokens[0]);
        Command command = commands.get(commandType);
        String argument = inputTokens.length > 1 ? inputTokens[1] : "";

        if (command != null) {
            command.execute(argument);
        } else {
            System.out.println("This command is not on the list. Type \"help\" for available commands.");
        }
    }
}
