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
        NsccWindow mainWindow = new NsccWindow(100,100,400,364);

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
        NsccWindow mainWindow = new NsccWindow(550,100,600,400);

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
        NsccWindow mainWindow = new NsccWindow(100,500,450,350);

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

        NsccRectangle loweLeftWhiteSqure = new NsccRectangle(0,144,112,112);
        loweLeftWhiteSqure.setBackground(Color.WHITE);
        loweLeftWhiteSqure.setFilled(true);
        baseLayer.add(loweLeftWhiteSqure);

        NsccRectangle lowerLeftRedSquare = new NsccRectangle(0,160,96,96);
        lowerLeftRedSquare.setBackground(Color.RED);
        lowerLeftRedSquare.setFilled(true);
        baseLayer.add(lowerLeftRedSquare);

        NsccRectangle upperRightWhiteSquare = new NsccRectangle(144,0,208,112);
        upperRightWhiteSquare.setBackground(Color.WHITE);
        upperRightWhiteSquare.setFilled(true);
        baseLayer.add(upperRightWhiteSquare);

        NsccRectangle upperRightRedSquare = new NsccRectangle(160,0,192,96);
        upperRightRedSquare.setBackground(Color.RED);
        upperRightRedSquare.setFilled(true);
        baseLayer.add(upperRightRedSquare);

        NsccRectangle lowerRightWhiteSquare = new NsccRectangle(144,144,208,112);
        lowerRightWhiteSquare.setBackground(Color.WHITE);
        lowerRightWhiteSquare.setFilled(true);
        baseLayer.add(lowerRightWhiteSquare);

        NsccRectangle lowerRightRedSquare = new NsccRectangle(160,160,192,96);
        lowerRightRedSquare.setBackground(Color.RED);
        lowerRightRedSquare.setFilled(true);
        baseLayer.add(lowerRightRedSquare);

        mainWindow.repaint();
    }

    public void drawSeychellesFlag()
    {
        NsccWindow mainWindow = new NsccWindow(600,500,580,350);

        NsccRectangle baseLayer = new NsccRectangle(50,50,444,222);
        baseLayer.setBackground(Color.RED);
        baseLayer.setFilled(true);
        mainWindow.add(baseLayer);

        NsccDownTriangle yellowBeam = new NsccDownTriangle(-296,0,592,222);
        yellowBeam.setBackground(Color.YELLOW);
        yellowBeam.setFilled(true);
        baseLayer.add(yellowBeam);

        NsccDownTriangle blueBeam = new NsccDownTriangle(-148,0,296,222);
        blueBeam.setBackground(Color.BLUE);
        blueBeam.setFilled(true);
        baseLayer.add(blueBeam);

        NsccUpTriangle whiteBeam = new NsccUpTriangle(0,74,888,148);
        whiteBeam.setBackground(Color.WHITE);
        whiteBeam.setFilled(true);
        baseLayer.add(whiteBeam);

        Color darkGreen = new Color(0,128,0);
        NsccUpTriangle greenBeam = new NsccUpTriangle(0,148,888,74);
        greenBeam.setBackground(darkGreen);
        greenBeam.setFilled(true);
        baseLayer.add(greenBeam);

        NsccRectangle border = new NsccRectangle(50,50,444,222);
        border.setFilled(false);
        mainWindow.add(border);

        mainWindow.repaint();
    }

    public void drawAlabamaFlag()
    {
        NsccWindow mainWindow = new NsccWindow(300,250,550,400);

        NsccRectangle baseLayer = new NsccRectangle(50,50,450,270);
        baseLayer.setBackground(Color.RED);
        baseLayer.setFilled(true);
        mainWindow.add(baseLayer);

        NsccDownTriangle topTriangle = new NsccDownTriangle(45,0,360,108);
        topTriangle.setBackground(Color.WHITE);
        topTriangle.setFilled(true);
        baseLayer.add(topTriangle);

        NsccUpTriangle bottomTriangle = new NsccUpTriangle(45,162,360,108);
        bottomTriangle.setBackground(Color.WHITE);
        bottomTriangle.setFilled(true);
        baseLayer.add(bottomTriangle);

        NsccRightTriangle leftTriangle = new NsccRightTriangle(0,27,180,216);
        leftTriangle.setBackground(Color.WHITE);
        leftTriangle.setFilled(true);
        baseLayer.add(leftTriangle);

        NsccLeftTriangle rightTriangle = new NsccLeftTriangle(270,27,180,216);
        rightTriangle.setBackground(Color.WHITE);
        rightTriangle.setFilled(true);
        baseLayer.add(rightTriangle);

        mainWindow.repaint();
    }
}