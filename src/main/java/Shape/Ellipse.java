package Shape;

import Point.Point2d;

import java.util.Collection;

public class Ellipse extends BaseShape {
    /** TODO
     * Create a filled Ellipse that is centered on (0, 0)
     * @param widthDiameter Width of the Ellipse
     * @param heightDiameter Height of the Ellipse
     */
    public Ellipse(Double widthDiameter, Double heightDiameter) {
        Collection<Point2d> coords = null;

        double centerX = widthDiameter / 2.0;
        double centerY = heightDiameter / 2.0;

        for (double x = 0; x < widthDiameter; x+=0.5) {
            for (double y = 0; y < heightDiameter; y+=0.5) {
                double normalizedX = (x - centerX) / (widthDiameter / 2.0);
                double normalizedY = (y - centerY) / (heightDiameter / 2.0);

                if ((normalizedX * normalizedX + normalizedY * normalizedY) <= 1.0) {
                    coords.add(new Point2d(x, y));
                }
            }
        }
        this.addAll(coords);
    }

    /** TODO
     * Create a filled Ellipse that is centered on (0,0)
     * @param dimensions 2D point containing the width and height of the Ellipse
     */
    public Ellipse(Point2d dimensions) {

    }

    /**
     * Create an Ellipse from a given collection of 2D points
     * @param coords Collection of 2D points
     */
    private Ellipse(Collection<Point2d> coords) {

    }

    /** TODO
     * @return Deep Copy of the Ellipse
     */
    @Override
    public Ellipse clone() {
        return null;
    }
}
