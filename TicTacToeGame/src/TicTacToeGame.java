import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * This class implements a tic tac toe game
 *
 * @author Nathan Flint
 * @version Assignment 10: Tic-Tac-Toe
 *
 * Grading Level: Challenge
 */
public class TicTacToeGame extends NsccWindow implements ActionListener
{
    // Array holds buttons that represents the play spaces
    private JButton[] playSpaces;

    // Array represents where players have played. 1 for X, -1 for O
    private int[] spaceOwners;

    // Label shows players the state of the game
    private JLabel gameStatus;

    // Tracks whose turn it is
    private boolean isXTurn;

    // Reset button
    private JButton resetButton;

    /**
     * Constructor initializes game, and sets the state to X's turn.
     */
    public TicTacToeGame()
    {
        // Setup the main window
        setLocation(10, 10);
        setSize(235, 280);
        setTitle("Tic-Tac-Toe");

        //Setup a black background behind the buttons
        NsccRectangle background = new NsccRectangle(30, 30, 50 * 3 + 10, 50 * 3 + 10);
        background.setBackground(Color.BLACK);
        background.setFilled(true);
        add(background);

        // Create reset button
        resetButton = new JButton();
        resetButton.setSize(100, 20);
        resetButton.setLocation(60, 5);
        resetButton.setText("Reset");
        resetButton.addActionListener(this);
        resetButton.setEnabled(false);
        add(resetButton);

        // Setup game status label
        gameStatus = new JLabel();
        gameStatus.setLocation(30, 200);
        gameStatus.setSize(160, 20);
        gameStatus.setHorizontalAlignment(JLabel.CENTER);
        add(gameStatus);

        // Sets up the playing space
        initializeTicTacToeBoard();

        // Setup space owners
        spaceOwners = new int[9];

        // Set initial game state
        isXTurn = true;
        updateGameState();

    }

    // Initializes all the buttons in the playing space
    private void initializeTicTacToeBoard()
    {
        // Setup play spaces, aka buttons.
        playSpaces = new JButton[9];
        for (int i = 0; i < playSpaces.length; i++)
        {
            // The row and column of the button;
            int buttonRow = i / 3;
            int buttonColumn = i % 3;

            // Calculate button position
            int xPosition = 30 + (buttonColumn * 55);
            int yPosition = 30 + (buttonRow * 55);

            // Create and initialize button
            JButton button = new JButton();
            button.setSize(50, 50);
            button.setLocation(xPosition, yPosition);
            button.setOpaque(true);

            // Add button to window
            add(button);

            // Add action to button
            button.addActionListener(this);

            // Save button reference to an array
            playSpaces[i] = button;
        }
    }

    // Updates status text and checks for end game scenarios.
    private void updateGameState()
    {
        // Check if X has won
        if (winnerIs("X"))
        {
            gameStatus.setText("X wins!");
            disableAllSpaces();
            resetButton.setEnabled(true);
        }
        // Check if O has won
        else if (winnerIs("O"))
        {
            gameStatus.setText("O wins!");
            disableAllSpaces();
            resetButton.setEnabled(true);
        }
        // Check for tie
        else if (allSpacesAreUsed())
        {
            gameStatus.setText("Cat game");
            resetButton.setEnabled(true);
        }
        // game is still in progress, so show whose turn it is
        else if (isXTurn)
        {
            gameStatus.setText("X's turn");
        }
        else
        {
            gameStatus.setText("O's turn");
        }
    }

    // Checks to see if the given player has won. Accepts "X" or "O"
    private boolean winnerIs(String player)
    {
        // documents player winning totals
        int xPlayerWinningTotal = 3;
        int oPlayerWinningTotal = -3;

        // Set winning total based on given player
        int winningTotal = player.equals("X") ? xPlayerWinningTotal : oPlayerWinningTotal;

        // Check horizontally
        if (spaceOwners[0] + spaceOwners[1] + spaceOwners[2] == winningTotal
                || spaceOwners[3] + spaceOwners[4] + spaceOwners[5] == winningTotal
                || spaceOwners[6] + spaceOwners[7] + spaceOwners[8] == winningTotal)
            return true;

        // Check vertically
        if (spaceOwners[0] + spaceOwners[3] + spaceOwners[6] == winningTotal
                || spaceOwners[1] + spaceOwners[4] + spaceOwners[7] == winningTotal
                || spaceOwners[2] + spaceOwners[5] + spaceOwners[8] == winningTotal)
            return true;

        // Check diagonally
        if (spaceOwners[0] + spaceOwners[4] + spaceOwners[8] == winningTotal
                || spaceOwners[2] + spaceOwners[4] + spaceOwners[6] == winningTotal)
            return true;

        // player hasn't won
        return false;
    }

    // disabled all play spaces
    private void disableAllSpaces()
    {
        // Loop through buttons an disable each one.
        for (JButton button : playSpaces)
            button.setEnabled(false);
    }

    // Checks if all spaces have been played
    private boolean allSpacesAreUsed()
    {
        // Look through spaces, if any are enabled return false.
        for (JButton button : playSpaces)
            if (button.isEnabled())
                return false;
        return true;
    }

    /**
     * Overridden method handles button clicks.
      * @param e Information about the action performed.
     */
    public void actionPerformed(ActionEvent e)
    {
        // Check if reset button was clicked
        if (e.getSource() == resetButton)
        {
            resetGame();
            return;
        }

        // Get the button object.
        JButton button = (JButton) e.getSource();

        // Identify which space the button is in.
        int buttonIndex = findButtonIndex(button);

        // Let X or O take the space
        if (isXTurn)
        {
            button.setText("X");
            spaceOwners[buttonIndex] = 1;
        }
        else
        {
            button.setText("O");
            spaceOwners[buttonIndex] = -1;
        }

        // Update game state
        button.setEnabled(false);
        isXTurn = ! isXTurn;
        updateGameState();

    }

    // Sets game to initial state
    private void resetGame()
    {
        // Reset play spaces
        for (JButton button : playSpaces)
        {
            button.setEnabled(true);
            button.setText("");
        }

        // reset space owners
        Arrays.fill(spaceOwners, 0);

        // Change to x's turn
        isXTurn = true;

        // Update game status
        updateGameState();

        // Disable the reset button
        resetButton.setEnabled(false);
    }

    // Given an object, find it' index in the play space array
    private int findButtonIndex(JButton button)
    {
        // Loop through buttons looking for the one.
        for (int i = 0; i < playSpaces.length; i++)
            if (playSpaces[i] == button)
                return i;

        // Nothing found
        return -1;
    }

    /**
     * Application method.
     * @param args Command line arguments
     */
    public static void main(String[] args)
    {
        new TicTacToeGame();
    }
}
