import java.awt.Color;

/**
 * This draws a traffic signal using procedural drawing routines.
 * The class depends on the classes within
 *
 * @author Nathan Flint
 * @Version Lab2: Traffic Light
 */
public class TrafficLight
{
    /**
     * This is the application method. It instantiates a new trafficLight class
     * and then calls the method to draw a traffic signal.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args)
    {
        TrafficLight tl = new TrafficLight();
        tl.drawTheLight();
    }

    /**
     * This method creates a window and then draws a traffic signal within the window.
     */
    public void drawTheLight()
    {
        NsccWindow mainWindow = new NsccWindow(10,10,140,330);
        mainWindow.setTitle("Traffic Light");

        NsccRectangle background = new NsccRectangle(20, 20, 90, 250);
        background.setFilled(true);
        background.setBackground(Color.lightGray);
        background.setForeground(Color.lightGray);
        mainWindow.add(background);

        NsccEllipse redLight = new NsccEllipse(30,30,70,70);
        redLight.setFilled(true);
        redLight.setBackground(Color.red);
        redLight.setForeground(Color.red);
        mainWindow.add(redLight);

        NsccEllipse yellowLight = new NsccEllipse(30,110,70,70);
        yellowLight.setFilled(true);
        yellowLight.setBackground(Color.yellow);
        yellowLight.setForeground(Color.yellow);
        mainWindow.add(yellowLight);

        Color darkGreen = new Color(0,128,0);
        NsccEllipse darkGreenLight = new NsccEllipse(30,190,70,70);
        darkGreenLight.setFilled(true);
        darkGreenLight.setBackground(darkGreen);
        darkGreenLight.setForeground(darkGreen);
        mainWindow.add(darkGreenLight);

        mainWindow.repaint();
    }

}