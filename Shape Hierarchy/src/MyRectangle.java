/**
 * This class represents a simply plane geometry rectangle.
 * It is one of the example classes in the Inheritance
 * discussion.
 * 
 * @author Dan Jinguji
 * @author Nathan Flint
 * @version 0.2
 *
 * Grading level: Challenge
 */
public class MyRectangle extends MyShape
{

  /**
   * MyRectangle constructor
   * 
   * @param h The height of the rectangle
   * @param w The width of the rectangle
   */
  public MyRectangle(int h, int w)
  {
    super(h, w);
    // there is nothing else to do in this constructor
  }
  
  /**
   * An override. This replaces the getArea method inherited
   * from MyShape. This is a "real" implementation.
   * 
   * @return The area of the rectangle
   */
  public double getArea()
  {
    // calculate the area
    return height * width;
  }
  
  /**
   * Override for the getName method.
   * @return The type for the shape
   */
  public String getName()
  {
    return "rectangle";
  }

    /**
     * Overrides method from MyShape.
     * Calculates the perimeter of a rectangle.
     *
     * @return perimeter of the rectangle
     */
    public double getPerimeter()
    {
        // calculates the area of a rectangle: width * 2 + height * 2
        return 2 * (width + height);
    }
  
}
