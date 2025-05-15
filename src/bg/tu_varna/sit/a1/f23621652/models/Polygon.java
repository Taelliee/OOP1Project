package bg.tu_varna.sit.a1.f23621652.models;

import java.util.*;

/**
 * Represents a polygon shape in SVG format.
 * Extends SVGShape and implements methods for polygon-specific properties and SVG formatting.
 * A polygon is defined by a series of connected points.
 */
public class Polygon extends SVGShape { // <polygon>
    private List<Point> points;

    public Polygon() {
        points = new ArrayList<>();
    }

    /**
     * Adds a point to the polygon.
     *
     * @param point The point to add to the polygon
     */
    public void addPoint(Point point){
        points.add(point);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Polygon\t\t");
        sb.append("points: ").append(points);
        sb.append(super.toString());
        return sb.toString();
    }

    /**
     * Converts the polygon to SVG format string.
     *
     * @return SVG-formatted string representing the polygon
     */
    @Override
    public String toSVGFormat() { //<polygon points="100,10 150,190 50,190" fill="purple" />
        final StringBuilder sb = new StringBuilder("<polygon");
        sb.append(" points=\"");
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            sb.append(p.getX()).append(",").append(p.getY());
            if (i < points.size() - 1) {
                sb.append(" ");
            }
        }
        sb.append("\"");
        sb.append(super.toSVGFormat());
        sb.append(" />");
        return sb.toString();
    }

    /**
     * Gets all points that define the polygon.
     *
     * @return List of points defining the polygon
     */
    @Override
    public List<Point> getPoints(){
        return this.points;
    }
}
