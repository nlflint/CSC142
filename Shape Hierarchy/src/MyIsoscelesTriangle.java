/**
 * This class represents an isosceles triangle.
 *
 * @author Nathan Flint
 * @version Assignment 5: Shape Hierarchy
 *
 * Grading level: Challenge
 */
public class MyIsoscelesTriangle extends MyTriangle
{
    /**
     * Constructor. A bounding box is used to describe the isosceles
     * triangle. The mid point of the top of the box is the pointed
     * top of the triangle. The lower left and right corners of the
     * box are the other two points on the triangle.
     *
     * @param height height of the bounding box
     * @param base width of the bounding box
     */
    public MyIsoscelesTriangle(int height, int base)
    {
        // Calls the MyTriangle constructor
        super(height, base);
    }

    /**
     * Calculates and returns the perimeter of the isosceles.
     *
     * @returns the perimeter of the isosceles triangle.
     */
    public double getPerimeter()
    {
        // Set up data for pythagorean theorem
        double halfWidth = width / 2;
        double halfWidthSquared = halfWidth * halfWidth;
        double heightSquared = height * height;

        // Given an isosceles triangle is two right triangles.
        // Then reverse the pythagorean theorem to get triangle sides.
        double hypotenuseSide = Math.sqrt(halfWidthSquared + heightSquared);

        // bottomSide + leftSide + rightSide = perimeter.
        // Since left and right hypotenuse-like sides that are the same:
        // bottomSide + hypoSide + hypoSide = perimeter.
        return width + (hypotenuseSide * 2);
    }

    /**
     * Get the name of the shape type. This is a
     * method that "replaces" the inherited one.
     * The term for this is "override".
     */
    public String getName()
    {
        return "isosceles triangle";
    }

    /**
     * This class inherits getArea from MyTriangle. The calculation is the same
     * so it is reused.
     */
}
