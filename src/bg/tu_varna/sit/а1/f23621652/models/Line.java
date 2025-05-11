package bg.tu_varna.sit.а1.f23621652.models;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Point> getPoints() {
        List<Point> points = new ArrayList<>();
        points.add(startPoint);
        points.add(endPoint);
        return points;
    }
}
