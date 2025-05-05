package bg.tu_varna.sit.а1.f23621652.models;

import java.io.File;

public class ShapesFile {
    private static File file = new File("shapes.svg");
    //private boolean isOpen ?
    public static File getFile(){
        return file;
    }
}
