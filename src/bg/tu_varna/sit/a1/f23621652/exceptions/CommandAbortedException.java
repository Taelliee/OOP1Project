package bg.tu_varna.sit.a1.f23621652.exceptions;

public class CommandAbortedException extends RuntimeException{
    //unchecked exception
    public CommandAbortedException(String message) {
        super(message);
    }
}
