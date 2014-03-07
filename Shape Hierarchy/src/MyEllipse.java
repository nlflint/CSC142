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
     * @param majorAxis height of the bounding box of the ellipse
     * @param minorAxis width of the bounding box of the ellipse
     */
    public MyEllipse(int majorAxis, int minorAxis)
    {
        //Calls the super class constructor
        super(minorAxis, majorAxis);

    }

    /**
     * Get the name of the shape type. This is a
     * method that "replaces" the inherited one.
     * The term for this is "override".
     */
    public String getName(){
        return "ellipse";
    }

    /**
     * Overrides the getArea method of MyShape.
     * Implements getting the area of an ellipse.
     *
     * @return the area of the ellipse
     */
    public double getArea()
    {
        // Calculates the area of the ellipse: 1/4 * pi * width * height
        return 0.25 * Math.PI * width * height;
    }

    /**
     * Overrides method from MyShape.
     * Calculates the perimeter of an ellipse.
     *
     * @return perimeter of the ellipse
     */
    public double getPerimeter()
    {
        // calculates the area of an ellipse: π/2 [ 3(a + b) − √(3a + b)(a + 3b) ]
        return (Math.PI/2) * ((3 * (width + height)) - Math.sqrt((3 * width + height) * (width + 3 * height)));
    }
}
