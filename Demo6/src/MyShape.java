public class MyShape {

    protected int height;
    protected int width;

    public MyShape(int h, int w) {
        height = h;
        width = w;
    }

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }

    public String getName() {
        return "shape";
    }

    public double getArea()
    {
        return 0;
    }

}