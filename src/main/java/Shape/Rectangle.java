package Shape;

import Point.Point2d;

import java.util.ArrayList;
import java.util.Collection;

public class Rectangle extends BaseShape {
    /** TODO
     * Create a filled rectangle centered on (0, 0)
     * @param width Width of the rectangle
     * @param height Height of the rectangle
     */
    public Rectangle(Double width, Double height) {
        Collection<Point2d> coords = new ArrayList<>();

        for (double x = 0; x < width; x += 0.5) {
            for (double y = 0; y < height; y += 0.5) {
                coords.add(new Point2d(x, y));
            }
        }
        this.addAll(coords);
    }

    /** TODO
     * Create a filled rectangle centered on (0, 0)
     * @param dimensions 2D point containing the width and height of the rectangle
     */
    public Rectangle(Point2d dimensions) {
        Collection<Point2d> coords = new ArrayList<>();

        for (double x = 0; x < dimensions.X(); x += 0.5) {
            for (double y = 0; y < dimensions.Y(); y += 0.5) {
                coords.add(new Point2d(x, y));
            }
        }
        this.addAll(coords);
    }

    /**
     * Create a rectangle from a given collection of Points
     * @param coords The collection of 2D points
     */
    private Rectangle(Collection<Point2d> coords) {
        this.addAll(coords);
    }

    /** TODO
     * @return Deep copy of the rectangle
     */
    @Override
    public Rectangle clone() {
        return new Rectangle(this.cloneCoords());
    }
}
