package bg.tu_varna.sit.a1.f23621652;

import bg.tu_varna.sit.a1.f23621652.managers.CommandManager;

/**
 * Main application class that serves as the entry point for the SVG shapes management program.
 * It continuously asks the user for commands and assigns their execution to the CommandManager.
 */
public class Application {
    /**
     * The main method that starts the application.
     * It runs in an infinite loop, continuously accepting and processing user commands.
     *
     * @param args Command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        while(true) {
            CommandManager.chooseCommand();
        }
    }
}
