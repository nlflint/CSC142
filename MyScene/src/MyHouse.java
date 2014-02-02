import java.awt.Color;

/**
 * A new graphic component. This component is used in
 * the notes to highlight the process of designing a 
 * new object and then implementing it.
 *
 * @author Dan Jinguji
 * @author Nathan Flint
 * @version Assignment 4: MyScene
 */
public class MyHouse extends NsccComponent {

    // instance variables
    private NsccUpTriangle theRoof;
    private NsccRectangle theWalls;
    private NsccRectangle theDoor;

    /**
     * Constructor for objects of class MyHouse.
     * This creates a MyHouse object at the specified
     * location
     * @param x the x-coordinate for the object
     * @param y the y-coordinate for the object
     */
    public MyHouse(int x, int y)
    {
        this(x,y,Color.BLUE);
    }

    /**
     * Constructor for objects of class MyHouse.
     * This creates a MyHouse object at the specified
     * location and with the specified wall color.
     *
     * @param x the x-coordinate for the object
     * @param y the y-coordinate for the object
     * @param wallColor color of the outer walls
     */
    public MyHouse(int x, int y, Color wallColor)
    {
        // Specify the constructor for the superclass
        super(x, y, 120, 90);

        // Create the roof object
        theRoof = new NsccUpTriangle(0, 0, 120, 40);
        // Set the characteristics of the roof
        theRoof.setFilled(true);
        theRoof.setBackground(new java.awt.Color(0x99, 0x33, 0x00));
        // Place the roof in the MyHouse object
        add(theRoof);

        // Create the walls object
        theWalls = new NsccRectangle(10, 40, 100, 50);
        // Set the characteristics of the walls
        theWalls.setFilled(true);
        theWalls.setBackground(wallColor);
        // Place the walls in the MyHouse object
        add(theWalls);

        // Create the door object
        theDoor = new NsccRectangle(48, 50, 24, 40);
        // Set the characteristics of the door
        theDoor.setFilled(true);
        theDoor.setBackground(new java.awt.Color(0x99, 0x66, 0x33));
        // Place the door in the MyHouse object
        add(theDoor);
    }

    /**
     * Change the color of the house
     *
     * @param c The color for the walls of the house
     */
    public void setColor(java.awt.Color c) {
        theWalls.setBackground(c);
        repaint();
    }

    /**
     * Retrieve the color of the house
     *
     * @return The color of the walls of the house
     */
    public java.awt.Color getColor() {
        return theWalls.getBackground();
    }

    /**
     * Alters the size the house, to scale.
     *
     * @param width new width of the house
     * @param height new height of the house
     */
    public void setSize(int width, int height)
    {
        super.setSize(width, height);

        // Change size to scale with house.
        // No change required for location.
        theRoof.setSize(width, height * 4 / 9);

        // Scale the size and location of the walls.
        theWalls.setSize(width * 5 / 6, height * 5 / 9);
        theWalls.setLocation(width / 12, height * 4 / 9);

        // Scale the size and location of the door.
        theDoor.setSize(width / 5, height * 4 / 9);
        theDoor.setLocation(width * 2 / 5, height * 5 / 9);
    }

}