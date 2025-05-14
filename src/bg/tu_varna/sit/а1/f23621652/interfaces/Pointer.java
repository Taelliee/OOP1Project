package bg.tu_varna.sit.а1.f23621652.interfaces;

import bg.tu_varna.sit.а1.f23621652.models.Point;

import java.util.List;

/**
 * Interface for objects that have one or more defining points.
 * Used for spatial operations like boundary checking or transformation.
 */
public interface Pointer {
    /**
     * Returns a list of points that define the object.
     *
     * @return a list of {@link Point} instances representing the object's geometry.
     */
    List<Point> getPoints();
}
