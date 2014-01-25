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
     * This is the main application method that starts the program.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args)
    {
        TicTacToeBoards board = new TicTacToeBoards();
        board.drawTicTacToeBoard(40,40);
        board.drawTicTacToeBoard(40,170);
        board.drawTicTacToeBoard(170,40);
        board.drawTicTacToeBoard(170,170);
    }

    // This is the window where all the tic-tac-toe boards will be drawn
    private NsccWindow mainWindow;

    /**
     * This constructor creates a NsccWindow and saves it to a private member for later use.
     */
    public TicTacToeBoards()
    {
        mainWindow = new NsccWindow(10,10,300,330);
    }

    /**
     * This draws a basic tic tac toe board. Arguments supplied will indicate the (x, y) coordinates
     * of the upper-left corner of the bounding box for the tic-tac-toe board.
     * the board.
     *
     * @param originX The x component of the upper left corner of the board.
     * @param originY The y component of the upper left corner of the board.
     */
    public void drawTicTacToeBoard(int originX, int originY)
    {
        // This is the side length of one of the boxes that make the tic tac toe board
        int boxUnitWidth = 30;

        // This draws the left vertical line of a board based on the given origin coordinates.
        NsccLine leftVerticleLine = new NsccLine(
                originX + boxUnitWidth,
                originY,
                originX + boxUnitWidth,
                originY + boxUnitWidth * 3);
        mainWindow.add(leftVerticleLine);

        // This draws the right vertical line of a board based on the given origin coordinates.
        NsccLine rightVeritcleLine = new NsccLine(
                originX + boxUnitWidth * 2,
                originY,
                originX + boxUnitWidth * 2,
                originY + boxUnitWidth * 3);
        mainWindow.add(rightVeritcleLine);

        // This draws the top  horizontal line of a board based on the given origin coordinates.
        NsccLine topHorizontalLine = new NsccLine(
                originX,
                originY + boxUnitWidth,
                originX + boxUnitWidth * 3,
                originY + boxUnitWidth);
        mainWindow.add(topHorizontalLine);

        // This draws the top  horizontal line of a board based on the given origin coordinates.
        NsccLine bottomHorizontalLine = new NsccLine(
                originX,
                originY + boxUnitWidth * 2,
                originX + boxUnitWidth * 3,
                originY + boxUnitWidth * 2);
        mainWindow.add(bottomHorizontalLine);

        // Redraw the window so all the lines appear.
        mainWindow.repaint();

    }

}
