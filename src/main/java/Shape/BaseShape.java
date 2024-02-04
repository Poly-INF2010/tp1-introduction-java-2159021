package Shape;

import Interface.Transform;
import Point.Point2d;

import java.util.*;
import java.util.stream.Collectors;

public class BaseShape extends Transform implements Cloneable {
    private final Collection<Point2d> coords;

//helper function to clone a list of points
  public Collection<Point2d> cloneCoords(Collection<Point2d> coords) {
        return coords.stream().map(Point2d::clone).collect(Collectors.toList());
  }

    /** TODO
     * Create a BaseShape with empty coordinades
     */
    public BaseShape() {
        this.coords = new ArrayList<Point2d>();
    }

    /** TODO
     * Create a BaseShape from a collection of 2D points
     * @param coords The collection of 2D points
     */
    public BaseShape(Collection<Point2d> coords) { this.coords = new ArrayList<Point2d>(cloneCoords(coords));}

    /** TODO
     * Add a deep copy of the 2D point to the Shape
     * @param coord 2D point to add
     * @return Updated BaseShape
     */
    public BaseShape add(Point2d coord) {
        this.coords.add(coord.clone());
        return this;
    }

    /** TODO
     * Add a deep copy of the 2D points of the shape to the current shape
     * @param shape Shape to add to the current shape
     * @return Updated BaseShape
     */
    public BaseShape add(BaseShape shape) {
        this.coords.addAll(shape.cloneCoords());
        return this;
    }

    /** TODO
     * Add a deep copy of the points in the collection to the shape
     * @param coords Collections of point to add
     * @return Updated BaseShape
     */
    public BaseShape addAll(Collection<Point2d> coords) {
        this.coords.addAll(cloneCoords(coords));
        return this;
    }

    /** TODO
     * Remove the 2D point from the shape
     * @param coord Point to remove
     * @return Updated BaseShape
     */
    public BaseShape remove(Point2d coord) {
        this.coords.remove(coord);
        return this;
    }

    /** TODO
     * Remove the 2D points in the shape from the current shape
     * @param shape Shape containing the points to remove
     * @return Updated BaseShape
     */
    public BaseShape remove(BaseShape shape) {
        this.removeAll(shape.getCoords());
        return this;
    }

    /** TODO
     * Remove the 2D points in the collection from the current shape
     * @param coords Collection of 2D points to remove
     * @return Updated BaseShape
     */
    public BaseShape removeAll(Collection<Point2d> coords) {
        this.coords.removeAll(coords);
        return this;
    }

    /** TODO
     *  Replace all the coords in a shape with new ones
     * @param newCoords new coords to replace the old one
     * @return Updated BaseShape
     * */
    public BaseShape replaceAll(Collection<Point2d> newCoords) {
        this.coords.clear();
        this.coords.addAll(cloneCoords(newCoords));
        return this;
    }

    /** TODO
     * Return a shallow copy of the coordinates of the shape
     * @return Shallow copy of all coordinates contained by this BaseShape
     */
    public Collection<Point2d> getCoords() {
        return new ArrayList<>(coords);
    }

    /** TODO
     * Create and return a deep copy of the coordinates of the shape
     * @return Deep copy of all coordinates contained by this BaseShape
     */
    public Collection<Point2d> cloneCoords() {
        return cloneCoords(coords);
    }

    /** TODO
     * @return Maximum X coordinate of the shape
     */
    public Double getMaxX() {
        double maxX = -Double.MAX_VALUE;

        for (Point2d point : this.coords) {
            double currentX = point.X();
            if (currentX > maxX) {
                maxX = currentX;
            }
        }
        return maxX;
    }

    public Double getMinX() {
        double minX = Double.MAX_VALUE;

        for (Point2d point : this.coords) {
            double currentX = point.X();
            if (currentX < minX) {
                minX = currentX;
            }
        }
        return minX;
    }

    public Double getMaxY() {
        double maxY = -Double.MAX_VALUE;

        for (Point2d point : this.coords) {
            double currentY = point.Y();
            if (currentY > maxY) {
                maxY = currentY;
            }
        }
        return maxY;
    }

    public Double getMinY() {
        double minY = Double.MAX_VALUE;

        for (Point2d point : this.coords) {
            double currentY = point.Y();
            if (currentY < minY) {
                minY = currentY;
            }
        }
        return minY;
    }

    public Point2d getMaxCoord() {
        Double maxX = getMaxX();
        Double maxY = getMaxY();
        return (!maxX.isNaN() && !maxY.isNaN()) ? new Point2d(maxX, maxY) : null;
    }

    public Point2d getMinCoord() {
        Double minX = getMinX();
        Double minY = getMinY();
        return (!minX.isNaN() && !minY.isNaN()) ? new Point2d(minX, minY) : null;
    }
    public BaseShape clone() {
        return new BaseShape(this.cloneCoords());
    }
}
