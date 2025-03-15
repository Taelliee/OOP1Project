package bg.tu_varna.sit.а1.f23621652;

import java.util.*;

public class SVGCanvas {
    private static SVGCanvas instance;
    private final List<SVGShape> shapes;

    private SVGCanvas() {
        shapes = new ArrayList<>();
    }

    public static SVGCanvas getInstance() {
        if (instance == null) {
            instance = new SVGCanvas();
        }
        return instance;
    }

    public void addShape(SVGShape shape) {
        shapes.add(shape);
    }

    public void eraseShape(SVGShape shape){
        shapes.remove(shape);
    }

    public List<SVGShape> getShapes() {
        return shapes;
    }
}
