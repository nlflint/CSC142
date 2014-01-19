import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Created with IntelliJ IDEA.
 * User: nate
 * Date: 1/13/14
 * Time: 9:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Program
{
    public static void main(String[] args)
    {
        Flags flags = new Flags();
        //flags.drawNigerFlag();
        //flags.drawSwedishFlag();
        //flags.drawNorwayFlag();
        //flags.drawSeychellesFlag();
        //flags.drawAlabamaFlag();

        //Line2D.Double first = new Line2D.Double(40,0,440,240);
        Line2D.Double first = new Line2D.Double(0,24,360+40,264);
        Line2D.Double second = new Line2D.Double(0,240,400,0);

        Point2D.Double intersection = findIntersetion(first, second);
        System.out.println("Intersection point: (" + intersection.x + "," + intersection.y + ")");

    }

    public static Point2D.Double findIntersetion(Line2D first, Line2D second)
    {
        double x1 = first.getX1();
        double y1 = first.getY1();
        double x2 = first.getX2();
        double y2 = first.getY2();

        double x3 = second.getX1();
        double y3 = second.getY1();
        double x4 = second.getX2();
        double y4 = second.getY2();

        double d = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4); 
        if (d == 0) return null;

        double xi = ((x3-x4)*(x1*y2-y1*x2)-(x1-x2)*(x3*y4-y3*x4))/d;
        double yi = ((y3-y4)*(x1*y2-y1*x2)-(y1-y2)*(x3*y4-y3*x4))/d;

        return new Point2D.Double(xi,yi);


    }
}
