/**
 * This class represents a right-triangle.
 *
 * @author Nathan Flint
 * @version Assignment 5: Shape Hierarchy
 *
 * Grading level: Challenge
 */
public class MyRightTriangle extends MyTriangle
{
    /**
     * Constructor. Sets the bounding box of the right triangle.
     *
     * @param height height of the bounding box around the right triangle.
     * @param base width of the bounding box around the right triangle.
     */
    public MyRightTriangle(int height, int base)
    {
        // Call the MyTriangle constructor.
        super(height, base);

    }

    /**
     * Get the name of the shape type. This is a
     * method that "replaces" the inherited one.
     * The term for this is "override".
     */
    public String getName()
    {
        return "right triangle";
    }

    /**
     * This class inherits getArea from MyTriangle. The calculation is the same
     * so it is reused.
     */

    /**
     * Overrides method from MyShape.
     * Calculates the perimeter of a riht triangle.
     *
     * @return perimeter of the right triangle
     */
    public double getPerimeter()
    {
        // Square width and height for pythagorean theorem.
        double widthSquared = width * width;
        double heightSquared = height * height;

        // use pythagorean theorem to find hypotenuse
        double hypotenuse = Math.sqrt(widthSquared + heightSquared);

        // returns the perimeter
        return width + height + hypotenuse;
    }
}
