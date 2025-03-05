package bg.tu_varna.sit.а1.f23621652;

public class Circle extends SVGObject{
    private double radius;
    private Point centrePoint;
    // private String fill = "black";
    // private String style;

    public Circle(double radius) throws SVGObjectException{
        setRadius(radius);
        this.centrePoint = new Point(0,0);
    }

    public Circle(double radius, Point centrePoint) throws SVGObjectException{
        setRadius(radius);
        this.centrePoint = centrePoint;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws SVGObjectException{
        if(NegativeValueChecker.isValueNegative(radius)) {
            throw new SVGObjectException(NegativeValueChecker.message);
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
