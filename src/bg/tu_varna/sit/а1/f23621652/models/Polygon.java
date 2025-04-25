package bg.tu_varna.sit.а1.f23621652.models;

import java.util.*;

public class Polygon extends SVGShape { // <polygon>
    private List<Point> points;

    public Polygon() {
        points = new ArrayList<>();
    }

    public void addPoint(Point point){
        points.add(point);
    }

    public List<Point> getPoints(){
        return this.points;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Polygon\t\t");
        sb.append("points: ").append(points);
        return sb.toString();
    }
}
