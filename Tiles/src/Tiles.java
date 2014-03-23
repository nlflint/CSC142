import java.awt.*;

/**
 * This class draws several different tessellations.
 *
 * @author Nathan Flint
 * @version Assignment 11: Tiling
 *
 * Grading Level: Challenge
 *
 */
public class Tiles
{
    public static final int WIDTH = 200;
    public static final int HEIGHT = 150;


    public void drawBasketWeave()
    {
        // Create drawing panel
        DrawingPanel panel = new DrawingPanel(WIDTH,HEIGHT);
        panel.setTitle("BasketWeave");


        // Get drawing surface
        Graphics drawingSurface = panel.getGraphics();

        // define pattern width and height
        final int basketPatternWidth = 80;
        final int basketPatternHeight = 40;

        // identify how many patterns will be needed
        int countPatternsAcross = WIDTH / basketPatternWidth + 1;
        int countPatternsDown = HEIGHT / basketPatternHeight + 1;
        int totalPatterns = countPatternsAcross * countPatternsDown;

        // we know how many patterns to draw, so loop through the total.
        for (int patternIndex = 0; patternIndex < totalPatterns; patternIndex++)
        {
            // Get column and row of current pattern index
            int currentColumn = patternIndex % countPatternsAcross;
            int currentRow = patternIndex / countPatternsAcross;

            // Calculates x and y coordinate of next drawing pattern
            int x = currentColumn * basketPatternWidth;
            int y = currentRow * basketPatternHeight;


            drawBasketWeaveTile(drawingSurface, x, y, basketPatternWidth, basketPatternHeight);
        }
    }

    private void drawBasketWeaveTile(Graphics drawingSurface, int x, int y, int width, int height)
    {
        int backgroundWidth = width / 2;

        // Draw vertical weave background
        drawingSurface.setColor(new Color(255, 201, 14));
        drawingSurface.fillRect(x, y, backgroundWidth, height);

        // Draw vertical weave background
        drawingSurface.setColor(new Color(185, 122, 87));
        int vertX = x + width / 2;
        drawingSurface.fillRect(vertX, y, backgroundWidth, height);


        //drawingSurface.drawLine(x, y, x + width, y + height);

    }

    public static void main(String[] args)
    {
        Tiles tiles = new Tiles();
        tiles.drawBasketWeave();
    }
}
