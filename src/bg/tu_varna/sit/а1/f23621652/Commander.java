package bg.tu_varna.sit.а1.f23621652;

import java.util.*;

public class Commander {
    private final static StringBuilder mainMenu = new StringBuilder()
            .append("The following commands are supported:\n")
            .append("open <file>    opens <file>\n")
            .append("close          closes currently opened file\n")
            .append("save           saves the currently open file\n")
            .append("saveas <file>  saves the currently open file in <file>\n")
            .append("help           prints this information\n")
            .append("exit           exits the program");

    public static void chooseCommand(){
        System.out.print("Write your command: \n> ");
        Scanner input = new Scanner(System.in);
        String[] commands = input.nextLine().split(" ");
        String command = commands[0].toLowerCase();

        switch (command){
            case "open":
                break;
            case "close":
                break;
            case "save":
                break;
            case "save as":
            case "saveas":
                break;
            case "help":
                System.out.println(mainMenu);
                break;
            case "print":
                break;
            case "create":
                FigureHelper.addSVGFigure();
                break;
            case "erase": //<n>
                FigureHelper.eraseSVGFigure(0); //change n
                break;
            case "translate ": //[<n>]
                FigureHelper.translateSVGFigure();
                break;
            case "within ": //<option>
                FigureHelper.printFiguresWithin();
                break;
            default:
                System.out.println("This command is not on the list. ");
                System.out.println(mainMenu);
                break;
        }
    }
}
