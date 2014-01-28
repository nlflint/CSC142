// Allow short name access to java.awt.Color
import java.awt.Color;

/**
 * This is the shell for programming assignment 3.
 * This program draws a simple scene using additional
 * classes that the student creates.
 *
 * @author Dan Jinguji 
 * @version Assignment 4: MyScene
 */
public class MyScene extends NsccWindow {

    // instance variables
    private MyHouse house;

    /**
     * Constructor for objects of class MyScene
     */
    public MyScene() {
        // Specify the constructor for the superclass
        super(10, 10, 400, 300);
        // set characteristics for the object
        setTitle("My Scene");

        // Draw the sky
        getContentPane().setBackground(new Color(0x00, 0xCC, 0xFF));

        // Draw some grass
        NsccRectangle grass = new NsccRectangle(0, 100, 400, 200);
        grass.setBackground(new Color(0x00, 0x99, 0x00));
        grass.setFilled(true);
        add(grass);

        // Draw a house
        house = new MyHouse(100, 50);
        add(house);
    }

    /**
     * Alter the scene, by changing color
     */
    public void change1() {
        // change the color of the house
        house.setColor(Color.red);
        // request a rerendering of the window
        repaint();
    }

    /**
     * Alter the scene, by changing location
     */
    public void change2() {
        // change the location of the house
        house.setLocation(50, 125);
        // request a rerendering of the window
        repaint();
    }

    /**
     * Alter the scene, by changing size
     */
    public void change3() {
        // change the size of the house
        house.setSize(80, 60);
        // request a rerendering of the window
        repaint();
    }

    /**
     * Alter the scene, restoring original settings
     */
    public void reset() {
        // reset the initial values for the house
        house.setLocation(100, 50);
        house.setColor(Color.blue);
        house.setSize(120, 90);
        // request a rerendering of the window
        repaint();
    }

    /**
     * The application method, to test your code
     *
     * @param args The command-line arguments
     */
    public static void main(String[] args) {

        // declare a MyScene reference
        MyScene aScene;
        // instantiate MyScene
        aScene = new MyScene();
        // pause
        javax.swing.JOptionPane.showMessageDialog(null, "Press OK to continue");

        // test setColor
        aScene.change1();
        javax.swing.JOptionPane.showMessageDialog(null, "Press OK to continue");

        // test setLocation
        aScene.change2();
        javax.swing.JOptionPane.showMessageDialog(null, "Press OK to continue");

        // test setSize
        aScene.change3();
        javax.swing.JOptionPane.showMessageDialog(null, "Press OK to continue");

        // reset initial values
        aScene.reset();
    }

}