package bg.tu_varna.sit.а1.f23621652.files;

import java.io.File;

public class ShapesFile {
    private static File file;

    public static File getFile(){
        return file;
    }

    public static void setFile(File file) {
        ShapesFile.file = file;
    }
}
