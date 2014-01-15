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

        Color nigerOrange = new Color(255,127,0);
        Color nigerGreen = new Color(0,204,0);

        NsccRectangle baseLayer = new NsccRectangle(40,40,308,264);
        baseLayer.setBackground(nigerOrange);
        baseLayer.setFilled(true);
        mainWindow.add(baseLayer);

        NsccRectangle middleStripe = new NsccRectangle(0,88,308,89);
        middleStripe.setBackground(Color.WHITE);
        middleStripe.setFilled(true);
        baseLayer.add(middleStripe);

        NsccRectangle bottomStripe = new NsccRectangle(0,176,308,88);
        bottomStripe.setBackground(nigerGreen);
        bottomStripe.setFilled(true);
        baseLayer.add(bottomStripe);

        NsccEllipse middleCircle = new NsccEllipse(121,11,66,66);
        middleCircle.setBackground(nigerOrange);
        middleCircle.setFilled(true);
        middleStripe.add(middleCircle);

        mainWindow.repaint();
    }



    public void drawSwedishFlag()
    {
        NsccWindow mainWindow = new NsccWindow(100,100,600,400);

        NsccRectangle baseLayer = new NsccRectangle(40,40,480,300);
        baseLayer.setBackground(Color.YELLOW);
        baseLayer.setFilled(true);
        mainWindow.add(baseLayer);

        NsccRectangle upperLeftSquare = new NsccRectangle(0,0,150,120);
        upperLeftSquare.setBackground(Color.BLUE);
        upperLeftSquare.setFilled(true);
        baseLayer.add(upperLeftSquare);

        NsccRectangle lowerLeftSquare = new NsccRectangle(0,180,150,120);
        lowerLeftSquare.setBackground(Color.BLUE);
        lowerLeftSquare.setFilled(true);
        baseLayer.add(lowerLeftSquare);

        NsccRectangle upperRightSquare = new NsccRectangle(210,0,270,120);
        upperRightSquare.setBackground(Color.BLUE);
        upperRightSquare.setFilled(true);
        baseLayer.add(upperRightSquare);

        NsccRectangle lowerRightSquare = new NsccRectangle(210,180,270,120);
        lowerRightSquare.setBackground(Color.BLUE);
        lowerRightSquare.setFilled(true);
        baseLayer.add(lowerRightSquare);

        mainWindow.repaint();
    }

    public void drawNorwayFlag()
    {
        NsccWindow mainWindow = new NsccWindow(100,100,450,350);

        NsccRectangle baseLayer = new NsccRectangle(40,40,352,256);
        baseLayer.setBackground(Color.BLUE);
        baseLayer.setFilled(true);
        mainWindow.add(baseLayer);

        NsccRectangle upperLeftWhiteSquare = new NsccRectangle(0,0,112,112);
        upperLeftWhiteSquare.setBackground(Color.WHITE);
        upperLeftWhiteSquare.setFilled(true);
        baseLayer.add(upperLeftWhiteSquare);

        NsccRectangle upperLeftRedSquare = new NsccRectangle(0,0,96,96);
        upperLeftRedSquare.setBackground(Color.RED);
        upperLeftRedSquare.setFilled(true);
        baseLayer.add(upperLeftRedSquare);

        NsccRectangle loweLeftWhiteSqure = new NsccRectangle(0,160,112,112);
        loweLeftWhiteSqure.setBackground(Color.WHITE);
        loweLeftWhiteSqure.setFilled(true);
        baseLayer.add(loweLeftWhiteSqure);

        NsccRectangle lowerLeftRedSquare = new NsccRectangle(0,176,96,96);
        lowerLeftRedSquare.setBackground(Color.RED);
        lowerLeftRedSquare.setFilled(true);
        baseLayer.add(lowerLeftRedSquare);

        mainWindow.repaint();
    }
}