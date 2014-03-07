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
     * @param diameter diameter of the circle
     */
    public MyCircle(int diameter)
    {
        // Calls the MyEllipse constructor, using same width and
        // height as the diameter
        super(diameter,diameter);

    }

    /**
     * Get the name of the shape type. This is a
     * method that "replaces" the inherited one.
     * The term for this is "override".
     */
    public String getName()
    {
        return "circle";
    }
}
