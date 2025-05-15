package bg.tu_varna.sit.a1.f23621652.models;

import bg.tu_varna.sit.a1.f23621652.exceptions.NegativeValueException;
import bg.tu_varna.sit.a1.f23621652.parsers.InputParser;

import java.util.*;

/**
 * Represents a polygon shape in SVG format.
 * Extends SVGShape and implements methods for polygon-specific properties and SVG formatting.
 * A polygon is defined by a series of connected points.
 */
public class Polygon extends SVGShape { // <polygon>
    private List<Point> points;

    public Polygon() {
        points = new ArrayList<>();
    }

    /**
     * Adds a point to the polygon.
     *
     * @param point The point to add to the polygon
     */
    public void addPoint(Point point){
        points.add(point);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Polygon\t\t");
        sb.append("points: ").append(points);
        sb.append(super.toString());
        return sb.toString();
    }

    /**
     * Converts the polygon to SVG format string.
     *
     * @return SVG-formatted string representing the polygon
     */
    @Override
    public String toSVGFormat() { //<polygon points="100,10 150,190 50,190" fill="purple" />
        final StringBuilder sb = new StringBuilder("<polygon");
        sb.append(" points=\"");
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            sb.append(p.getX()).append(",").append(p.getY());
            if (i < points.size() - 1) {
                sb.append(" ");
            }
        }
        sb.append("\"");
        sb.append(super.toSVGFormat());
        sb.append(" />");
        return sb.toString();
    }

    /**
     * Gets all points that define the polygon.
     *
     * @return List of points defining the polygon
     */
    @Override
    public List<Point> getPoints(){
        return this.points;
    }

    /**
     * Creates a Polygon shape based on the provided arguments.
     *
     * Expected arguments:
     * - args[2...] = alternating x and y coordinates (at least 3 pairs)
     * - args[last] = fill (optional, if number of args is odd)
     *
     * Examples:
     * - create polygon 100 10 150 190 50 190
     * - create polygon 100 10 150 190 50 190 blue
     *
     * @param args Array of string arguments.
     * @return A new Polygon instance with the parsed parameters.
     * @throws IllegalArgumentException if not enough points are provided.
     * @throws NumberFormatException if any coordinate is invalid.
     */
    public static SVGShape createPolygon(String[] args) throws NegativeValueException {
        if (args.length < 8)
            throw new IllegalArgumentException("Polygon must have at least 3 points (6 values).");

        Polygon polygon = new Polygon();

        int length = args.length;
        if (length % 2 != 0) {
            length--;
            String fill = args[args.length - 1];
            polygon.setFill(fill);
        }

        for (int i = 2; i < length; i += 2) {
            int x = InputParser.parseIntegerSafely(args[i]);
            int y = InputParser.parseIntegerSafely(args[i + 1]);
            polygon.addPoint(new Point(x, y));
        }

        return polygon;
    }
}
