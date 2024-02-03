package Letter;

import Point.Point2d;
import Shape.*;

import java.util.Collection;

public final class LetterFactory {
    final static Double maxHeight = 150.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;


    /** TODO
     * Create the letter A graphically
     * @return BaseShape containing the letter A
     */
    public static BaseShape create_A()  {
        return null;
    }

    /** TODO
     * Create the letter B graphically
     * @return BaseShape containing the letter B
     */
    public static BaseShape create_B() {
        double zero = 0;
        Rectangle barre = new Rectangle(maxWidth, maxHeight);
        Rectangle right = new Rectangle(maxWidth-stripeThickness, maxHeight);
        right.replaceAll(right.translate(right.getCoords(), new Point2d(stripeThickness, zero)));
        barre.remove(right);

        Circle cExt1 = new Circle(halfMaxHeight);
        Circle cInt1 = new Circle(halfMaxHeight-stripeThickness);
        cExt1.remove(cInt1);
        BaseShape cExt2 = new BaseShape(cExt1.cloneCoords());
        cExt2.replaceAll(cExt2.translate(cExt2.getCoords(), new Point2d(zero, halfMaxHeight/2)));
        cExt1.replaceAll(cExt1.translate(cExt2.getCoords(), new Point2d(zero, -halfMaxHeight/2)));

        BaseShape B = new BaseShape(barre.cloneCoords());
        B.add(cExt1);
        B.add(cExt2);
        return B;
    }

    /** TODO
     * Create the letter C graphically
     * @return BaseShape containing the letter C
     */
    public static BaseShape create_C() {
        Ellipse cExt = new Ellipse(maxWidth, maxHeight);
        Ellipse cInt = new Ellipse(maxWidth-stripeThickness, maxHeight-stripeThickness);
        cExt.remove(cInt);
        Collection<Point2d> coords = cExt.cloneCoords();
        coords.removeIf(point2d -> point2d.X()>maxWidth-10);

        BaseShape C = new BaseShape(coords);
        return C;
    }

    /** TODO
     * Create the letter E graphically
     * @return BaseShape containing the letter E
     */
    public static BaseShape create_E() {
        double zero = 0;
        Rectangle left = new Rectangle(maxWidth, maxHeight);
        Rectangle right = new Rectangle(maxWidth-stripeThickness, maxHeight);
        right.replaceAll(right.translate(right.getCoords(), new Point2d(stripeThickness, zero)));
        left.remove(right);

        Rectangle barre1 = new Rectangle(maxWidth, stripeThickness);
        Rectangle barre2 = barre1.clone();
        barre2.replaceAll(barre2.translate(barre2.getCoords(), new Point2d(zero, halfMaxHeight-stripeThickness/2)));
        Rectangle barre3 = barre1.clone();
        barre3.replaceAll(barre3.translate(barre3.getCoords(), new Point2d(zero, -halfMaxHeight-stripeThickness/2)));

        BaseShape E = new BaseShape(left.cloneCoords());
        E.add(barre1);
        E.add(barre2);
        E.add(barre3);
        return E;
    }

    /** TODO
     * Create the letter H graphically
     * @return BaseShape containing the letter H
     */
    public static BaseShape create_H() {
        Rectangle rExt = new Rectangle(maxWidth, maxHeight);
        Rectangle rInt = new Rectangle(maxWidth-stripeThickness, maxHeight);
        rExt.remove(rInt);

        Rectangle barre = new Rectangle(maxWidth, stripeThickness);

        BaseShape H = new BaseShape(rExt.cloneCoords());
        H.add(barre);
        return H;
    }

    /** TODO
     * Create the letter N graphically
     * @return BaseShape containing the letter N
     */
    public static BaseShape create_N() {
        return null;
    }

    /** TODO
     * Create the letter O graphically
     * @return BaseShape containing the letter O
     */
    public static BaseShape create_O() {
        Ellipse oExt = new Ellipse(maxWidth, maxHeight);
        Ellipse oInt = new Ellipse(maxWidth-stripeThickness, maxHeight-stripeThickness);
        oExt.remove(oInt);

        BaseShape O = new BaseShape(oExt.cloneCoords());
        return O;
    }

}
