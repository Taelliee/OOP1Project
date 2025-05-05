package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.SVGCanvas;
import bg.tu_varna.sit.а1.f23621652.interfaces.Command;
import bg.tu_varna.sit.а1.f23621652.models.SVGShape;
import bg.tu_varna.sit.а1.f23621652.models.ShapesFile;

import java.io.FileWriter;
import java.io.IOException;

public class SaveFile implements Command {
    @Override
    public void execute(String[] arguments) {
        try {
            FileWriter fileWriter = new FileWriter(ShapesFile.getFile());
            StringBuilder textToWrite = new StringBuilder();
            for (SVGShape shape : SVGCanvas.getInstance().getShapes()) {
                textToWrite.append("");
            }

            fileWriter.write(textToWrite.toString());
            System.out.println("Successfully saved changes to " + ShapesFile.getFile().getName());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
