package bg.tu_varna.sit.а1.f23621652;

public class Rectangle implements SVGObject{ // <rect>
    private Point topLeftPoint;
    private Point cornerRadius;
    private double width;
    private double height;
    // private String fill = "black";
    // private String style;

    public Rectangle(Point topLeftPoint, double width, double height) throws SVGObjectException{
        this.topLeftPoint = topLeftPoint;
        this.cornerRadius = new Point(0,0);
        setWidth(width);
        setHeight(height);
    }

    public Rectangle(Point topLeftPoint, Point cornerRadius, double width, double height) throws SVGObjectException{
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

    public void setWidth(double width) throws SVGObjectException{
        if(NegativeValueChecker.isValueNegative(width)) {
         throw new SVGObjectException(NegativeValueChecker.message);
        }
        else {
            this.width = width;
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws SVGObjectException{
        if(NegativeValueChecker.isValueNegative(height)) {
            throw new SVGObjectException(NegativeValueChecker.message);
        }
        else {
            this.height = height;
        }
    }

    //ToString()..
}
