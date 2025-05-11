package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.interfaces.Command;

public class SaveAsAnotherFile implements Command {
    @Override
    public void execute(String[] arguments) {
        if(OpenFile.isOpened()){

        }
        else {
            System.out.println("File not opened! Cannot execute command.");
        }
    }
}
