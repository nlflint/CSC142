import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: nate
 * Date: 1/13/14
 * Time: 9:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Flags
{
    public void drawNigerFlag()
    {


        // The scale factor will scale the size of the flag while keeping
        // it in proportion.
        int scaleFactor = 30;
        int flagLeftBoundary = 10;
        int flagTopBoundary = 10;

        NsccWindow mainWindow = new NsccWindow(100,100,25 + (29 * scaleFactor),50 + (25 * scaleFactor));

        int flagHoist = 24 * scaleFactor;
        int flagFly = 28 * scaleFactor;
        NsccRectangle baseLayer = new NsccRectangle(flagLeftBoundary,flagTopBoundary,flagFly,flagHoist);
        baseLayer.setBackground(Color.ORANGE);
        baseLayer.setFilled(true);
        mainWindow.add(baseLayer);

                int middleStripeY = flagTopBoundary + (8 * scaleFactor);
        int middleStripHeight = 8 * scaleFactor + 1;
        NsccRectangle middleStripe = new NsccRectangle(flagLeftBoundary,middleStripeY,flagFly,middleStripHeight);
        middleStripe.setBackground(Color.WHITE);
        middleStripe.setFilled(true);
        mainWindow.add(middleStripe);

        int bottomStripeY = flagTopBoundary + (16 * scaleFactor);
        int bottomStripHeight = 8 * scaleFactor;
        NsccRectangle bottomStripe = new NsccRectangle(flagLeftBoundary,bottomStripeY,flagFly,bottomStripHeight);
        bottomStripe.setBackground(Color.GREEN);
        bottomStripe.setFilled(true);
        mainWindow.add(bottomStripe);

        int middleCircleX = flagLeftBoundary + (11 * scaleFactor);
        int middleCircleY = flagTopBoundary + (9 * scaleFactor);
        int diameter = 6 * scaleFactor;
        NsccEllipse middleCircle = new NsccEllipse(middleCircleX, middleCircleY,diameter,diameter);
        middleCircle.setBackground(Color.ORANGE);
        middleCircle.setFilled(true);
        mainWindow.add(middleCircle);

        mainWindow.repaint();
    }

    public void drawSwedishFlag()
    {

    }
}