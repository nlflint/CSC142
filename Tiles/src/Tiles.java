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
        panel.setTitle(tile.getTitle());

        // Get drawing surface
        Graphics drawingSurface = panel.getGraphics();

        // define tile width and height
        final int tileWidth = tile.getWidth();

        // identify how many tiles will be needed
        int tileCountAcross = WIDTH / tileWidth + 1;
        int tileCountDown = HEIGHT / tileWidth + 1;
        int totalTiles = tileCountAcross * tileCountDown;

        // we know how many tiles to draw, so loop through the total.
        for (int tileIndex = 0; tileIndex < totalTiles; tileIndex++)
        {
            // Get column and row of current tiles index
            int currentColumn = tileIndex % tileCountAcross;
            int currentRow = tileIndex / tileCountAcross;

            // Calculates x and y coordinate of next drawing tiles
            int x = currentColumn * tileWidth;
            int y = currentRow * tileWidth;

            // Draws the tile
            tile.drawTile(drawingSurface, x, y);
        }
    }

    public static void main(String[] args)
    {
        Tiles tiles = new Tiles();
        tiles.drawPattern(new BasketWeave());
        tiles.drawPattern(new Med1());
        tiles.drawPattern(new Med2());
        tiles.drawPattern(new OpenWeave());
        tiles.drawPattern(new Pythagorean());
    }


}

abstract class Tile
{
    // Fields
    protected int width;
    protected String title;

    // Properties
    public String getTitle() { return title; }
    public int getWidth() { return width; }

    // Common function
    protected void drawRect(Graphics g, int x, int y, int width, int height, Color c)
    {
        // the colored rect
        g.setColor(c);
        g.fillRect(x, y, width, height);

        // Draw lines around the squres
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
    }

    // Must be implemented
    public abstract void drawTile(Graphics g, int x, int y);
}

class BasketWeave extends Tile
{
    /**
     * Constructor initializes values
     */
    public BasketWeave()
    {
        this.width = 80;
        title = "Basket Weave";
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

class Med1 extends Tile
{
    /**
     * Constructor initializes values
     */
    public Med1()
    {
        this.width = 24;
        title = "Mediterranean 1";
    }

    public void drawTile(Graphics g, int x, int y)
    {
        // Fill in red background
        g.setColor(Color.red);
        g.fillRect(x, y, width, width);

        // Setup points to draw an octagon
        int diamondRadius = (int) (width * (7 / 24.0));
        int octagonLong = (int) (width * (10 / 24.0));
        int[] xPoints = new int[] {
                x + diamondRadius,
                x + diamondRadius + octagonLong,
                x + width,
                x + width,
                x + diamondRadius + octagonLong,
                x + diamondRadius,
                x,
                x
        };

        int[] yPoints = new int[] {
                y,
                y,
                y + diamondRadius,
                y + diamondRadius + octagonLong,
                y + width,
                y + width,
                y + diamondRadius + octagonLong,
                y + diamondRadius
        };

        // draw octagon
        g.setColor(new Color(255, 255, 64));
        g.fillPolygon(xPoints, yPoints, xPoints.length);

        // draw lines
        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, xPoints.length);
    }
}

class Med2 extends Tile
{
    /**
     * Constructor initializes values
     */
    public Med2()
    {
        this.width = 34;
        title = "Mediterranean 2";
    }

    public void drawTile(Graphics g, int x, int y)
    {
        // Fill in red background
        g.setColor(new Color(192, 192, 128));
        g.fillRect(x, y, width, width);

        // Setup points to draw an octagon
        int octagonShort = (int) (width * (7 / 34.0));
        int octagonLong = (int) (width * (10 / 34.0));
        int octagonWidth = octagonShort * 2 + octagonLong;

        int[] xPoints = new int[] {
                x + octagonShort,
                x + octagonShort + octagonLong,
                x + octagonWidth,
                x + octagonWidth,
                x + octagonShort + octagonLong,
                x + octagonShort,
                x,
                x
        };

        int[] yPoints = new int[] {
                y,
                y,
                y + octagonShort,
                y + octagonShort + octagonLong,
                y + octagonShort * 2 + octagonLong,
                y + octagonShort * 2 + octagonLong,
                y + octagonShort + octagonLong,
                y + octagonShort
        };

        // draw lines
        g.setColor(Color.black);
        g.drawPolygon(xPoints, yPoints, xPoints.length);

        // draw blues squares
        drawRect(g, x + octagonWidth, y + octagonShort, octagonLong, octagonLong, new Color(0, 112, 192));
        drawRect(g, x + octagonShort, y + octagonWidth, octagonLong, octagonLong, new Color(0, 112, 192));
    }
}

class OpenWeave extends Tile
{
    /**
     * Constructor initializes values
     */
    public OpenWeave()
    {
        this.width = 60;
        title = "Open Weave";
    }

    public void drawTile(Graphics g, int x, int y)
    {
        int longSide = (int) (width * (2 / 3.0));
        int shortSide = (int) (width * (1 / 3.0));
        int squareSide = (int) (width * (1 / 6.0));

        // Define colors
        Color pink = new Color(204, 136, 204);
        Color maroon = new Color(154, 32, 64);

        // Draw background
        g.setColor(pink);
        g.fillRect(x, y, width, width);

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
}

class Pythagorean extends Tile
{
    /**
     * Constructor initializes values
     */
    public Pythagorean()
    {
        width = 50;
        title = "Pythagorean";
    }

    public void drawTile(Graphics g, int x, int y)
    {
        int longSide = (int) (width * (2 / 5.0));
        int shortSide = longSide / 2;

        // Define colors
        Color blue = new Color(64, 64, 192);
        Color aqua = new Color(136, 204, 204);

        // Draw background
        g.setColor(aqua);
        g.fillRect(x, y, width, width);

        // Draw weaves
        drawRect(g, x, y, longSide, longSide, aqua);
        drawRect(g, x + longSide, y, shortSide, shortSide, blue);
        drawRect(g, x + shortSide, y + longSide, shortSide, shortSide, blue);
        drawRect(g, x + longSide, y + shortSide, longSide, longSide, aqua);
        drawRect(g, x + longSide * 2, y + shortSide, shortSide, shortSide, blue);

        drawRect(g, x, y + longSide * 2, shortSide, shortSide, blue);
        drawRect(g, x + shortSide, y + longSide + shortSide, longSide, longSide, aqua);
        drawRect(g, x + longSide + shortSide, y + shortSide + longSide, shortSide, shortSide, blue);
        drawRect(g, x + longSide + shortSide, y + longSide * 2, longSide, longSide, aqua);


    }
}


