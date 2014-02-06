/**
 * Created by nate on 2/6/14.
 */
public class Application {
    public static void main(String[] args)
    {
        MyShape firstRectangle = new MyRectangle(1,2);
        MyShape secondRectangle = new MySquare(45);

        firstRectangle.getArea();

    }
}
