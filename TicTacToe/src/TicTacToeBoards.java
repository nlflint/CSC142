import java.awt.*;

/**
 * This class draws several different tic tac toe boards to a window.
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

        // Draws a board with thick lines
        drawTicTacToeBoard(40, 170, 6);

        // Draws a board colored red
        drawTicTacToeBoard(170, 40, Color.RED);

        // Draws a board rotated pi/8 radians around its center
        drawTicTacToeBoard(170, 170, Math.PI/8);
    }

    /**
     * Draws a tic tac toe board. Arguments supplied will indicate the (x, y) coordinates
     * of the upper-left corner of the bounding box for the tic-tac-toe board.
     *
     * @param originX X component of the upper left corner coordinates of the board.
     * @param originY Y component of the upper left corner coordinates of the board.
     */
    public void drawTicTacToeBoard(int originX, int originY)
    {
        // call private draw routine with specified location. Force with zero rotation and color black.
        drawBoardWithLines(originX, originY, Color.BLACK, 0);
    }

    /**
     * Draws a colored tic tac toe board. Arguments supplied will indicate the (x, y) coordinates
     * of the upper-left corner of the bounding box for the tic-tac-toe board, and the color of the lines.
     *
     * @param originX X component of the upper left corner of the board.
     * @param originY Y component of the upper left corner of the board.
     * @param lineColor Color of the line
     */
    public void drawTicTacToeBoard(int originX, int originY, Color lineColor)
    {
        // call private draw routine with specified values and zero rotation
        drawBoardWithLines(originX, originY, lineColor, 0);
    }

    /**
     * Draws a black rotated tic tac toe board. Arguments supplied will indicate the (x, y) coordinates
     * of the upper-left corner of the bounding box for the tic-tac-toe board before rotation, and the
     * rotation in radians that the board will be rotation around its center.
     *
     * @param originX X component of the upper left corner of the board before rotation.
     * @param originY Y component of the upper left corner of the board before rotation.
     * @param radians Radians to rotate around the center of the board.
     */
    public void drawTicTacToeBoard(int originX, int originY, double radians)
    {
        // Calls the private draw method with specified values and color forced to black.
        drawBoardWithLines(originX, originY, Color.BLACK, radians);
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

        // Draws the left vertical line of a board based on the given origin coordinates and thickness.
        NsccRectangle leftVerticleLine = new NsccRectangle(
                originX + boxUnitWidth - thicknessOffset,
                originY,
                lineThickness,
                boxUnitWidth * 3);
        leftVerticleLine.setFilled(true);
        leftVerticleLine.setBackground(Color.BLACK);
        mainWindow.add(leftVerticleLine);

        // Draws the right vertical line of a board based on the given origin coordinates and thickness.
        NsccRectangle rightVeritcleLine = new NsccRectangle(
                originX + boxUnitWidth * 2 - thicknessOffset,
                originY,
                lineThickness,
                boxUnitWidth * 3);
        rightVeritcleLine.setFilled(true);
        rightVeritcleLine.setBackground(Color.BLACK);
        mainWindow.add(rightVeritcleLine);

        // Draws the top  horizontal line of a board based on the given origin coordinates and thickness.
        NsccRectangle topHorizontalLine = new NsccRectangle(
                originX,
                originY + boxUnitWidth - thicknessOffset,
                boxUnitWidth * 3,
                lineThickness);
        topHorizontalLine.setFilled(true);
        topHorizontalLine.setBackground(Color.BLACK);
        mainWindow.add(topHorizontalLine);

        // Draws the top  horizontal line of a board based on the given origin coordinates and thickness.
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

    // This private method allows setting location, color and radians rotation at the same time.
    private void drawBoardWithLines(int originX, int originY, Color lineColor, double radiansOfRotation)
    {
        /*
         Defines side length of the boxes that make the board. There are 9
         of these boxes in a tic tac toe board. Changing this will alter the size of
         the entire board. Standard value is 30.
          */
        int boxWidth = 30;

        // This point is the middle of the board. It will be used for rotating.
        Point boardCenterPoint = new Point(
                originX + boxWidth * 3 / 2,
                originY + boxWidth * 3 / 2);

        // Draws the left vertical line of a board based on the given origin coordinates.
        NsccLine leftVerticleLine = CreateRotatedLine(
                originX + boxWidth,
                originY,
                originX + boxWidth,
                originY + boxWidth * 3,
                radiansOfRotation,
                boardCenterPoint);
        leftVerticleLine.setForeground(lineColor);
        mainWindow.add(leftVerticleLine);

        // Draws the right vertical line of a board based on the given origin coordinates.
        NsccLine rightVerticleLine = CreateRotatedLine(
                originX + boxWidth * 2,
                originY,
                originX + boxWidth * 2,
                originY + boxWidth * 3,
                radiansOfRotation,
                boardCenterPoint);
        rightVerticleLine.setForeground(lineColor);
        mainWindow.add(rightVerticleLine);

        // Draws the top  horizontal line of a board based on the given origin coordinates.
        NsccLine topHorizontalLine = CreateRotatedLine(
                originX,
                originY + boxWidth,
                originX + boxWidth * 3,
                originY + boxWidth,
                radiansOfRotation,
                boardCenterPoint);
        topHorizontalLine.setForeground(lineColor);
        mainWindow.add(topHorizontalLine);

        // Draws the top  horizontal line of a board based on the given origin coordinates.
        NsccLine bottomHorizontalLine = CreateRotatedLine(
                originX,
                originY + boxWidth * 2,
                originX + boxWidth * 3,
                originY + boxWidth * 2,
                radiansOfRotation,
                boardCenterPoint);
        bottomHorizontalLine.setForeground(lineColor);
        mainWindow.add(bottomHorizontalLine);

        // Signals the window to redraw itself so all the lines appear.
        mainWindow.repaint();
    }

    /*
    This method will create a line with the specified
    end points, that is rotated around the specified
    center of rotation by the specified radians.
     */
    private NsccLine CreateRotatedLine(int x1, int y1, int x2, int y2, double radians, Point centerOfRotation)
    {
        // Creates the first end point of the line
        Point firstRotatedPoint = RotatePoint(x1, y1, radians, centerOfRotation);

        // Creates th second end point of the line
        Point secondRotatedPoint = RotatePoint(x2, y2, radians, centerOfRotation);

        // Returns a new rotated line
        return new NsccLine(
                (int) firstRotatedPoint.getX(),
                (int) firstRotatedPoint.getY(),
                (int) secondRotatedPoint.getX(),
                (int) secondRotatedPoint.getY());
    }

    // Rotates a point around a given rotation point by specified radians.
    private Point RotatePoint(int x, int y, double radians, Point centerOfRotation)
    {
        // X component of the center of rotation
        double a = centerOfRotation.getX();

        // Y component of the center of rotation
        double b = centerOfRotation.getY();

        // Distance from given x,y to rotation-point. This will be radius used for rotation.
        double radius = Math.sqrt(
                ((x - a) * (x - a)) +
                ((y - b) * (y - b)));

        // Converts rectangular coordinates to polar coordinates
        double omega = Math.atan2(y - b, x - a);

        // Rotates the x coordinate
        double rotatedX = radius *
                (Math.cos(radians) * Math.cos(omega) - Math.sin(radians) * Math.sin(omega))
                + a;

        // Rotates the y coordinate
        double rotatedY = radius *
                (Math.sin(radians) * Math.cos(omega) + Math.cos(radians) * Math.sin(omega))
                + b;

        // Returns the rotated point
        return new Point((int)rotatedX, (int)rotatedY);
    }

}
