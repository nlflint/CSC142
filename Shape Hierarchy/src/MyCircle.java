/**
 * Represents a circle.
 *
 * @author Nathan Flint
 * @version Assignment 5: Shape Hierarchy
 */
public class MyCircle extends MyEllipse
{
    public MyCircle(int diameter)
    {
        // Calls the MyEllipse constructor, using same width and
        // height as the diameter
        super(diameter,diameter);

    }
}
