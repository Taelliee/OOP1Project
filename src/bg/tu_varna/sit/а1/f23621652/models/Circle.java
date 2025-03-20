package bg.tu_varna.sit.а1.f23621652.models;

import bg.tu_varna.sit.а1.f23621652.exceptions.NegativeValueChecker;
import bg.tu_varna.sit.а1.f23621652.exceptions.SVGShapeException;

public class Circle extends SVGShape {
    private double radius;
    private Point centrePoint;
    // private String fill = "black";
    // private String style;

    public Circle(double radius) throws SVGShapeException {
        setRadius(radius);
        this.centrePoint = new Point(0,0);
    }

    public Circle(double radius, Point centrePoint) throws SVGShapeException {
        setRadius(radius);
        this.centrePoint = centrePoint;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws SVGShapeException {
        if(NegativeValueChecker.isValueNegative(radius)) {
            throw new SVGShapeException(NegativeValueChecker.message);
        }
        else {
            this.radius = radius;
        }
    }

    public Point getCentrePoint() {
        return centrePoint;
    }

    public void setCentrePoint(Point centrePoint){
        this.centrePoint = centrePoint;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Circle ");
        sb.append("radius=").append(radius);
        sb.append(", centrePoint=").append(centrePoint);
        sb.append(super.toString());
        return sb.toString();
    }
}
