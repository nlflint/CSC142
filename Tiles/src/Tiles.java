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

        // define tile width and height
        final int tileWidth = 80;
        final int tileHeight = 80;

        // identify how many tiles will be needed
        int tileCountAcross = WIDTH / tileWidth + 1;
        int tileCountDown = HEIGHT / tileHeight + 1;
        int totalTiles = tileCountAcross * tileCountDown;

        // we know how many tiles to draw, so loop through the total.
        for (int tileIndex = 0; tileIndex < totalTiles; tileIndex++)
        {
            // Get column and row of current tiles index
            int currentColumn = tileIndex % tileCountAcross;
            int currentRow = tileIndex / tileCountAcross;

            // Calculates x and y coordinate of next drawing tiles
            int x = currentColumn * tileWidth;
            int y = currentRow * tileHeight;

            // Draws the tile
            drawBasketWeaveTile(drawingSurface, x, y, tileWidth, tileHeight);
        }
    }

    private void drawBasketWeaveTile(Graphics g, int x, int y, int width, int height)
    {
        int weaveWidth = width / 2;
        int weaveHeight = height / 2;

        // Draw vertical weaves
        drawVerticalWeave(g, x, y, weaveWidth, weaveHeight);
        drawVerticalWeave(g, x + weaveWidth, y + weaveHeight, weaveHeight, weaveHeight);

        // Draw Horizontal weaves
        drawHorizontalWeave(g, x + weaveWidth, y, weaveWidth, weaveHeight);
        drawHorizontalWeave(g, x, y + weaveHeight, weaveWidth, weaveHeight);
    }

    // Draws vertical weave background
    public void drawVerticalWeave(Graphics g, int x, int y, int width, int height)
    {
        // Draw colored shape
        g.setColor(new Color(255, 201, 14));
        g.fillRect(x, y, width, height);

        // Draws lines
        g.setColor(Color.black);
        g.drawLine(x, y, x + width, y);
        g.drawLine(x, y, x, y + height);
        g.drawLine(x + width / 2, y, x + width / 2, y + height);
    }

    // Draws horizontal weave background
    public void drawHorizontalWeave(Graphics g, int x, int y, int width, int height)
    {
        // Draw colored shape
        g.setColor(new Color(185, 122, 87));
        g.fillRect(x, y, width, height);

        // Draws lines
        g.setColor(Color.black);
        g.drawLine(x, y, x + width, y);
        g.drawLine(x, y, x, y + height);
        g.drawLine(x, y + height / 2, x + width, y + height / 2);
    }

    public void drawMed1()
    {
        // Create drawing panel
        DrawingPanel panel = new DrawingPanel(WIDTH,HEIGHT);
        panel.setTitle("BasketWeave");


        // Get drawing surface
        Graphics drawingSurface = panel.getGraphics();

        // define tile width and height
        final int tileWidth = 24;
        final int tileHeight = 24;

        // identify how many tiles will be needed
        int tileCountAcross = WIDTH / tileWidth + 1;
        int tileCountDown = HEIGHT / tileHeight + 1;
        int totalTiles = tileCountAcross * tileCountDown;

        // we know how many tiles to draw, so loop through the total.
        for (int tileIndex = 0; tileIndex < totalTiles; tileIndex++)
        {
            // Get column and row of current tiles index
            int currentColumn = tileIndex % tileCountAcross;
            int currentRow = tileIndex / tileCountAcross;

            // Calculates x and y coordinate of next drawing tiles
            int x = currentColumn * tileWidth;
            int y = currentRow * tileHeight;

            // Draws the tile
            drawMed1Tile(drawingSurface, x, y, tileWidth, tileHeight);
        }

    }

    // draws a med 1 tile with given dimensions
    private void drawMed1Tile(Graphics g, int x, int y, int width, int height)
    {
        // Fill in red background
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);

        // Setup points to draw an octagon
        int diamondRadius = (int) (width * (7 / 24.0));
        int[] xPoints = new int[] {
                x + diamondRadius,
                x + diamondRadius + 10,
                x + width,
                x + width,
                x + diamondRadius + 10,
                x + diamondRadius,
                x,
                x
        };

        int[] yPoints = new int[] {
                y,
                y,
                y + diamondRadius,
                y + diamondRadius + 10,
                y + height,
                y + height,
                y + diamondRadius + 10,
                y + diamondRadius
        };

        // draw octagon
        g.setColor(new Color(255,255,64));
        g.fillPolygon(xPoints, yPoints, xPoints.length);

        // draw lines
        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, xPoints.length);

    }

    public static void main(String[] args)
    {
        Tiles tiles = new Tiles();
        tiles.drawBasketWeave();
        tiles.drawMed1();
    }
}
