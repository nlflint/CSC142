/**
 * Represents a circle.
 *
 * @author Nathan Flint
 * @version Assignment 5: Shape Hierarchy
 *
 * Grading level: Challenge
 */
public class MyCircle extends MyEllipse
{
    /**
     * Constructor for MyCircle. Calls super class to initialize class.
     *
     * @param diameter
     */
    public MyCircle(int diameter)
    {
        // Calls the MyEllipse constructor, using same width and
        // height as the diameter
        super(diameter,diameter);

    }

    /**
     * Overrides the getArea method of MyEllipse.
     * Implements getting the area of a circle.
     *
     * @return the area of the circle
     */
    public double getArea()
    {
        return 0.25 * Math.PI * width * width;
    }
}
