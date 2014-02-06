public class MyRectangle extends MyShape
{
    public MyRectangle(int width, int height)
    {
        super(width, height);

    }

    public String getName()
    {
        return "rectangle";
    }

    public double getArea()
    {
        return width * height;
    }
}