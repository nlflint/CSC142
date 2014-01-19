import java.awt.*;

/**
 * This class contains methods that draw several flags within
 * a created window.
 *
 * @author Nathan Flint
 * @version Assignment 2: Flags
 *
 */
public class Flags
{
    /**
     * This the the application method. It will call the the
     * draw method for each flag.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args)
    {
        // Instantiate the flags class
        Flags flags = new Flags();

        // Draw each flag
        flags.drawNigerFlag();
        flags.drawSwedishFlag();
        flags.drawNorwayFlag();
        flags.drawSeychellesFlag();
        flags.drawAlabamaFlag();
    }

    /**
     * Draws the flag of Niger. This will create a window
     * and then draw the flag if Niger within the window.
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

        // Creates a dark orange base layer that is the full dimension of the flag.
        // This will also be the top stripe.
        NsccRectangle baseLayer = new NsccRectangle(40,40,308,264);
        baseLayer.setBackground(darkOrange);
        baseLayer.setFilled(true);
        mainWindow.add(baseLayer);

        // Creates a white stripe across the middle of the flag
        // and adds it to the base layer.
        NsccRectangle middleStripe = new NsccRectangle(0,88,308,89);
        middleStripe.setBackground(Color.WHITE);
        middleStripe.setFilled(true);
        baseLayer.add(middleStripe);

        // Creates a green strip at the bottom of the flag
        // and adds it to the base layer.
        NsccRectangle bottomStripe = new NsccRectangle(0,176,308,88);
        bottomStripe.setBackground(darkGreen);
        bottomStripe.setFilled(true);
        baseLayer.add(bottomStripe);

        // Creates the circle in the middle of the flag
        // and adds it to the base layer.
        NsccEllipse middleCircle = new NsccEllipse(121,11,66,66);
        middleCircle.setBackground(darkOrange);
        middleCircle.setFilled(true);
        middleStripe.add(middleCircle);

        // Draw everything.
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
     *    rectangles on the right:
     *       dimensions: 270x120
     *       locations: 150+60 = 210, 120+60 = 180: (210,0), (210, 180)
     */
    public void drawSwedishFlag()
    {
        // Create main window
        NsccWindow mainWindow = new NsccWindow(550,100,600,400);

        // Creates the base layer of the flag
        NsccRectangle baseLayer = new NsccRectangle(40,40,480,300);
        baseLayer.setBackground(Color.YELLOW);
        baseLayer.setFilled(true);
        mainWindow.add(baseLayer);

        // Creates the upper left corner square
        // and adds it to the base layer.
        NsccRectangle upperLeftSquare = new NsccRectangle(0,0,150,120);
        upperLeftSquare.setBackground(Color.BLUE);
        upperLeftSquare.setFilled(true);
        baseLayer.add(upperLeftSquare);

        // Creates the lower left corner square
        // and adds it to the base layer.
        NsccRectangle lowerLeftSquare = new NsccRectangle(0,180,150,120);
        lowerLeftSquare.setBackground(Color.BLUE);
        lowerLeftSquare.setFilled(true);
        baseLayer.add(lowerLeftSquare);

        // Creates the upper right corner square
        // and adds it to the base layer.
        NsccRectangle upperRightSquare = new NsccRectangle(210,0,270,120);
        upperRightSquare.setBackground(Color.BLUE);
        upperRightSquare.setFilled(true);
        baseLayer.add(upperRightSquare);

        // Creates the lower right corner square
        // and adds it to the base layer.
        NsccRectangle lowerRightSquare = new NsccRectangle(210,180,270,120);
        lowerRightSquare.setBackground(Color.BLUE);
        lowerRightSquare.setFilled(true);
        baseLayer.add(lowerRightSquare);

        // Draw everything.
        mainWindow.repaint();
    }

