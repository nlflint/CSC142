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
        mainWindow = new NsccWindow(10,10,300,330);
        drawTicTacToeBoard(40, 40);
        drawTicTacToeBoard(40, 170, 1);
        drawTicTacToeBoard(170, 40, Color.RED);
        drawTicTacToeBoard(170, 170);
    }

    /**
     * Draws colored tic tac toe board. Arguments supplied will indicate the (x, y) coordinates
     * of the upper-left corner of the bounding box for the tic-tac-toe board, and the color of the lines.
     *
     * @param originX X component of the upper left corner of the board.
     * @param originY Y component of the upper left corner of the board.
     * @param lineColor Color of the line
     */
    public void drawTicTacToeBoard(int originX, int originY, Color lineColor)
    {
        /*
         Defines side length of the boxes that make the tic tac toe board. There are 9
         of these boxes in a tic tac toe board. Changing this will alter the overall
         size of the entire board. Standard value is 30.
          */
        //
        int boxUnitWidth = 30;

        // Draws the left vertical line of a board based on the given origin coordinates.
        NsccLine leftVerticleLine = new NsccLine(
                originX + boxUnitWidth,
                originY,
                originX + boxUnitWidth,
                originY + boxUnitWidth * 3);
        leftVerticleLine.setForeground(lineColor);
        mainWindow.add(leftVerticleLine);

        // Draws the right vertical line of a board based on the given origin coordinates.
        NsccLine rightVeritcleLine = new NsccLine(
                originX + boxUnitWidth * 2,
                originY,
                originX + boxUnitWidth * 2,
                originY + boxUnitWidth * 3);
        rightVeritcleLine.setForeground(lineColor);
        mainWindow.add(rightVeritcleLine);

        // Draws the top  horizontal line of a board based on the given origin coordinates.
        NsccLine topHorizontalLine = new NsccLine(
                originX,
                originY + boxUnitWidth,
                originX + boxUnitWidth * 3,
                originY + boxUnitWidth);
        topHorizontalLine.setForeground(lineColor);
        mainWindow.add(topHorizontalLine);

        // Draws the top  horizontal line of a board based on the given origin coordinates.
        NsccLine bottomHorizontalLine = new NsccLine(
                originX,
                originY + boxUnitWidth * 2,
                originX + boxUnitWidth * 3,
                originY + boxUnitWidth * 2);
        bottomHorizontalLine.setForeground(lineColor);
        mainWindow.add(bottomHorizontalLine);

        // Signals the window to redraw itself so all the lines appear.
        mainWindow.repaint();

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

}
