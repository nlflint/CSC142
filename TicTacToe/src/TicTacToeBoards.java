import java.awt.*;

/**
 * This class draws several different tic tac toe boards to a window
 *
 * @author Nathan Flint
 * @version Assignment 3: Tic-Tac-Toe
 *
 * Grading Level: Challenge
 */
public class TicTacToeBoards
{
    /**
     * This is the main application method that
     * instantiates the class to draw tic tac toe boards.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args)
    {
        // Instantiate the class that creates a window and draws the tic tac toe boards.
        TicTacToeBoards board = new TicTacToeBoards();
    }

    // The window where all the tic-tac-toe boards will be drawn
    private NsccWindow mainWindow;

    /**
     * This constructor creates a NsccWindow and saves it to a private member for later use.
     * Then it calls four draw methods for tic tac toe boards.
     */
    public TicTacToeBoards()
    {
        // Creates a window
        mainWindow = new NsccWindow(10,10,300,330);

        // Draws a regular tic tac toe board
        drawTicTacToeBoard(40, 40);

        // Draws a board with line thickness
        drawTicTacToeBoard(40, 170, 6);

        // Draws a board colored red
        drawTicTacToeBoard(170, 40, Color.RED);

        // Draws a board rotated pi/8 radians
        drawTicTacToeBoard(170, 170, Math.PI/8);
    }

    /**
     * Draws a colored tic tac toe board. Arguments supplied will indicate the (x, y) coordinates
     * of the upper-left corner of the bounding box for the tic-tac-toe board, and the color of the lines.
     * This method uses defaults the rotation to zero radians.
     *
     * @param originX X component of the upper left corner of the board.
     * @param originY Y component of the upper left corner of the board.
     * @param lineColor Color of the line
     */
    public void drawTicTacToeBoard(int originX, int originY, Color lineColor)
    {
        // call private draw routine with zero rotation
        drawTicTacToeBoard(originX, originY, lineColor, 0);
    }

    /**
     * Draws a black tic tac toe board. Arguments supplied will indicate the (x, y) coordinates
     * of the upper-left corner of the bounding box for the tic-tac-toe board.
     *
     * @param originX X component of the upper left corner coordinates of the board.
     * @param originY Y component of the upper left corner coordinates of the board.
     */
    public void drawTicTacToeBoard(int originX, int originY)
    {
        // Calls the route that draws with color and sets color to black.
        drawTicTacToeBoard(originX,originY,Color.BLACK);
    }

    /**
     * Draws a tic tac toe board with variable line thickness. Arguments supplied will
     * indicate the (x, y) coordinates of the upper-left corner of the bounding box for the
     * tic-tac-toe board.
     *
     * @param originX X component of the upper left coordinates of the board.
     * @param originY Y component of the upper left coordinates of the board.
     * @param lineThickness Thickness of the lines
     */
    public void drawTicTacToeBoard(int originX, int originY, int lineThickness)
    {
        /*
         Defines side length of the boxes that make the tic tac toe board. There are 9
         of these boxes in a tic tac toe board. Changing this will alter the overall
         size of the entire board. Standard value is 30.
          */
        int boxUnitWidth = 30;

        // This offset is used to center the rectangles on the tic tac toe grid lines.
        int thicknessOffset = lineThickness / 2;

        // Draws the left vertical line of a board based on the given origin coordinates.
        NsccRectangle leftVerticleLine = new NsccRectangle(
                originX + boxUnitWidth - thicknessOffset,
                originY,
                lineThickness,
                boxUnitWidth * 3);
        leftVerticleLine.setFilled(true);
        leftVerticleLine.setBackground(Color.BLACK);
        mainWindow.add(leftVerticleLine);

        // Draws the right vertical line of a board based on the given origin coordinates.
        NsccRectangle rightVeritcleLine = new NsccRectangle(
                originX + boxUnitWidth * 2 - thicknessOffset,
                originY,
                lineThickness,
                boxUnitWidth * 3);
        rightVeritcleLine.setFilled(true);
        rightVeritcleLine.setBackground(Color.BLACK);
        mainWindow.add(rightVeritcleLine);

        // Draws the top  horizontal line of a board based on the given origin coordinates.
        NsccRectangle topHorizontalLine = new NsccRectangle(
                originX,
                originY + boxUnitWidth - thicknessOffset,
                boxUnitWidth * 3,
                lineThickness);
        topHorizontalLine.setFilled(true);
        topHorizontalLine.setBackground(Color.BLACK);
        mainWindow.add(topHorizontalLine);

        // Draws the top  horizontal line of a board based on the given origin coordinates.
        NsccRectangle bottomHorizontalLine = new NsccRectangle(
                originX,
                originY + boxUnitWidth * 2 - thicknessOffset,
                boxUnitWidth * 3,
                lineThickness);
        bottomHorizontalLine.setFilled(true);
        bottomHorizontalLine.setBackground(Color.BLACK);
        mainWindow.add(bottomHorizontalLine);

        // Signals the window to redraw itself so all the lines appear.
        mainWindow.repaint();

    }

