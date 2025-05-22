package bg.tu_varna.sit.a1.f23621652.files;

import java.io.File;

/**
 * Utility class for managing the currently opened SVG file in the application.
 */
public class ShapesFile {
    private static File file;

    /**
     * Gets the file currently in use.
     *
     * @return the currently opened file.
     */
    public static File getFile(){
        return file;
    }

    /**
     * Sets the file to be used by the application.
     *
     * @param file the file to be set as the active file.
     */
    public static void setFile(File file) {
        ShapesFile.file = file;
    }

    public static boolean isSVGFile(String filename) {
        return filename.toLowerCase().endsWith(".svg");
    }
}
