package bg.tu_varna.sit.a1.f23621652;

import bg.tu_varna.sit.a1.f23621652.models.SVGShape;

import java.util.*;
/**
 * Singleton class that represents an SVG canvas containing a collection of SVG shapes.
 * Provides methods for managing shapes (add, remove, clear) and follows the Singleton pattern
 * to ensure only one instance exists throughout the application.
 */
public class SVGCanvas {
    private static SVGCanvas instance;
    private final List<SVGShape> shapes;

    /**
     * Private constructor to prevent instantiation from outside the class.
     * Initializes an empty list of shapes.
     */
    private SVGCanvas() {
        shapes = new ArrayList<>();
    }

    /**
     * Returns the singleton instance of SVGCanvas.
     * Creates a new instance if one doesn't already exist.
     *
     * @return The single instance of SVGCanvas
     */
    public static SVGCanvas getInstance() {
        if (instance == null) {
            instance = new SVGCanvas();
        }
        return instance;
    }

    /**
     * Adds a shape to the canvas.
     *
     * @param shape The SVGShape to be added to the canvas
     */
    public void addShape(SVGShape shape) {
        shapes.add(shape);
    }

    /**
     * Removes a shape from the canvas.
     *
     * @param shape The SVGShape to be removed from the canvas
     */
    public void eraseShape(SVGShape shape){
        shapes.remove(shape);
    }

    /**
     * Returns all shapes currently on the canvas.
     *
     * @return List of SVGShape objects on the canvas
     */
    public List<SVGShape> getShapes() {
        return shapes;
    }

    /**
     * Removes all shapes from the canvas.
     */
    public void clearShapes(){
        this.shapes.clear();
    }
}
