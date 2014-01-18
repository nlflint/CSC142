import java.awt.*;

/**
 * This class contains methods that draw a flag within
 * a created window.
 *
 * @author Nathan Flint
 * @version Assignment 2: Flags
 *
 */
public class Flags
{
    public static void main(String[] args)
    {
        Flags flags = new Flags();
        flags.drawNigerFlag();
        flags.drawSwedishFlag();
        flags.drawNorwayFlag();
        flags.drawSeychellesFlag();
        flags.drawAlabamaFlag();
    }

    /**
     * Creates a window. Then draws the flag of Niger
     * within the window.
     *
     * Calculations:
     *    fly:hoist::7:6::308:264
     *    orange:white:green::1:1:1::88:88:88  along hoist
     *    middle circle::75%::66
     *    overall flag:
     *       dimension: 308x264
     *       location: (40, 40)
     *    horizontal bars:
     *       dimensions: 308x88
     *       middle bar: height stretched down 1 pixel so border overlaps with bottom bar
     *       locations: (0,0), (0, 88), (0, 176)
     *          3 * 88 = 264
     *    circle:
     *       dimensions: 66x66
     *       x position: (308/2) - 33 = 121
     *       y position: (88/2) - 33 = 11 (placed inside middle stripe)
     */
    public void drawNigerFlag()
    {
        // Creates a window
        NsccWindow mainWindow = new NsccWindow(100,100,400,364);

        // Create two custom colors
        Color darkOrange = new Color(255,127,0);
        Color darkGreen = new Color(0,204,0);

        // Draws a dark orange base layer that is the full dimension of the flag.
        NsccRectangle baseLayer = new NsccRectangle(40,40,308,264);
        baseLayer.setBackground(darkOrange);
        baseLayer.setFilled(true);
        mainWindow.add(baseLayer);

        // Draws a white stripe across the middle of the flag
        NsccRectangle middleStripe = new NsccRectangle(0,88,308,89);
        middleStripe.setBackground(Color.WHITE);
        middleStripe.setFilled(true);
        baseLayer.add(middleStripe);

        //Draws a green strip at the bottom of the flag.
        NsccRectangle bottomStripe = new NsccRectangle(0,176,308,88);
        bottomStripe.setBackground(darkGreen);
        bottomStripe.setFilled(true);
        baseLayer.add(bottomStripe);

        NsccEllipse middleCircle = new NsccEllipse(121,11,66,66);
        middleCircle.setBackground(darkOrange);
        middleCircle.setFilled(true);
        middleStripe.add(middleCircle);

        mainWindow.repaint();
    }

    /**
     * Draws the Swedish flag.
     *
     * Calculations:
     *    fly:hoist::8:5::480:300
     *    blue:yellow:blue::4:2:4::120:60:120  along hoist
     *    blue:yellow:blue::5:2:9::150:60:270 along fly
     *    overall flag:
     *       dimension: 480x300
     *       location: (40, 40)
     *    rectangles on the left:
     *       dimensions: 150x120
     *       locations: (0,0), (0, 120)
     *       gap between left rectangles: 60
     *    rectangles on the right:
     *       dimensions: 270x120
     *       locations: (210,0), (210, 180)
     *       gap between right rectangles: 60
     *    width total: 150 + 60 + 270 = 480
     *    height total: 180 + 180 + 60 = 300
     */
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