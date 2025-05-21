package bg.tu_varna.sit.a1.f23621652.models;

import bg.tu_varna.sit.a1.f23621652.exceptions.NegativeValueChecker;
import bg.tu_varna.sit.a1.f23621652.exceptions.NegativeValueException;
import bg.tu_varna.sit.a1.f23621652.parsers.InputParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a circle shape in SVG format.
 * Extends SVGShape and implements methods for circle-specific properties and SVG formatting.
 */
public class Circle extends SVGShape{
    private int radius;
    private Point centerPoint;

    /**
     * Constructs a Circle with specified radius and centered at (0,0).
     * @throws NegativeValueException if radius is negative
     */
    public Circle(int radius) throws NegativeValueException {
        setRadius(radius);
        this.centerPoint = new Point(0,0);
    }

    public int getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the circle.
     *
     * @param radius The new radius value
     * @throws NegativeValueException if radius is negative
     */
    public void setRadius(int radius) throws NegativeValueException {
        if(NegativeValueChecker.isValueNegative(radius)) {
            throw new NegativeValueException(NegativeValueChecker.message);
        }
        else {
            this.radius = radius;
        }
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint){
        this.centerPoint = centerPoint;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Circle\t\t");
        sb.append("radius: ").append(radius);
        sb.append(", centrePoint: ").append(centerPoint);
        sb.append(super.toString());
        return sb.toString();
    }

    /**
     * Converts the circle to SVG format string.
     *
     * @return SVG-formatted string representing the circle
     */
    @Override
    public String toSVGFormat() { //<circle r="10" cx="5" cy="5" fill="blue" />
        StringBuilder sb = new StringBuilder("<circle");
        sb.append(" r=\"").append(radius).append("\"");
        sb.append(" cx=\"").append(centerPoint.getX()).append("\"");
        sb.append(" cy=\"").append(centerPoint.getX()).append("\"");
        sb.append(super.toSVGFormat());
        sb.append(" />");

        return sb.toString();
    }

    /**
     * Gets all points that define the circle (just the center point).
     *
     * @return List containing the center point
     */
    @Override
    public List<Point> getPoints() {
        List<Point> points = new ArrayList<>();
        points.add(centerPoint);
        return points;
    }

    /**
     * Creates a Circle shape based on the provided arguments.
     *<pre>
     * Expected arguments:
     * - args[2] = radius (required)
     * - args[3] = cx (optional, center x-coordinate)
     * - args[4] = cy (optional, center y-coordinate)
     * - args[last] = fill (optional, only if total args is 4 or 6)
     *
     * Examples:
     * - create circle 50
     * - create circle 50 100 200
     * - create circle 50 blue
     * - create circle 50 100 200 blue
     *</pre>
     * @param args Array of string arguments.
     * @return A new Circle instance with the parsed parameters.
     * @throws NegativeValueException if radius is negative.
     * @throws IllegalArgumentException if required arguments are missing or invalid.
     */
    // create circle r [cx cy] [fill]
    public static SVGShape createCircle(String[] args) throws NegativeValueException {
        if (args.length < 3) throw new IllegalArgumentException("Circle requires a radius.");

        int r = InputParser.parseIntegerSafely(args[2]);
        Circle circle = new Circle(r);

        if (args.length >= 5) {
            int cx = InputParser.parseIntegerSafely(args[3]);
            int cy = InputParser.parseIntegerSafely(args[4]);
            circle.setCenterPoint(new Point(cx, cy));
        }

        if (args.length == 4 || args.length == 6) {
            String fill = args[args.length - 1];
            circle.setFill(fill);
        }

        return circle;
    }
}
