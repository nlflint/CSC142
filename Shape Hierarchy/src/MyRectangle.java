/**
 * This class represents a simply plane geometry rectangle.
 * It is one of the example classes in the Inheritance
 * discussion.
 * 
 * @author Dan Jinguji
 * @version 0.2
 */
public class MyRectangle extends MyShape {

  /**
   * MyRectangle constructor
   * 
   * @param h The height of the rectangle
   * @param w The width of the rectangle
   */
  public MyRectangle(int h, int w) {
    super(h, w);
    // there is nothing else to do in this constructor
  }
  
  /**
   * An override. This replaces the getArea method inherited
   * from MyShape. This is a "real" implementation.
   * 
   * @return The area of the rectangle
   */
  public double getArea() {
    // calculate the area
    return height * width;
  }
  
  /**
   * Override for the getName method.
   * @return The type for the shape
   */
  public String getName() {
    return "rectangle";
  }
  
}