    /**
     * Draws a black rotated tic tac toe board. Arguments supplied will indicate the (x, y) coordinates
     * of the upper-left corner of the bounding box for the tic-tac-toe board, and the rotation in radians around
     * the center of the board.
     *
     * @param originX X component of the upper left corner of the board.
     * @param originY Y component of the upper left corner of the board.
     * @param radiansRotation Radians to rotate the board.
     */
    public void drawTicTacToeBoard(int originX, int originY, double radiansRotation)
    {
        // Calls the private draw method and sets color to black.
        drawTicTacToeBoard(originX,originY, Color.BLACK, radiansRotation);
    }

    // This private method allows setting location, color and radians rotation at the same time.
    public void drawTicTacToeBoard(int originX, int originY, Color lineColor, double radiansRotation)
    {
        /*
         Defines side length of the boxes that make the tic tac toe board. There are 9
         of these boxes in a tic tac toe board. Changing this will alter the overall
         size of the entire board. Standard value is 30.
          */
        //
        int boxUnitWidth = 30;

        // This point is the middle of the board. It will be used for rotating.
        Point boardMidpoint = new Point(
                originX + boxUnitWidth * 3 / 2,
                originY + boxUnitWidth * 3 / 2);

        // Draws the left vertical line of a board based on the given origin coordinates.
        NsccLine leftVerticleLine = CreateRotatedLine(
                originX + boxUnitWidth,
                originY,
                originX + boxUnitWidth,
                originY + boxUnitWidth * 3,
                radiansRotation,
                boardMidpoint);
        leftVerticleLine.setForeground(lineColor);
        mainWindow.add(leftVerticleLine);

        // Draws the right vertical line of a board based on the given origin coordinates.
        NsccLine rightVerticleLine = CreateRotatedLine(
                originX + boxUnitWidth * 2,
                originY,
                originX + boxUnitWidth * 2,
                originY + boxUnitWidth * 3,
                radiansRotation,
                boardMidpoint);
        rightVerticleLine.setForeground(lineColor);
        mainWindow.add(rightVerticleLine);

        // Draws the top  horizontal line of a board based on the given origin coordinates.
        NsccLine topHorizontalLine = CreateRotatedLine(
                originX,
                originY + boxUnitWidth,
                originX + boxUnitWidth * 3,
                originY + boxUnitWidth,
                radiansRotation,
                boardMidpoint);
        topHorizontalLine.setForeground(lineColor);
        mainWindow.add(topHorizontalLine);

        // Draws the top  horizontal line of a board based on the given origin coordinates.
        NsccLine bottomHorizontalLine = CreateRotatedLine(
                originX,
                originY + boxUnitWidth * 2,
                originX + boxUnitWidth * 3,
                originY + boxUnitWidth * 2,
                radiansRotation,
                boardMidpoint);
        bottomHorizontalLine.setForeground(lineColor);
        mainWindow.add(bottomHorizontalLine);

        // Signals the window to redraw itself so all the lines appear.
        mainWindow.repaint();
    }

    /*
    This method will create a line with the specified
    end points, that is rotated around the midpoint
    by the specified radians.
     */
    private NsccLine CreateRotatedLine(int x1, int y1, int x2, int y2, double radiansRotation, Point rotationPoint)
    {
        // Creates the first end point of line
        Point firstRotatedPoint = RotatePoint(x1,y1,radiansRotation, rotationPoint);

        // Creates th second end point of the line
        Point secondRotatedPoint = RotatePoint(x2,y2,radiansRotation, rotationPoint);

        // Returns a new rotated line
        return new NsccLine(
                (int)firstRotatedPoint.getX(),
                (int)firstRotatedPoint.getY(),
                (int)secondRotatedPoint.getX(),
                (int)secondRotatedPoint.getY());
    }

    // Rotates a point around a given rotation point by specified radians.
    private Point RotatePoint(int x, int y, double radians, Point rotationPoint)
    {
        // X component of the rotation point
        double a = rotationPoint.getX();

        // Y component of the rotation point
        double b = rotationPoint.getY();

        // Distance from given x,y to rotation-point. This will be radius used for rotation.
        double radius = Math.sqrt(
                ((x - a) * (x - a)) +
                ((y - b) * (y - b)));

        // Converts rectangular coordinates to polar coordinates
        double omega = Math.atan2(y - rotationPoint.getY(), x - rotationPoint.getX());

        // Rotates the x coordinate
        double rotatedX = radius *
                (Math.cos(radians) * Math.cos(omega) - Math.sin(radians) * Math.sin(omega))
                + rotationPoint.getX();

        // Rotates the y coordinate
        double rotatedY = radius *
                (Math.sin(radians) * Math.cos(omega) + Math.cos(radians) * Math.sin(omega))
                + rotationPoint.getY();

        // Returns the rotated point
        return new Point((int)rotatedX, (int)rotatedY);
    }

}
