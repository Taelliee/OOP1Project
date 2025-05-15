package bg.tu_varna.sit.a1.f23621652.interfaces;

/**
 * Represents a command that can be executed with string arguments.
 * Used for defining actions such as open, save, create, etc.
 */
public interface Command {
    /**
     * Executes the command with the provided arguments.
     *
     * @param arguments the input parameters needed to perform the command.
     */
    void execute(String[] arguments);
}
