package bg.tu_varna.sit.a1.f23621652.files;

import bg.tu_varna.sit.a1.f23621652.SVGCanvas;
import bg.tu_varna.sit.a1.f23621652.models.SVGShape;

import java.io.*;

/**
 * Utility class responsible for writing SVG shapes to a file in valid SVG format.
 */
public class SVGFileWriter {
    private static boolean isSaved = true;

    public static boolean isSaved() {
        return isSaved;
    }

    public static void setIsSaved(boolean isSaved) {
        SVGFileWriter.isSaved = isSaved;
    }

    /**
     * Writes the current SVG shapes from the canvas to the specified file.
     * The output is formatted as a valid SVG document.
     *
     * @param file the file to which the shapes should be saved.
     * @throws IOException if an I/O error occurs during writing.
     */
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
