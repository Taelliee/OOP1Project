package bg.tu_varna.sit.а1.f23621652.files;

import bg.tu_varna.sit.а1.f23621652.SVGCanvas;
import bg.tu_varna.sit.а1.f23621652.models.*;

import java.io.*;

public class SVGFileWriter {
    public static void saveToFile(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        StringBuilder textToWrite = new StringBuilder();
        textToWrite.append("<?xml version=\"1.0\" standalone=\"no\"?>\n")
                .append("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\"\n")
                .append(" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n")
                .append("<svg>\n");
        for (SVGShape shape : SVGCanvas.getInstance().getShapes()) {
            textToWrite.append(" ").append(shape.toSVGFormat()).append("\n");
        }
        textToWrite.append("</svg>");

        fileWriter.write(textToWrite.toString());
        fileWriter.close();
    }
}
