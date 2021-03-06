import java.awt.Color;

/**
 * This class draws a tree. The location and color
 * of the leaves can be customized.
 *
 * @author Nathan Flint
 * @version Assignment 4: MyScene
 *
 * Grading Level: Challenge
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
     * The is one of the constructors. It creates a MyTree object with
     * the defined location and leaf color.
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

        // Creates the bottom bottom most leaves in the
        // shape of a triangle.
        bottomLeaves = new NsccUpTriangle(0,60,40,60);
        bottomLeaves.setBackground(leafColor);
        bottomLeaves.setFilled(true);
        add(bottomLeaves);

        // Creates the middle set of leaves in the
        // shape of a triangle.
        middleLeaves = new NsccUpTriangle(0,20,40,60);
        middleLeaves.setBackground(leafColor);
        middleLeaves.setFilled(true);
        add(middleLeaves);

        // Creates the top set of leaves in the
        // shape of a triangle.
        topLeaves = new NsccUpTriangle(0,0,40,40);
        topLeaves.setBackground(leafColor);
        topLeaves.setFilled(true);
        add(topLeaves);
    }

    /**
     * Another constructor for MyTree.
     * Creates a tree at the defined location
     * with a default leaf color of dark green.
     *
     * @param x x-coordinate of the upper left corner of the tree
     * @param y y-coordinate of the upper left corner of the tree
     */
    public MyTree(int x, int y)
    {
        // Call constructor overload
        this(x, y, new Color(0,128,0));
    }

    /**
     * Sets the color of the leaves of the tree
     *
     * @param leafColor The color of the leaves
     */
    public void setColor(Color leafColor)
    {
        bottomLeaves.setBackground(leafColor);
        middleLeaves.setBackground(leafColor);
        topLeaves.setBackground(leafColor);
    }

    /**
     * Alters the size the tree, to scale.
     *
     * @param width new width of the tree
     * @param height new height of the tree
     */
    public void setSize(int width, int height)
    {
        // Must call the super class set size method to change the bounding box.
        super.setSize(width, height);

        // Change trunk location and size to scale with new tree size
        trunk.setLocation(width * 13 / 40, height * 11 / 16);
        trunk.setSize(width * 7 / 20, height * 5 / 16);

        // change bottom leaves location and size to scale with new tree size
        bottomLeaves.setLocation(0, height * 3 / 8);
        bottomLeaves.setSize(width, height * 3 / 8);

        // change middle leaves location and size to scale with new tree size
        middleLeaves.setLocation(0, height / 8);
        middleLeaves.setSize(width, height * 3 / 8);

        // change top leaves location and size to scale with new tree size
        topLeaves.setLocation(0, 0);
        topLeaves.setSize(width, height / 4);
    }
}
