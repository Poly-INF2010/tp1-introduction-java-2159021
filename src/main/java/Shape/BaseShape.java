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
        this.coords = new ArrayList<>();
    }

    /** TODO
     * Create a BaseShape from a collection of 2D points
     * @param coords The collection of 2D points
     */
    public BaseShape(Collection<Point2d> coords) {
        this.coords = new ArrayList<>(coords);
    }

    /** TODO
     * Add a deep copy of the 2D point to the Shape
     * @param coord 2D point to add
     * @return Updated BaseShape
     */
    public BaseShape add(Point2d coord) {
        BaseShape newShape = this.clone();
        newShape.coords.add(coord.clone());
        return newShape;
    }

    /** TODO
     * Add a deep copy of the 2D points of the shape to the current shape
     * @param shape Shape to add to the current shape
     * @return Updated BaseShape
     */
    public BaseShape add(BaseShape shape) {
        BaseShape newShape = this.clone();
        newShape.coords.addAll(shape.cloneCoords());
        return newShape;
    }

    /** TODO
     * Add a deep copy of the points in the collection to the shape
     * @param coords Collections of point to add
     * @return Updated BaseShape
     */
    public BaseShape addAll(Collection<Point2d> coords) {
        BaseShape newShape = this.clone();
        //newShape.coords.addAll(cloneCoords(coords));
        newShape.coords.addAll(coords);
        return newShape;
    }

    /** TODO
     * Remove the 2D point from the shape
     * @param coord Point to remove
     * @return Updated BaseShape
     */
    public BaseShape remove(Point2d coord) {
        BaseShape newShape = this.clone();
        newShape.coords.remove(coord);
        return newShape;
    }

    /** TODO
     * Remove the 2D points in the shape from the current shape
     * @param shape Shape containing the points to remove
     * @return Updated BaseShape
     */
    public BaseShape remove(BaseShape shape) {
        BaseShape newShape = this.clone();
        newShape.coords.removeAll(shape.cloneCoords());
        return newShape;
    }

    /** TODO
     * Remove the 2D points in the collection from the current shape
     * @param coords Collection of 2D points to remove
     * @return Updated BaseShape
     */
    public BaseShape removeAll(Collection<Point2d> coords) {
        BaseShape newShape = this.clone();
        //newShape.coords.removeAll(cloneCoords(coords));
        newShape.coords.removeAll(coords);
        return newShape;
    }

    /** TODO
     *  Replace all the coords in a shape with new ones
     * @param newCoords new coords to replace the old one
     * @return Updated BaseShape
     * */
    public BaseShape replaceAll(Collection<Point2d> newCoords) {
        BaseShape newShape = this.clone();
        newShape.coords.clear();
        //newShape.coords.addAll(cloneCoords(newCoords));
        newShape.coords.addAll(newCoords);
        return newShape;
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
        return coords.stream().mapToDouble(Point2d::X).max().orElse(Double.NaN);
    }

    /** TODO
     * @return Maximum Y coordinate of the shape
     */
    public Double getMaxY() {
        return coords.stream().mapToDouble(Point2d::Y).max().orElse(Double.NaN);
    }

    /** TODO
     * @return 2D Point containing the maximum X and Y coordinates of the shape
     */
    public Point2d getMaxCoord() {
        Double maxX = getMaxX();
        Double maxY = getMaxY();
        return (!maxX.isNaN() && !maxY.isNaN()) ? new Point2d(maxX, maxY) : null;
    }

    /** TODO
     * @return Minimum X coordinate of the shape
     */
    public Double getMinX() { return coords.stream().mapToDouble(Point2d::X).min().orElse(Double.NaN); }

    /** TODO
     * @return Minimum Y coordinate of the shape
     */
    public Double getMinY() {
        return coords.stream().mapToDouble(Point2d::Y).min().orElse(Double.NaN);
    }

    /** TODO
     * @return 2D point containing the minimum X and Y coordinate of the shape
     */
    public Point2d getMinCoord() {
        Double minX = getMinX();
        Double minY = getMinY();
        return (!minX.isNaN() && !minY.isNaN()) ? new Point2d(minX, minY) : null;
    }

    /** TODO
     * @return Deep copy of the current shape
     */
    public BaseShape clone() {
        return new BaseShape(cloneCoords());
    }
}
