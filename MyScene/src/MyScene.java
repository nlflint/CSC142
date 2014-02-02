// Allow short name access to java.awt.Color
import java.awt.Color;

/**
 * This is the shell for programming assignment 3.
 * This program draws a simple scene using additional
 * classes that the student creates.
 *
 * @author Dan Jinguji
 * @author Nathan Flint
 * @version Assignment 4: MyScene
 */
public class MyScene extends NsccWindow {

    // instance variables
    private MyHouse firstHouse;
    private MyHouse secondHouse;
    private MyHouse thirdHouse;
    private MyTree firstTree;
    private MyTree secondTree;
    private MyTree thirdTree;

    /**
     * Constructor for objects of class MyScene
     */
    public MyScene() {
        // Specify the constructor for the superclass
        super(10, 10, 400, 300);

        // set characteristics for the object
        setTitle("My Scene");

        configureInitialScene();
        repaint();

    }

    /**
     * Alter the scene, by changing color
     */
    public void change1() {
        // change the color of the firstHouse
        firstHouse.setColor(Color.RED);

        // change the color the second house
        secondHouse.setColor(Color.ORANGE);

        // change the color of the third house
        thirdHouse.setColor(Color.WHITE);

        // change the color of the first tree
        firstTree.setColor(new Color(217, 152, 13));

        //change the color of the second tree
        secondTree.setColor(new Color(200, 73,0));

        // change the color of the third tree
        thirdTree.setColor(new Color(180,180,0));

        // request a rerendering of the window
        repaint();
    }

    /**
     * Alter the scene, by changing location
     */
    public void change2() {

        // change the location of the firstHouse
        firstHouse.setLocation(200, 50);

        // change the location the second house
        secondHouse.setLocation(50, 70);

        // change the location of the third house
        thirdHouse.setLocation(100, 150);

        // change the location of the first tree
        firstTree.setLocation(40, 60);

        //change the location of the second tree
        secondTree.setLocation(300, 50);

        // change the location of the third tree
        thirdTree.setLocation(200, 100);

        // request a rerendering of the window
        repaint();
    }

    /**
     * Alter the scene, by changing size
     */
    public void change3() {

        // change the size of the firstHouse
        firstHouse.setSize(150, 150);

        // change the size the second house
        secondHouse.setSize(50, 100);

        // change the size of the third house
        thirdHouse.setSize(200, 60);


        // request a rerendering of the window
        repaint();
    }

    /**
     * Alter the scene, restoring original settings
     */
    public void reset() {
        configureInitialScene();
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

    // Removes any existing houses and trees, and creates new ones
    // for the scene's initial configuration
    private void configureInitialScene()
    {
        // remove any existing components (e.g. grass, trees and houses).
        getContentPane().removeAll();

        // Draw the sky
        getContentPane().setBackground(new Color(0x00, 0xCC, 0xFF));

        // Draw some grass
        NsccRectangle grass = new NsccRectangle(0, 100, 400, 200);
        grass.setBackground(new Color(0x00, 0x99, 0x00));
        grass.setFilled(true);
        add(grass);

        // Draw the firstHouse
        firstHouse = new MyHouse(100, 50);
        add(firstHouse);

        // Draw the second house
        secondHouse = new MyHouse(50, 150, Color.BLACK);
        add(secondHouse);

        // Draw the third house
        thirdHouse = new MyHouse(225, 110, Color.YELLOW);
        add(thirdHouse);

        // Draw the first tree
        firstTree = new MyTree(200, 50);
        add(firstTree);

        // Draw the second tree
        secondTree = new MyTree(150, 110, new Color(100,140,0));
        add(secondTree);

        // Draw the third tree
        thirdTree = new MyTree(300, 100, new Color(0,80,0));
        add(thirdTree);
    }

}