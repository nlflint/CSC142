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
    public static final int WIDTH = 500; //200;
    public static final int HEIGHT = 400; //150;

    /**
     * Draws the basket weave pattern
     */
    public void drawPattern(Tile tile)
    {
        // Create drawing panel
        DrawingPanel panel = new DrawingPanel(WIDTH,HEIGHT);
        panel.setTitle("BasketWeave");

        // Get drawing surface
        Graphics drawingSurface = panel.getGraphics();

        // define tile width and height
        final int tileWidth = tile.getWidth();
        final int tileHeight = tile.getHeight();

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
            tile.drawTile(drawingSurface, x, y);
        }
    }

    /**
     * Draws the Mediterranean 1 pattern
     */
    public void drawMed1()
    {
        // Create drawing panel
        DrawingPanel panel = new DrawingPanel(WIDTH,HEIGHT);
        panel.setTitle("Mediterranean 1");


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

    /**
     * Draws the Mediterranean 2 pattern
     */
    public void drawMed2()
    {
        // Create drawing panel
        DrawingPanel panel = new DrawingPanel(WIDTH,HEIGHT);
        panel.setTitle("Mediterranean 2");

        // Get drawing surface
        Graphics drawingSurface = panel.getGraphics();

        // define tile width and height
        final int tileWidth = 34;
        final int tileHeight = 34;

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
            drawMed2Tile(drawingSurface, x, y, tileWidth, tileHeight);
        }
    }

    // draws a med 2 tile with given dimensions
    private void drawMed2Tile(Graphics g, int x, int y, int width, int height)
    {
        // Fill in red background
        g.setColor(new Color(192, 192, 128));
        g.fillRect(x, y, width, height);

        // Setup points to draw an octagon
        int octagonEdge = (int) (width * (7 / 34.0));
        int octagonWidth = octagonEdge * 2 + 10;

        int[] xPoints = new int[] {
                x + octagonEdge,
                x + octagonEdge + 10,
                x + octagonWidth,
                x + octagonWidth,
                x + octagonEdge + 10,
                x + octagonEdge,
                x,
                x
        };

        int[] yPoints = new int[] {
                y,
                y,
                y + octagonEdge,
                y + octagonEdge + 10,
                y + octagonEdge * 2 + 10,
                y + octagonEdge * 2 + 10,
                y + octagonEdge + 10,
                y + octagonEdge
        };

        // draw lines
        g.setColor(Color.black);
        g.drawPolygon(xPoints, yPoints, xPoints.length);

        // draw blues squares
        drawRect(g,x + octagonWidth, y + octagonEdge, 10, 10, new Color(0, 112, 192) );
        drawRect(g,x + octagonEdge, y + octagonWidth, 10, 10, new Color(0, 112, 192) );
    }

    /**
     * Draws an open weave pattern
     */
    public void drawOpenWeave()
    {
        // Create drawing panel
        DrawingPanel panel = new DrawingPanel(WIDTH,HEIGHT);
        panel.setTitle("Open Weave");

        // Get drawing surface
        Graphics drawingSurface = panel.getGraphics();

        // define tile width and height
        final int tileWidth = 60;
        final int tileHeight = 60;

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
            drawOpenWeaveTile(drawingSurface, x, y, tileWidth, tileHeight);
        }
    }

    // Draws an open weave tile
    private void drawOpenWeaveTile(Graphics g, int x, int y, int width, int height)
    {
        int longSide = (int) (width * (2 / 3.0));
        int shortSide = (int) (width * (1 / 3.0));
        int squareSide = (int) (width * (1 / 6.0));

        // Define colors
        Color pink = new Color(204, 136, 204);
        Color maroon = new Color(154, 32, 64);

        // Draw background
        g.setColor(pink);
        g.fillRect(x, y, width, height);

        // Draw weaves
        drawRect(g, x, y, longSide, shortSide, pink);
        drawRect(g, x + longSide, y - squareSide, shortSide, longSide, pink);
        drawRect(g, x, y + shortSide, squareSide, squareSide, maroon);
        drawRect(g, x + squareSide, y + shortSide, shortSide, longSide, pink);
        drawRect(g, x + squareSide + shortSide, y + shortSide, squareSide, squareSide, maroon);
        drawRect(g, x, y + shortSide * 2 + squareSide, squareSide, squareSide, maroon);
        drawRect(g, x + squareSide + shortSide, y + shortSide * 2 + squareSide, squareSide, squareSide, maroon);
        drawRect(g, x + squareSide + shortSide, y + shortSide + squareSide, longSide, shortSide, pink);


    }

    private void drawRect(Graphics g, int x, int y, int width, int height, Color c)
    {
        // the colored rect
        g.setColor(c);
        g.fillRect(x, y, width, height);

        // Draw lines around the squres
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
    }


    public static void main(String[] args)
    {
        Tiles tiles = new Tiles();
        tiles.drawPattern(new BasketWeave());
        //tiles.drawMed1();
        //tiles.drawMed2();
        //tiles.drawOpenWeave();
    }


}

abstract class Tile
{
    public abstract String getTitle();
    public abstract int getWidth();
    public abstract int getHeight();
    public abstract void drawTile(Graphics g, int x, int y);

    protected void drawRect(Graphics g, int x, int y, int width, int height, Color c)
    {
        // the colored rect
        g.setColor(c);
        g.fillRect(x, y, width, height);

        // Draw lines around the squres
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
    }
}

class BasketWeave extends Tile
{
    private final int width;
    private final int height;
    private final String title;

    /**
     * Constructor sets up object properites
     */
    public BasketWeave()
    {
        this.width = 80;
        this.height = 80;
        title = "Basket Weave";
    }

    public String getTitle() {
        return title;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void drawTile(Graphics g, int x, int y)
    {
        // Define rectangle sides
        int longSide = width / 2;
        int shortSide = longSide / 2;

        // Define colors
        Color honey = new Color(255, 201, 14);
        Color clay = new Color(185, 122, 87);

        // Draw vertical weaves
        drawRect(g, x, y, shortSide, longSide, honey);
        drawRect(g, x + shortSide, y, shortSide, longSide, honey);
        drawRect(g, x + longSide, y, longSide, shortSide, clay);
        drawRect(g, x + longSide, y + shortSide, longSide, shortSide, clay);
        drawRect(g, x, y + longSide, longSide, shortSide, clay);
        drawRect(g, x, y + longSide + shortSide, longSide, shortSide, clay);
        drawRect(g, x + longSide, y + longSide, shortSide, longSide, honey);
        drawRect(g, x + longSide + shortSide, y + longSide, shortSide, longSide, honey);
    }
}