    /**
     * Draws the Norwegian flag.
     *
     * Calculations:
     *    fly:hoist::22:16::352:256
     *    red:white:blue:white:red::6:1:2:1:6::96:16:32:16:96  along hoist
     *    red:white:blue:white:red::6:1:2:1:12::96:16:32:16:192 along fly
     *    overall flag:
     *       dimension: 352x256
     *       location: (40, 40)
     *    white squares:
     *       side: 96+16 = 112
     *       locations: (0,0), (0, 144)
     *    white rectangles:
     *       dimensions: 192+16 = 208, 96 + 16 = 112: 208x112
     *       locations: 96+16+32 = 114: (144,0), (144, 144)
     *    red squares:
     *       side: 96
     *       locations: (0,0), (0, 160)
     *    red rectangles:
     *       dimensions:  192x96
     *       locations: 96+16+32+16 = 160, (160,0), (160, 160)
     */
    public void drawNorwayFlag()
    {
        // Create main window
        NsccWindow mainWindow = new NsccWindow(100,500,450,350);

        // Create base layer
        NsccRectangle baseLayer = new NsccRectangle(40,40,352,256);
        baseLayer.setBackground(Color.BLUE);
        baseLayer.setFilled(true);
        mainWindow.add(baseLayer);

        // Create upper left white square and add to base layer
        NsccRectangle upperLeftWhiteSquare = new NsccRectangle(0,0,112,112);
        upperLeftWhiteSquare.setBackground(Color.WHITE);
        upperLeftWhiteSquare.setFilled(true);
        baseLayer.add(upperLeftWhiteSquare);

        // Create upper left red square and add to base layer
        NsccRectangle upperLeftRedSquare = new NsccRectangle(0,0,96,96);
        upperLeftRedSquare.setBackground(Color.RED);
        upperLeftRedSquare.setFilled(true);
        baseLayer.add(upperLeftRedSquare);

        // Create lower left white square and add to base layer
        NsccRectangle loweLeftWhiteSquare = new NsccRectangle(0,144,112,112);
        loweLeftWhiteSquare.setBackground(Color.WHITE);
        loweLeftWhiteSquare.setFilled(true);
        baseLayer.add(loweLeftWhiteSquare);

        // Create lower left red square and add to base layer
        NsccRectangle lowerLeftRedSquare = new NsccRectangle(0,160,96,96);
        lowerLeftRedSquare.setBackground(Color.RED);
        lowerLeftRedSquare.setFilled(true);
        baseLayer.add(lowerLeftRedSquare);

        // Create upper right white rectangle and add to base layer
        NsccRectangle upperRightWhiteRectangle = new NsccRectangle(144,0,208,112);
        upperRightWhiteRectangle.setBackground(Color.WHITE);
        upperRightWhiteRectangle.setFilled(true);
        baseLayer.add(upperRightWhiteRectangle);

        // Create upper right red rectangle and add to base layer
        NsccRectangle upperRightRedRectangle = new NsccRectangle(160,0,192,96);
        upperRightRedRectangle.setBackground(Color.RED);
        upperRightRedRectangle.setFilled(true);
        baseLayer.add(upperRightRedRectangle);

        // Create lower right white rectangle and add to base layer
        NsccRectangle lowerRightWhiteRectangle = new NsccRectangle(144,144,208,112);
        lowerRightWhiteRectangle.setBackground(Color.WHITE);
        lowerRightWhiteRectangle.setFilled(true);
        baseLayer.add(lowerRightWhiteRectangle);

        // Create lower right red rectangle and add to base layer
        NsccRectangle lowerRightRedRectangle = new NsccRectangle(160,160,192,96);
        lowerRightRedRectangle.setBackground(Color.RED);
        lowerRightRedRectangle.setFilled(true);
        baseLayer.add(lowerRightRedRectangle);

        // Draw everything.
        mainWindow.repaint();
    }

