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
        NsccWindow mainWindow = new NsccWindow(100,100,400,350);

        //This is the base unit of the whole flag. Changing it will scale the entire flag up or down.
        int baseUnitOfMeasure = 12;
        int flagLeftBoundary = 10;
        int flagTopBoundary = 10;

        int flagHoist = 24 * baseUnitOfMeasure;
        int flagFly = 28 * baseUnitOfMeasure;
        NsccRectangle baseLayer = new NsccRectangle(flagLeftBoundary,flagTopBoundary,flagFly,flagHoist);
        baseLayer.setBackground(Color.ORANGE);
        baseLayer.setFilled(true);
        mainWindow.add(baseLayer);

        int middleStripeX = flagLeftBoundary;
        int middleStripeY = flagTopBoundary + (8 * baseUnitOfMeasure);
        int middleStripHeight = 8 * baseUnitOfMeasure + 1;
        NsccRectangle middleStripe = new NsccRectangle(middleStripeX,middleStripeY,flagFly,middleStripHeight);
        middleStripe.setBackground(Color.WHITE);
        middleStripe.setFilled(true);
        mainWindow.add(middleStripe);

        int bottomStripeX = flagLeftBoundary;
        int bottomStripeY = flagTopBoundary + (16 * baseUnitOfMeasure);
        int bottomStripHeight = 8 * baseUnitOfMeasure;
        NsccRectangle bottomStripe = new NsccRectangle(bottomStripeX,bottomStripeY,flagFly,bottomStripHeight);
        bottomStripe.setBackground(Color.GREEN);
        bottomStripe.setFilled(true);
        mainWindow.add(bottomStripe);

        int middleCircleX = flagLeftBoundary + (11 * baseUnitOfMeasure);
        int middleCircleY = flagTopBoundary + (9 * baseUnitOfMeasure);
        int circileWidth = 6 * baseUnitOfMeasure;
        NsccEllipse middleCircle = new NsccEllipse(middleCircleX, middleCircleY,circileWidth,circileWidth);
        middleCircle.setBackground(Color.ORANGE);
        middleCircle.setFilled(true);
        mainWindow.add(middleCircle);

        mainWindow.repaint();
    }

    public void drawSwedishFlag()
    {

    }
}