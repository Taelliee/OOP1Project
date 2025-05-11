package bg.tu_varna.sit.а1.f23621652.models;

import bg.tu_varna.sit.а1.f23621652.exceptions.NegativeValueChecker;
import bg.tu_varna.sit.а1.f23621652.exceptions.NegativeValueException;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends SVGShape { // <rect>
    private int width;
    private int height;
    private Point topLeftPoint;
    private Point cornerRadius;
    // private String fill = "black";

    public Rectangle(int width, int height, Point topLeftPoint) throws NegativeValueException {
        this.topLeftPoint = topLeftPoint;
        this.cornerRadius = new Point(0,0);
        setWidth(width);
        setHeight(height);
    }

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
