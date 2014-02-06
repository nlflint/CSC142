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
}
