package bg.tu_varna.sit.а1.f23621652;

import java.util.*;

public class Commander {
    private static final StringBuilder mainMenu = new StringBuilder()
            .append("The following commands are supported:\n")
            .append("open <file>    opens <file>\n")
            .append("close          closes currently opened file\n")
            .append("save           saves the currently open file\n")
            .append("saveas <file>  saves the currently open file in <file>\n")
            .append("help           prints this information\n")
            .append("exit           exits the program");

    private static final Map<String, Runnable> commands = new HashMap<>(); //belongs to the class (not instances); can't be reassigned

    static { //initializes the commands map before any method is called, runs only once when loaded into memory
        commands.put("open", FileManager::openFile); //<file>
        commands.put("close", FileManager::closeFile);
        commands.put("save", FileManager::saveFile);
        commands.put("saveas", FileManager::saveAsAnotherFile); //<file>
        commands.put("save as", FileManager::saveAsAnotherFile); //<file>
        commands.put("help", () -> System.out.println(mainMenu));
        commands.put("exit", FileManager::exitProgram);
        commands.put("print", ShapeHelper::printShapes);
        commands.put("create", ShapeHelper::addShape);
        commands.put("erase", () -> ShapeHelper.eraseShape(0)); //<n> should change n
        commands.put("translate", ShapeHelper::translateShape); //[<n>]
        commands.put("within", ShapeHelper::printShapesWithin); //<option>
    } //() -> is lambda anonymous method

    public static void chooseCommand(){
        System.out.print("Write your command: \n> ");
        Scanner input = new Scanner(System.in);
        String[] inputTokens = input.nextLine().split(" ");
        String command = inputTokens[0].toLowerCase();

        Runnable action = commands.get(command);
        //how to pass the other parameters??

        if (action != null) {
            action.run();
        } else {
            System.out.println("This command is not on the list.");
            System.out.println(mainMenu);
        }
    }
}
