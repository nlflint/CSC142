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

        // Draw the sky
        getContentPane().setBackground(new Color(0x00, 0xCC, 0xFF));

        InitializeScene();

    }

    private void InitializeScene()
    {
        // reset the scene
        getContentPane().removeAll();

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

        // request a rerendering of the window
        repaint();
    }

    /**
     * Alter the scene, by changing size
     */
    public void change3() {

        // request a rerendering of the window
        repaint();
    }

    /**
     * Alter the scene, restoring original settings
     */
    public void reset() {
        InitializeScene();
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