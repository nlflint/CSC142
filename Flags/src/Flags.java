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

        int baseUnitOfMeasure = 22;
        int doubleBaseUnitOfMeasure = baseUnitOfMeasure * 2;
        int flagLeftBoundary = 30;
        int flagTopBoundary = 30;

        int flagHoist = 6 * doubleBaseUnitOfMeasure;
        int flagFly = 7 * doubleBaseUnitOfMeasure;
        NsccRectangle baseLayer = new NsccRectangle(flagLeftBoundary,flagTopBoundary,flagFly,flagHoist);
        baseLayer.setBackground(Color.ORANGE);
        baseLayer.setFilled(true);
        mainWindow.add(baseLayer);

        int middleStripeX = flagLeftBoundary;
        int middleStripeY = flagTopBoundary + (2 * doubleBaseUnitOfMeasure);
        int middleStripHeight = 2 * doubleBaseUnitOfMeasure + 1;
        NsccRectangle middleStripe = new NsccRectangle(middleStripeX,middleStripeY,flagFly,middleStripHeight);
        middleStripe.setBackground(Color.WHITE);
        middleStripe.setFilled(true);
        mainWindow.add(middleStripe);

        int bottomStripeX = flagLeftBoundary;
        int bottomStripeY = flagTopBoundary + (4 * doubleBaseUnitOfMeasure);
        int bottomStripHeight = 2 * doubleBaseUnitOfMeasure;
        NsccRectangle bottomStripe = new NsccRectangle(bottomStripeX,bottomStripeY,flagFly,bottomStripHeight);
        bottomStripe.setBackground(Color.GREEN);
        bottomStripe.setFilled(true);
        mainWindow.add(bottomStripe);

        int verticalBorderWidthOfMiddleStripe = 2;
        int middleCircleX = 7 * baseUnitOfMeasure;
        int middleCircleY = 6 * baseUnitOfMeasure - verticalBorderWidthOfMiddleStripe;
        int circileWidth = 3 * baseUnitOfMeasure;
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