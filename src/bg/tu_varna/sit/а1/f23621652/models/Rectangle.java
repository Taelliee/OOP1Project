package bg.tu_varna.sit.а1.f23621652.models;

import bg.tu_varna.sit.а1.f23621652.exceptions.NegativeValueChecker;
import bg.tu_varna.sit.а1.f23621652.exceptions.NegativeValueException;

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

    /**
     * Constructs a Rectangle with specified width, height, top-left point, and corner radius.
     * @throws NegativeValueException if width or height is negative
     */
     public Rectangle(int width, int height, Point topLeftPoint, Point cornerRadius) throws NegativeValueException {
        this.topLeftPoint = topLeftPoint;
        this.cornerRadius = cornerRadius;
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
}
