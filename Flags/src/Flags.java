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
        int scaleFactor = 11;
        int flagLeftBoundary = 40;
        int flagTopBoundary = 40;

        NsccWindow mainWindow = new NsccWindow(100,100,(flagLeftBoundary * 3) + (28 * scaleFactor),
                (flagTopBoundary * 3 ) + (24 * scaleFactor));

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
        // The scale factor will scale the size of the flag while keeping
        // it in proportion.
        int scaleFactor = 30;
        int flagLeftBoundary = 40;
        int flagTopBoundary = 40;

        NsccWindow mainWindow = new NsccWindow(100,100,(flagLeftBoundary * 3) + (16 * scaleFactor),
                (flagTopBoundary * 3 ) + (10 * scaleFactor));

        int flagHoist = 10 * scaleFactor;
        int flagFly = 16 * scaleFactor;
        NsccRectangle baseLayer = new NsccRectangle(flagLeftBoundary,flagTopBoundary,flagFly,flagHoist);
        baseLayer.setBackground(Color.YELLOW);
        baseLayer.setFilled(true);
        mainWindow.add(baseLayer);

        int upperLeftSquareHeight = 4 * scaleFactor;
        int upperLeftSquareWidth = 5 * scaleFactor;
        NsccRectangle upperLeftSquare = new NsccRectangle(flagLeftBoundary,flagTopBoundary
                ,upperLeftSquareWidth,upperLeftSquareHeight);
        upperLeftSquare.setBackground(Color.BLUE);
        upperLeftSquare.setFilled(true);
        mainWindow.add(upperLeftSquare);

        int lowerLeftSquareYPostition = flagTopBoundary + (6 * scaleFactor);
        NsccRectangle lowerLeftSquare = new NsccRectangle(flagLeftBoundary,lowerLeftSquareYPostition
                ,upperLeftSquareWidth,upperLeftSquareHeight);
        lowerLeftSquare.setBackground(Color.BLUE);
        lowerLeftSquare.setFilled(true);
        mainWindow.add(lowerLeftSquare);

        int upperRightSquareWidth = 9 * scaleFactor;
        int upperRightSquareXPosition = flagLeftBoundary + (7 * scaleFactor);
        NsccRectangle upperRightSquare = new NsccRectangle(upperRightSquareXPosition,flagTopBoundary
                ,upperRightSquareWidth,upperLeftSquareHeight);
        upperRightSquare.setBackground(Color.BLUE);
        upperRightSquare.setFilled(true);
        mainWindow.add(upperRightSquare);

        int lowerRightSquareYPosition = flagLeftBoundary + (6 * scaleFactor);
        NsccRectangle lowerRightSquare = new NsccRectangle(upperRightSquareXPosition,lowerRightSquareYPosition
                ,upperRightSquareWidth,upperLeftSquareHeight);
        lowerRightSquare.setBackground(Color.BLUE);
        lowerRightSquare.setFilled(true);
        mainWindow.add(lowerRightSquare);

        mainWindow.repaint();
    }
}