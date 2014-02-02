import java.awt.Color;

/**
 * Created by nate on 2/1/14.
 */
public class MyTree extends NsccComponent
{
    // The trunk of the tree
    private NsccRectangle trunk;

    // The bottom set of leaves
    private NsccUpTriangle bottomLeaves;

    // The middle set of leaves
    private NsccUpTriangle middleLeaves;

    // The top set of leaves
    private NsccUpTriangle topLeaves;

    /**
     * Creates a tree at the defined location with leaves of the specified color
     *
     * @param x x-coordinate of the upper left corner of the tree
     * @param y y-coordinate of the upper left corner of the tree
     * @param leafColor color of the leaves
     */
    public MyTree(int x, int y, Color leafColor)
    {
        // Calls the base construct and defines the overall size and location of the tree.
        super(x,y,40,160);

        //Creates a brown tree trunk
        trunk = new NsccRectangle(13,110,14,50);
        trunk.setBackground(new Color(128,0,0));
        trunk.setFilled(true);
        add(trunk);

        bottomLeaves = new NsccUpTriangle(0,60,40,60);
        bottomLeaves.setBackground(leafColor);
        bottomLeaves.setFilled(true);
        add(bottomLeaves);

        middleLeaves = new NsccUpTriangle(0,20,40,60);
        middleLeaves.setBackground(leafColor);
        middleLeaves.setFilled(true);
        add(middleLeaves);

        topLeaves = new NsccUpTriangle(0,0,40,40);
        topLeaves.setBackground(leafColor);
        topLeaves.setFilled(true);
        add(topLeaves);
    }

    public MyTree(int x, int y)
    {
        this(x, y, new Color(0,128,0));
    }

    public void setColor(Color leafColor)
    {
        bottomLeaves.setBackground(leafColor);
        middleLeaves.setBackground(leafColor);
        topLeaves.setBackground(leafColor);
    }
}
