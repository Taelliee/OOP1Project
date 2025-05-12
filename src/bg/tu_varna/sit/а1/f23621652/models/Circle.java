package bg.tu_varna.sit.а1.f23621652.models;

import bg.tu_varna.sit.а1.f23621652.exceptions.NegativeValueChecker;
import bg.tu_varna.sit.а1.f23621652.exceptions.NegativeValueException;

import java.util.ArrayList;
import java.util.List;

public class Circle extends SVGShape {
    private int radius;
    private Point centrePoint;

    public Circle(int radius) throws NegativeValueException {
        setRadius(radius);
        this.centrePoint = new Point(0,0);
    }

    public Circle(int radius, Point centrePoint) throws NegativeValueException {
        setRadius(radius);
        this.centrePoint = centrePoint;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) throws NegativeValueException {
        if(NegativeValueChecker.isValueNegative(radius)) {
            throw new NegativeValueException(NegativeValueChecker.message);
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
        StringBuilder sb = new StringBuilder("Circle\t\t");
        sb.append("radius: ").append(radius);
        sb.append(", centrePoint: ").append(centrePoint);
        sb.append(super.toString());
        return sb.toString();
    }

    @Override
    public String toSVGFormat() { //<circle r="10" cx="5" cy="5" fill="blue" />
        StringBuilder sb = new StringBuilder("<circle");
        sb.append(" r=\"").append(radius).append("\"");
        sb.append(" cx=\"").append(centrePoint.getX()).append("\"");
        sb.append(" cy=\"").append(centrePoint.getX()).append("\"");
        sb.append(super.toSVGFormat());
        sb.append(" />");

        return sb.toString();
    }

    @Override
    public List<Point> getPoints() {
        List<Point> points = new ArrayList<>();
        points.add(centrePoint);
        return points;
    }
}
