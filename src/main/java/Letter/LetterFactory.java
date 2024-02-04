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
        double zero = 0;
        Rectangle left = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle right = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle barre = new Rectangle(maxWidth, stripeThickness-5);
        double angleLeft = Math.toRadians(20);
        left.replaceAll(left.rotate(left.cloneCoords(), angleLeft));
        left.replaceAll(left.translate(left.cloneCoords(), new Point2d(-halfMaxWidth,zero)));
        double angleRight = Math.toRadians(-20);
        right.replaceAll(left.rotate(right.cloneCoords(), angleRight));
        right.replaceAll(right.translate(right.cloneCoords(), new Point2d(halfMaxWidth,zero)));

        BaseShape A = new BaseShape(barre.translate(barre.cloneCoords(), new Point2d(zero, halfMaxWidth-stripeThickness)));
        A.add(left);
        A.add(right);
        return A;
    }

    /** TODO
     * Create the letter B graphically
     * @return BaseShape containing the letter B
     */
    public static BaseShape create_B() {
        double zero = 0;

        Circle cExt1 = new Circle(halfMaxHeight);
        Circle cInt1 = new Circle(halfMaxHeight-stripeThickness);
        cExt1.remove(cInt1);

        BaseShape cExt2 = new BaseShape(cExt1.cloneCoords());
        cExt2.replaceAll(cExt2.translate(cExt2.cloneCoords(), new Point2d(zero, -halfMaxHeight)));
        cExt1.replaceAll(cExt1.translate(cExt2.cloneCoords(), new Point2d(zero, halfMaxHeight)));

        Rectangle barre = new Rectangle(stripeThickness, maxHeight);
        BaseShape B = new BaseShape(barre.translate(barre.cloneCoords(), new Point2d(-halfMaxWidth+stripeThickness, zero)));
        B.add(cExt1);
        B.add(cExt2);
        return B;
    }

    /** TODO
     * Create the letter C graphically
     * @return BaseShape containing the letter C
     */
    public static BaseShape create_C() {
        double zero =0;
        Ellipse cExt = new Ellipse(maxWidth, maxHeight);
        Ellipse cInt = new Ellipse(halfMaxWidth, halfMaxHeight);
        cExt.remove(cInt);
        Rectangle gap = new Rectangle(stripeThickness, halfMaxWidth);
        //gap.replaceAll(gap.translate(gap.cloneCoords(), new Point2d(halfMaxWidth/2,zero)));
        cExt.remove(gap);

        BaseShape C = new BaseShape(cExt.cloneCoords());
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
        barre2.replaceAll(barre2.translate(barre2.cloneCoords(), new Point2d(zero, halfMaxHeight-halfStripeThickness)));
        Rectangle barre3 = barre1.clone();
        barre3.replaceAll(barre3.translate(barre3.cloneCoords(), new Point2d(zero, -halfMaxHeight+halfStripeThickness )));

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
        double zero = 0;
        Rectangle right = new Rectangle(stripeThickness, maxHeight);
        right.replaceAll(right.translate(right.cloneCoords(), new Point2d(maxWidth-halfStripeThickness, zero)));

        Rectangle left = new Rectangle(stripeThickness, maxHeight);
        left.replaceAll(left.translate(left.cloneCoords(), new Point2d(-maxWidth+halfStripeThickness, zero)));

        Rectangle middle = new Rectangle(stripeThickness, maxHeight+5);
        double angleLeft = Math.toRadians(145);
        middle.replaceAll(middle.rotate(middle.cloneCoords(), angleLeft));

        BaseShape N = new BaseShape(middle.cloneCoords());
        N.add(left);
        N.add(right);
        return N;
    }

    /** TODO
     * Create the letter O graphically
     * @return BaseShape containing the letter O
     */
    public static BaseShape create_O() {
        Ellipse oExt = new Ellipse(maxWidth, maxHeight);
        Ellipse oInt = new Ellipse(maxWidth-stripeThickness, maxHeight-stripeThickness);
        //oExt.remove(oInt);

        //BaseShape O = new BaseShape(oExt.cloneCoords());
        return oExt;
    }

}
