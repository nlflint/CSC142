/**
 * This class represents a simply plane geometry square.
 * It is one of the example classes in the Inheritance
 * discussion.
 * 
 * @author Dan Jinguji
 * @author Nathan Flint
 * @version 0.2
 */
public class MySquare extends MyRectangle {
  
  public MySquare(int s) {
    super(s, s);
  }
  
  // no getArea ... why?
  // 1) squares do not have area
  // 2) it was inherited from the superclass
  // 3) you can figure it out for yourself
  
  /**
   * Get the name of the shape type. This is a 
   * method that "replaces" the inherited one.
   * The term for this is "override".
   */
  public String getName() {
    return "square";
  }

    /**
     * Overrides method from MyShape.
     * Calculates the perimeter of a square.
     *
     * @return perimeter of the square
     */
    public double getPerimeter()
    {
        // calculates the area of a square: side * 4
        return width * 4;
    }
}
