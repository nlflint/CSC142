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
        background.setBackground(Color.LIGHT_GRAY);
        background.setForeground(Color.LIGHT_GRAY);
        mainWindow.add(background);

        NsccEllipse stopSignal = new NsccEllipse(30,30,70,70);
        stopSignal.setFilled(true);
        stopSignal.setBackground(Color.RED);
        stopSignal.setForeground(Color.RED);
        mainWindow.add(stopSignal);

        NsccEllipse warningSignal = new NsccEllipse(30,110,70,70);
        warningSignal.setFilled(true);
        warningSignal.setBackground(Color.YELLOW);
        warningSignal.setForeground(Color.YELLOW);
        mainWindow.add(warningSignal);


        NsccEllipse goSignal = new NsccEllipse(30,190,70,70);
        goSignal.setFilled(true);
        Color darkGreen = new Color(0,128,0);
        goSignal.setBackground(darkGreen);
        goSignal.setForeground(darkGreen);
        mainWindow.add(goSignal);

        mainWindow.repaint();
    }

}