package bg.tu_varna.sit.a1.f23621652.models;

/**
 * Represents a point in the Coordinate system with x and y coordinates.
 * Used to define positions of shapes in the SVG canvas.
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(').append(x);
        sb.append(", ").append(y).append(')');
        return sb.toString();
    }
}
