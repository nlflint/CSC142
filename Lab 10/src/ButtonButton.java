import javax.swing.*;
import java.awt.*;

/**
 * This class demos interfaces and click button events
 *
 * @author Nathan Flint
 * @version Lab 10
 *
 * Grading Level: Plus
 */
public class ButtonButton implements java.awt.event.ActionListener
{
    // The window
    private NsccWindow win;
    // An oval in the window
    private NsccEllipse oval;
    // Next button
    private JButton nextColorButton;

    /**
     * Constructor. It initializes the class.
     */
    public ButtonButton()
    {
        // Initialize a new window
        win = new NsccWindow();
        win.setTitle("ButtonButton");

        // Initialize the oval
        oval = new NsccEllipse(100, 70, 200, 150);
        oval.setFilled(true);
        oval.setBackground(java.awt.Color.blue);

        // Add the oval to the window
        win.add(oval);

        // Create and initialize the next color button
        nextColorButton = new javax.swing.JButton("Next Color");
        nextColorButton.setSize(150, 35);
        nextColorButton.setLocation(25, 10);
        nextColorButton.addActionListener(this);

        // Create and initialize the next color button
        JButton previousColorButton;
        previousColorButton = new javax.swing.JButton("Previous Color");
        previousColorButton.setSize(150, 35);
        previousColorButton.setLocation(200, 10);
        previousColorButton.addActionListener(this);

        // Add the buttons to the window
        win.add(nextColorButton);
        win.add(previousColorButton);

        // Paint the window to show the newly added items.
        win.repaint();
    }

    /**
     * Implements the method that will be called when button is clicked
     *
     * @param e Action info created by the button event
     */
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // declare and get the button that was clicked
        JButton sourceButton = (JButton) e.getSource();

        // Determine which button was clicked and set next or previous color in sequence.
        if (sourceButton == nextColorButton)
            setNextOvalColor();
        else setPreviousOvalColor();

        // repaint so that color change takes effect.
        win.repaint();
    }

    // Sets next color. Sequence is red > green > blue > repeat.
    private void setNextOvalColor()
    {
        // Sets the next color based on current color.
        if (oval.getBackground() == Color.red)
        {
            oval.setBackground(Color.green);
        }
        else if (oval.getBackground() == Color.green)
        {
            oval.setBackground(Color.blue);
        }
        else if (oval.getBackground() == Color.blue)
        {
            oval.setBackground(Color.red);
        }
    }

    // Sets next color in reverse order. Reverse sequence is red > blue > green > repeat.
    private void setPreviousOvalColor()
    {
        // sets next color based on current color.
        if (oval.getBackground() == Color.red)
        {
            oval.setBackground(Color.blue);
        }
        else if (oval.getBackground() == Color.blue)
        {
            oval.setBackground(Color.green);
        }
        else if (oval.getBackground() == Color.green)
        {
            oval.setBackground(Color.red);
        }
    }

    /**
     * Application method.
     * @param args Command line arguments
     */
    public static void main(String[] args)
    {
        // Start the program
        new ButtonButton();
    }
}
