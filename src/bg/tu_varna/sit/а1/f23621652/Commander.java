package bg.tu_varna.sit.а1.f23621652;

import java.util.*;

public class Commander {
    private static String mainMenu = "The following commands are supported:\n" +
            "open <file> \topens <file>\n" +
            "close \tcloses currently opened file\n" +
            "save \tsaves the currently open file\n" +
            "saveas <file> \tsaves the currently open file in <file>\n" +
            "help \tprints this information\n" +
            "exit \texists the program";

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
            default:
                System.out.println("This command is not on the list. ");
                System.out.println(mainMenu);
                break;
        }
    }
}
