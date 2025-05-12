package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.files.SVGFileWriter;
import bg.tu_varna.sit.а1.f23621652.interfaces.Command;
import bg.tu_varna.sit.а1.f23621652.files.ShapesFile;

import java.io.IOException;

public class SaveFile implements Command {
    @Override
    public void execute(String[] arguments) {
        if(OpenFile.isOpened()) {
            try {
                SVGFileWriter.saveToFile(ShapesFile.getFile());
                System.out.println("Successfully saved changes to " + ShapesFile.getFile().getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("File not opened! Cannot execute command.");
        }
    }
}
