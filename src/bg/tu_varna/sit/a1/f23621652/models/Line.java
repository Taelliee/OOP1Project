package bg.tu_varna.sit.a1.f23621652.models;

import bg.tu_varna.sit.a1.f23621652.exceptions.NegativeValueException;
import bg.tu_varna.sit.a1.f23621652.parsers.InputParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a line shape in SVG format.
 * Extends SVGShape and implements methods for line-specific properties and SVG formatting.
 */
public class Line extends SVGShape {
    private Point startPoint;
    private Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Line\t\t");
        sb.append("startPoint: ").append(startPoint);
        sb.append(", endPoint: ").append(endPoint);
        sb.append(super.toString());
        return sb.toString();
    }

    /**
     * Converts the line to SVG format string.
     *
     * @return SVG-formatted string representing the line
     */
    @Override
    public String toSVGFormat() { //<line x1="0" y1="0" x2="300" y2="200" stroke="pink" />
        StringBuilder sb = new StringBuilder("<line");
        sb.append(" x1=\"").append(startPoint.getX()).append("\"");
        sb.append(" y1=\"").append(startPoint.getY()).append("\"");
        sb.append(" x2=\"").append(endPoint.getX()).append("\"");
        sb.append(" y2=\"").append(endPoint.getY()).append("\"");
        sb.append(super.toSVGFormat());
        sb.append(" />");
        return sb.toString();
    }

    /**
     * Gets all points that define the line (start and end points).
     *
     * @return List containing the start and end points
     */
    @Override
    public List<Point> getPoints() {
        List<Point> points = new ArrayList<>();
        points.add(startPoint);
        points.add(endPoint);
        return points;
    }

    /**
     * Creates a Line shape based on the provided arguments.
     *
     * Expected arguments:
     * - args[2] = x1 (start point x-coordinate)
     * - args[3] = y1 (start point y-coordinate)
     * - args[4] = x2 (end point x-coordinate)
     * - args[5] = y2 (end point y-coordinate)
     * - args[6] = stroke (optional)
     *
     * Examples:
     * - create line 0 0 100 100
     * - create line 0 0 100 100 red
     *
     * @param args Array of string arguments.
     * @return A new Line instance with the parsed parameters.
     * @throws IllegalArgumentException if required arguments are missing or invalid.
     */
    public static SVGShape createLine(String[] args) throws NegativeValueException {
        if (args.length < 6)
            throw new IllegalArgumentException("Line requires: x1 y1 x2 y2");

        int x1 = InputParser.parseIntegerSafely(args[2]);
        int y1 = InputParser.parseIntegerSafely(args[3]);
        int x2 = InputParser.parseIntegerSafely(args[4]);
        int y2 = InputParser.parseIntegerSafely(args[5]);

        Line line = new Line(new Point(x1, y1), new Point(x2, y2));

        if (args.length == 7) {
            String stroke = args[6];
            line.setStroke(stroke);
        }

        return line;
    }
}
