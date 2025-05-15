package bg.tu_varna.sit.a1.f23621652.models;

import bg.tu_varna.sit.a1.f23621652.exceptions.NegativeValueChecker;
import bg.tu_varna.sit.a1.f23621652.exceptions.NegativeValueException;
import bg.tu_varna.sit.a1.f23621652.parsers.InputParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a rectangle shape in SVG format.
 * Extends SVGShape and implements methods for rectangle-specific properties and SVG formatting.
 */
public class Rectangle extends SVGShape { // <rect>
    private int width;
    private int height;
    private Point topLeftPoint;
    private Point cornerRadius;

    /**
     * Constructs a Rectangle with specified width, height, and top-left point.
     * Corner radius is set at (0,0).
     * @throws NegativeValueException if width or height is negative
     */
    public Rectangle(int width, int height, Point topLeftPoint) throws NegativeValueException {
        this.topLeftPoint = topLeftPoint;
        this.cornerRadius = new Point(0,0);
        setWidth(width);
        setHeight(height);
    }

    public Point getTopLeftPoint() {
        return topLeftPoint;
    }

    public void setTopLeftPoint(Point topLeftPoint) {
        this.topLeftPoint = topLeftPoint;
    }

    public Point getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(Point cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    public int getWidth() {
        return width;
    }

    /**
     * Sets the width of the rectangle.
     *
     * @param width The new width
     * @throws NegativeValueException if width is negative
     */
    public void setWidth(int width) throws NegativeValueException {
        if(NegativeValueChecker.isValueNegative(width)) {
         throw new NegativeValueException(NegativeValueChecker.message);
        }
        else {
            this.width = width;
        }
    }

    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the rectangle.
     *
     * @param height The new height
     * @throws NegativeValueException if height is negative
     */
    public void setHeight(int height) throws NegativeValueException {
        if(NegativeValueChecker.isValueNegative(height)) {
            throw new NegativeValueException(NegativeValueChecker.message);
        }
        else {
            this.height = height;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Rectangle\t");
        sb.append("width: ").append(width);
        sb.append(", height: ").append(height);
        sb.append(", topLeftPoint: ").append(topLeftPoint);
        if(this.cornerRadius.getX() != 0 && this.cornerRadius.getY() != 0){
            sb.append(", cornerRadius: ").append(cornerRadius);
        }
        sb.append(super.toString());
        return sb.toString();
    }

    /**
     * Converts the rectangle to SVG format string.
     *
     * @return SVG-formatted string representing the rectangle
     */
    @Override
    public String toSVGFormat() { // <rect width="10" height="10" x="5" y="5" rx="10" ry="10 fill="green" />
        StringBuilder sb = new StringBuilder("<rect");

        sb.append(" width=\"").append(width).append("\"");
        sb.append(" height=\"").append(height).append("\"");
        sb.append(" x=\"").append(topLeftPoint.getX()).append("\"");
        sb.append(" y=\"").append(topLeftPoint.getY()).append("\"");

        if (cornerRadius.getX() != 0 || cornerRadius.getY() != 0) {
            sb.append(" rx=\"").append(cornerRadius.getX()).append("\"");
            sb.append(" ry=\"").append(cornerRadius.getY()).append("\"");
        }

        sb.append(super.toSVGFormat());
        sb.append(" />");
        return sb.toString();
    }

    /**
     * Gets all four corner points that define the rectangle.
     *
     * @return List of points defining the rectangle's corners
     */
    @Override
    public List<Point> getPoints(){
        List<Point> points = new ArrayList<>();
        points.add(topLeftPoint);
        points.add(new Point(topLeftPoint.getX()+width, topLeftPoint.getY()));
        points.add(new Point(topLeftPoint.getX()+width, topLeftPoint.getY()-height));
        points.add(new Point(topLeftPoint.getX(), topLeftPoint.getY()-height));
        return points;
    }

    /**
     * Creates a Rectangle shape based on the provided arguments.
     *
     * Expected arguments:
     * - args[2] = width (required)
     * - args[3] = height (required)
     * - args[4] = x (top-left corner x-coordinate)
     * - args[5] = y (top-left corner y-coordinate)
     * - args[6] = rx (optional, corner radius x)
     * - args[7] = ry (optional, corner radius y)
     * - args[last] = fill (optional, only if total args is 7 or 9)
     *
     * Examples:
     * - create rectangle 100 50 10 10
     * - create rectangle 100 50 10 10 red
     * - create rectangle 100 50 10 10 5 5
     * - create rectangle 100 50 10 10 5 5 blue
     *
     * @param args Array of string arguments.
     * @return A new Rectangle instance with the parsed parameters.
     * @throws NegativeValueException if any size value is negative.
     * @throws IllegalArgumentException if required arguments are missing or invalid.
     */
    public static SVGShape createRectangle(String[] args) throws NegativeValueException {
        if (args.length < 6)
            throw new IllegalArgumentException("Rectangle requires: width height x y");

        int width = InputParser.parseIntegerSafely(args[2]);
        int height = InputParser.parseIntegerSafely(args[3]);
        int x = InputParser.parseIntegerSafely(args[4]);
        int y = InputParser.parseIntegerSafely(args[5]);

        Rectangle rect = new Rectangle(width, height, new Point(x, y)) ;

        if (args.length >= 8) {
            int rx = InputParser.parseIntegerSafely(args[6]);
            int ry = InputParser.parseIntegerSafely(args[7]);
            rect.setCornerRadius(new Point(rx, ry));
        }

        if (args.length == 7 || args.length == 9) {
            String fill = args[args.length - 1];
            rect.setFill(fill);
        }

        return rect;
    }
}
