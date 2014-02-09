/**
 * This class represents a Rhombus.
 *
 * @author Nathan Flint
 * @version Assignment 5: Shape Hierarchy
 *
 * Grading Level: Challenge
 */
public class MyRhombus extends MyShape
{
    /**
     * Constructor. The rhombus is calculated as the mid
     * points of each side of a rectangle, joined to form
     * the rhombus.
     *
     * @param width width of the bounding rectangle
     * @param height height of the bounding rectangle
     */
    public MyRhombus(int height, int width)
    {
        // Call MyShape constructor
        super(height, width);
    }

    /**
     * Get the name of the shape type. This is a
     * method that "replaces" the inherited one.
     * The term for this is "override".
     */
    public String getName()
    {
        return "rhombus";
    }

    /**
     * Overrides the getArea method of MyShape.
     * Implements getting the area of a rhombus.
     *
     * @return the area of the rhombus
     */
    public double getArea()
    {
        // Calculates the area of the rhombus: (width * height) / 2
        return (width * height) / 2;
    }

    /**
     * Overrides method from MyShape.
     * Calculates the perimeter of a rhombus.
     *
     * @return perimeter of the rhombus
     */
    public double getPerimeter()
    {
        /*
         * Given a rhombus is 4 right triangles.
         * Then rhombus can be divided in 4
         * and pythagorean theorem can be used to find length of sides.
        */
        double shortWidth = width / 2;
        double shortWidthSquared = shortWidth * shortWidth;
        double shortHeight = height / 2;
        double shortHeightSquared = shortHeight * shortHeight;

        // calculates a hypotenuse using pythagorean theorem.
        double hypotenuse = Math.sqrt(shortWidthSquared + shortHeightSquared);

        // four hypotenuses equal perimeter.
        return hypotenuse * 4;
    }
}