    /**
     * Draws the Seychelles flag.
     *
     * Calculations:
     *    fly:hoist::2:1::444:222
     *    red:white:green::1:1:1::74:74:74  along hoist
     *    blue:yellow:red::1:1:1::148:148:148 along fly
     *    overall flag:
     *       dimension: 444x222
     *       location: (40, 40)
     *    yellow down triangle:
     *       dimensions: 148*2 = 296, 296*2 = 592: 592x222
     *       location: 0 - 148*2 = -296: (-296,0)
     *    blue down triangle:
     *       dimensions: 148*2 = 296: 296x222
     *       location: 0-148 = -148: (-148,0)
     *    white up triangle:
     *       dimensions: 444*2 = 888, 74*2 = 148: 888x148
     *       location: 0+74 = 74: (0,74)
     *    green up triangle:
     *       dimensions: 444*2 = 888: 888x74
     *       location: 74*2 = 148: (0,148)
     *    empty boundary box:
     *       dimension: 444x222
     *       location: (40, 40)
     */
    public void drawSeychellesFlag()
    {
        // Create a window
        NsccWindow mainWindow = new NsccWindow(600,500,580,350);

        // Create a base layer that is the size of the flag
        NsccRectangle baseLayer = new NsccRectangle(50,50,444,222);
        baseLayer.setBackground(Color.RED);
        baseLayer.setFilled(true);
        mainWindow.add(baseLayer);

        // Create a the yellow down triangle and add it to the base layer
        NsccDownTriangle yellowBeam = new NsccDownTriangle(-296,0,592,222);
        yellowBeam.setBackground(Color.YELLOW);
        yellowBeam.setFilled(true);
        baseLayer.add(yellowBeam);

        // Create a the blue down triangle and add it to the base layer
        NsccDownTriangle blueBeam = new NsccDownTriangle(-148,0,296,222);
        blueBeam.setBackground(Color.BLUE);
        blueBeam.setFilled(true);
        baseLayer.add(blueBeam);

        // Create a the white up triangle and add it to the base layer
        NsccUpTriangle whiteBeam = new NsccUpTriangle(0,74,888,148);
        whiteBeam.setBackground(Color.WHITE);
        whiteBeam.setFilled(true);
        baseLayer.add(whiteBeam);

        // Create a the green up triangle and add it to the base layer
        Color darkGreen = new Color(0,128,0);
        NsccUpTriangle greenBeam = new NsccUpTriangle(0,148,888,74);
        greenBeam.setBackground(darkGreen);
        greenBeam.setFilled(true);
        baseLayer.add(greenBeam);

        // The baselayer's outline has been broken by the triangle
        // and this recreates it.
        NsccRectangle border = new NsccRectangle(50,50,444,222);
        border.setFilled(false);
        mainWindow.add(border);

        // Draw everything.
        mainWindow.repaint();
    }

    /**
     * Draws the Alabama flag.
     *
     * Calculations:
     *    fly:hoist::10:6::440:264
     *    red:white:red::1:9:1::24:216:24  along hoist
     *    red:white:red::1:9:1::40:360:40 along fly
     *    overall flag:
     *       dimension: 440x264
     *       location: (40, 40)
     *    down triangle:
     *       width: 9/11*440 = 360
     *       line coordinates: (40,0),(440,216+24) = (40,0),(440,240)
     *       line slope: (240-0)/(440-40) = ~0.6
     *       line intercept: 0 = 0.6(40) + b: b = -24
     *       line: y = 0.6x - 24
     *       x intercept: 440/2: 220
     *       height: y = 0.6(220) - 24: 108
     *       location: (40,0)
     *    up triangle:
     *       width: 9/11*440 = 360
     *       height: same as down triangle: 108
     *       location: (40,264-108): (40,156)
     *    left triangle:
     *       height: 264-24-24: 216
     *       line: same as down triangle: y = 0.6x - 24
     *       y intercept: 264/2: 132
     *       width: 132 = 0.6(x) - 24: x = 260: 440-260: 180
     *       location: 440-180 = 264: (264,24)
     *    right triangle:
     *       height: 264-24-24: 216
     *       width: same as left triangle: 180
     *       location: (0,24)
     */
    public void drawAlabamaFlag()
    {
        // Create window
        NsccWindow mainWindow = new NsccWindow(300,250,550,400);

        // Create the base layer that will be the size of the flag
        NsccRectangle baseLayer = new NsccRectangle(40,40,440,264);
        baseLayer.setBackground(Color.RED);
        baseLayer.setFilled(true);
        mainWindow.add(baseLayer);

        // Create the top triangle and add it to the base layer
        NsccDownTriangle topTriangle = new NsccDownTriangle(40,0,360,108);
        topTriangle.setBackground(Color.WHITE);
        topTriangle.setFilled(true);
        baseLayer.add(topTriangle);

        // Create the bottom triangle and add it to the base layer
        NsccUpTriangle bottomTriangle = new NsccUpTriangle(40,156,360,108);
        bottomTriangle.setBackground(Color.WHITE);
        bottomTriangle.setFilled(true);
        baseLayer.add(bottomTriangle);

        // Create the left triangle and add it to the base layer
        NsccRightTriangle leftTriangle = new NsccRightTriangle(0,24,180,216);
        leftTriangle.setBackground(Color.WHITE);
        leftTriangle.setFilled(true);
        baseLayer.add(leftTriangle);

        // Create the right triangle and add it to the base layer
        NsccLeftTriangle rightTriangle = new NsccLeftTriangle(260,24,180,216);
        rightTriangle.setBackground(Color.WHITE);
        rightTriangle.setFilled(true);
        baseLayer.add(rightTriangle);

        // Draw everything
        mainWindow.repaint();
    }
}