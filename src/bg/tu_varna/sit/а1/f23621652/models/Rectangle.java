package bg.tu_varna.sit.а1.f23621652.models;

import bg.tu_varna.sit.а1.f23621652.exceptions.NegativeValueChecker;
import bg.tu_varna.sit.а1.f23621652.exceptions.SVGShapeException;

public class Rectangle extends SVGShape { // <rect>
    private Point topLeftPoint;
    private Point cornerRadius;
    private double width;
    private double height;
    // private String fill = "black";
    // private String style;

    public Rectangle(Point topLeftPoint, double width, double height) throws SVGShapeException {
        this.topLeftPoint = topLeftPoint;
        this.cornerRadius = new Point(0,0);
        setWidth(width);
        setHeight(height);
    }

    public Rectangle(Point topLeftPoint, Point cornerRadius, double width, double height) throws SVGShapeException {
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

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) throws SVGShapeException {
        if(NegativeValueChecker.isValueNegative(width)) {
         throw new SVGShapeException(NegativeValueChecker.message);
        }
        else {
            this.width = width;
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws SVGShapeException {
        if(NegativeValueChecker.isValueNegative(height)) {
            throw new SVGShapeException(NegativeValueChecker.message);
        }
        else {
            this.height = height;
        }
    }

    //ToString()..
}
