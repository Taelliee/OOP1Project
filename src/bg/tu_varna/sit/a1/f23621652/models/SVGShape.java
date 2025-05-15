package bg.tu_varna.sit.a1.f23621652.models;

import bg.tu_varna.sit.a1.f23621652.interfaces.Pointer;
import bg.tu_varna.sit.a1.f23621652.interfaces.SVGFormatter;

/**
 * Abstract base class representing an SVG shape.
 * Implements common properties and behaviors for all SVG shapes,
 * includes fill and stroke colors, and provides abstract methods
 * for shape-specific implementations.
 */
public abstract class SVGShape implements Pointer, SVGFormatter {
    private String fill = "black";
    private String stroke = "black";

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    /**
     * Returns a string representation of the shape's common properties.
     *
     * @return String containing fill and stroke properties if they differ from defaults
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(!this.fill.equals("black")){
            sb.append(", fill=").append(fill);
        }
        if(!this.stroke.equals("black")){
            sb.append(", stroke=").append(stroke);
        }
        return sb.toString();
    }

    /**
     * Converts the common shape properties to SVG format string.
     *
     * @return SVG-formatted string for fill and stroke attributes if they differ from defaults
     */
    @Override
    public String toSVGFormat() {
        StringBuilder sb = new StringBuilder();
        if(!this.fill.equals("black")){
            sb.append(" fill=\"").append(fill).append("\"");
        }
        if(!this.stroke.equals("black")){
            sb.append(" stroke=\"").append(stroke).append("\"");
        }
        return sb.toString();
    }
}
