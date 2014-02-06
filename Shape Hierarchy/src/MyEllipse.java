/**
 * Represents an ellipse.
 *
 * @author Nathan Flint
 * @version Assignment 5: Shape Hierarchy
 *
 * Grading Level: Challenge
 */
public class MyEllipse extends MyShape
{
    /**
     * Constructor for MyEllipse
     *
     * @param height height of the bounding box of the ellipse
     * @param width width of the bounding box of the ellipse
     */
    public MyEllipse(int height, int width)
    {
        //Calls the super class constructor
        super(width, height);

    }

    /**
     * Overrides the getArea method of MyShape.
     * Implements getting the area of an ellipse.
     *
     * @return the area of the ellipse
     */
    public double getArea()
    {
        return 0.25 * Math.PI * width * height;
    }
}
