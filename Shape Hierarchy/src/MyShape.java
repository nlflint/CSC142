/**
 * This is the base class for the class hierarchy for
 * Inheritance discussion.
 *
 * @author Dan Jinguji
 * @author Nathan Flint
 * @version 0.2
 *
 * Grading level: Challenge
 */
public class MyShape
{

    // dimensions
    protected int height;
    protected int width;

    /**
     * Constructor MyShape
     *
     * @param h The height of the shape
     * @param w The width of the shape
     */
    public MyShape(int h, int w)
    {
        // initialise instance variables
        height = h;
        width = w;
    }

    /**
     * Retrieve the height of the shape
     *
     * @return The height of the shape
     */
    public int getHeight()
    {
        return height;
    }
    /**
     * Retrieve the width of the shape
     *
     * @return The width of the shape
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * A placeholder method to calculate the area
     *
     * @return The area of the shape
     */
    public double getArea() {
        // placeholder code
        return 0;
    }

    /**
     * A placeholder method to name the shape
     *
     * @return The type for the shape
     */
    public String getName()
    {
        return "shape";
    }

    /**
     * Place holder method to get perimeter.
     *
     * @return the perimeter of the shape
     */
    public double getPerimeter( )
    {
        // place holder, not intended to be used for instances of this class.
        return 0;
    }
}