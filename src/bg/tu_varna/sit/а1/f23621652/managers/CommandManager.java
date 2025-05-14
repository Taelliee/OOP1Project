package bg.tu_varna.sit.а1.f23621652.managers;

import bg.tu_varna.sit.а1.f23621652.commands.*;
import bg.tu_varna.sit.а1.f23621652.enums.CommandType;
import bg.tu_varna.sit.а1.f23621652.interfaces.Command;

import java.util.*;

/**
 * Manages the execution of commands in the SVG shapes application.
 * Implements the Command pattern to handle various user commands.
 * Maintains a mapping of command types to their respective command objects.
 */
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
        commands.put(CommandType.CREATE, new CreateShape());
        commands.put(CommandType.ERASE, new EraseShape()); //<n>
        commands.put(CommandType.TRANSLATE, new TranslateShape()); //[<n>]
        commands.put(CommandType.WITHIN, new PrintShapesWithin()); //<option>
    }

    /**
     * Prompts the user for a command, parses the input, and executes the corresponding command.
     * Displays an error message if the command is not recognized.
     */
    public static void chooseCommand(){
        System.out.print("Write your command: \n> ");
        Scanner input = new Scanner(System.in);
        String[] inputTokens = input.nextLine().trim().split("\\s+"); //\s is whitespace character - space, tab, new line

        CommandType commandType = CommandType.convertFromText(inputTokens[0]);
        Command command = commands.get(commandType);

        if (command != null) {
            command.execute(inputTokens);
        } else {
            System.out.println("This command is not on the list. Type \"help\" for available commands.");
        }
    }
}
