/**
 * This class represents a triangle and
 * inherits from MyShape.
 *
 * @author Nathan Flint
 * @version Assignment 5: Shape Hierarchy
 *
 * Grading level: Challenge
 */
public class MyTriangle extends MyShape {

    /**
     * Constructor for MyTriangle.
     *
     * @param base
     * @param height
     */
    public MyTriangle(int base, int height)
    {
        // Call the MyShape constructor
        super(base,height);
    }

    /**
     * Get the name of the shape type. This is a
     * method that "replaces" the inherited one.
     * The term for this is "override".
     */
    public String getName() {
        return "triangle";
    }

    /**
     * Overrides method from MyShape. Calculates
     * the area of a triangle.
     *
     * @return area of the triangle
     */
    public double getArea()
    {
        // Calculates the area of the triangle: 1/2 * base * height
        return .5 * width * height;
    }

    /**
     * Overrides method from MyShape.
     * Calculates the perimeter of a triangle.
     *
     * @return perimeter of the triangle
     */
    public double getPerimeter()
    {
        // calculates the area of a right triangle: width + height + hypotenuse
        return width + height + Math.sqrt(width * width + height * height);
    }
}
