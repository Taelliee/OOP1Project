package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.SVGCanvas;
import bg.tu_varna.sit.а1.f23621652.interfaces.Command;
import bg.tu_varna.sit.а1.f23621652.models.SVGShape;
import bg.tu_varna.sit.а1.f23621652.files.ShapesFile;

import java.io.FileWriter;
import java.io.IOException;

public class SaveFile implements Command {
    @Override
    public void execute(String[] arguments) {
        if(OpenFile.isOpened()) {
            try {
                FileWriter fileWriter = new FileWriter(ShapesFile.getFile());
                StringBuilder textToWrite = new StringBuilder();
                textToWrite.append("<?xml version=\"1.0\" standalone=\"no\"?>\n")
                        .append("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\"\n")
                        .append(" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n")
                        .append("<svg>\n");
                for (SVGShape shape : SVGCanvas.getInstance().getShapes()) {
                    textToWrite.append(" ").append(shape.toSVGFormat())
                            .append("\n");
                }
                textToWrite.append("</svg>");

                fileWriter.write(textToWrite.toString());
                System.out.println("Successfully saved changes to " + ShapesFile.getFile().getName());
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("File not opened! Cannot execute command.");
        }
    }
}
