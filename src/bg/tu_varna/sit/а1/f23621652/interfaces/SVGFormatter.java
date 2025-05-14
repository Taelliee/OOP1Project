package bg.tu_varna.sit.а1.f23621652.interfaces;

/**
 * Interface for objects that can be converted to SVG format.
 * Enables exporting shapes and other drawable elements to valid SVG syntax.
 */
public interface SVGFormatter {
    /**
     * Converts the object to a string representation in SVG format.
     *
     * @return the SVG-formatted string representing the object.
     */
    String toSVGFormat();
}
