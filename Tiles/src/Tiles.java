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

    /**
     * Tessellates the given tile onto a graphics panel
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

        // identify how many tiles will be needed.
        // Add 2 to rows and columns to fix bug where tiles don't fill the panel.
        int tileCountAcross = WIDTH / tileWidth + 2;
        int tileCountDown = HEIGHT / tileWidth + 2;
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

    // Application method
    public static void main(String[] args)
    {
        Tiles tiles = new Tiles();
        tiles.drawPattern(new BasketWeave());
        tiles.drawPattern(new Med1());
        tiles.drawPattern(new Med2());
        tiles.drawPattern(new OpenWeave());
        tiles.drawPattern(new Pythagorean());
        tiles.drawPattern(new BrickMortar());
        tiles.drawPattern(new BasketWeaveMortar());
        tiles.drawPattern(new PythagoreanMortar());
        tiles.drawPattern(new OpenWeaveMortar());
    }
}

// Abstract class is implemented by different tile patterns.
abstract class Tile
{
    // Fields
    protected int width;
    protected String title;

    // Properties
    public String getTitle() { return title; }
    public int getWidth() { return width; }

    // Utility function to draw rectangles
    protected void drawRect(Graphics g, int x, int y, int width, int height, Color c)
    {
        // the colored rect
        g.setColor(c);
        g.fillRect(x, y, width, height);

        // Draw lines around the rect
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
    }

    // Must be implemented
    public abstract void drawTile(Graphics g, int x, int y);
}

/**
 * Draws a basket weave tile
 */
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

    /**
     * Draws a tile
     * @param g Graphics object which will be drawn on
     * @param x X coordinate to draw the tile
     * @param y Y coordinate to draw the tile
     */
    public void drawTile(Graphics g, int x, int y)
    {
        // Define rectangle sides
        int longSide = width / 2;
        int shortSide = longSide / 2;

        // Define colors
        Color honey = new Color(255, 201, 14);
        Color clay = new Color(185, 122, 87);

        // Draw tile with rectangles
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

/**
 * Draws the Mediterranean 1 tile
 */
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

    /**
     * Draws a tile
     * @param g Graphics object which will be drawn on
     * @param x X coordinate to draw the tile
     * @param y Y coordinate to draw the tile
     */
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

        // draw lines around octagon
        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, xPoints.length);
    }
}

/**
 * Draws the Mediterranean 2 tile
 */
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

    /**
     * Draws a tile
     * @param g Graphics object which will be drawn on
     * @param x X coordinate to draw the tile
     * @param y Y coordinate to draw the tile
     */
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

        // draw octagon
        g.setColor(Color.black);
        g.drawPolygon(xPoints, yPoints, xPoints.length);

        // draw blues squares
        drawRect(g, x + octagonWidth, y + octagonShort, octagonLong, octagonLong, new Color(0, 112, 192));
        drawRect(g, x + octagonShort, y + octagonWidth, octagonLong, octagonLong, new Color(0, 112, 192));
    }
}

/**
 * Draws an open weave tile
 */
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

    /**
     * Draws a tile
     * @param g Graphics object which will be drawn on
     * @param x X coordinate to draw the tile
     * @param y Y coordinate to draw the tile
     */
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

        // Draw tile with rectangles
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

/**
 * Draws a Pythagorean tile
 */
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

    /**
     * Draws a tile
     * @param g Graphics object which will be drawn on
     * @param x X coordinate to draw the tile
     * @param y Y coordinate to draw the tile
     */
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

        // Draw tile with rectangles
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

/**
 * Draws a brick tile with mortar
 */
class BrickMortar extends Tile
{
    /**
     * Constructor initializes values
     */
    public BrickMortar()
    {
        width = 40;
        title = "Brick with Mortar";
    }

    /**
     * Draws a tile
     * @param g Graphics object which will be drawn on
     * @param x X coordinate to draw the tile
     * @param y Y coordinate to draw the tile
     */
    public void drawTile(Graphics g, int x, int y)
    {
        // Define base measurements
        int mortar = 1;
        int longSide = width - mortar * 2;
        int shortSide = longSide / 2 - mortar;

        // Define colors
        Color brick = new Color(136, 0, 21);

        // Draw background mortar
        g.setColor(Color.lightGray);
        g.fillRect(x, y, width, width);

        // Draw tile with rectangles
        drawRect(g, x + mortar, y + mortar, longSide, shortSide, brick);
        drawRect(g, x - shortSide - mortar, y + shortSide + mortar * 3, longSide, shortSide, brick);
    }
}


/**
 * Draws a basket weave tile with mortar
 */
class BasketWeaveMortar extends Tile
{
    /**
     * Constructor initializes values
     */
    public BasketWeaveMortar()
    {
        this.width = 80;
        title = "Basket Weave with Mortar";
    }

    /**
     * Draws a tile
     * @param g Graphics object which will be drawn on
     * @param x X coordinate to draw the tile
     * @param y Y coordinate to draw the tile
     */
    public void drawTile(Graphics g, int x, int y)
    {
        // Define rectangle sides
        int mortar = 1;
        int longSide = width / 2 - mortar * 2;
        int shortSide = longSide / 2 - mortar;

        // Define colors
        Color honey = new Color(255, 201, 14);
        Color clay = new Color(185, 122, 87);

        // Draw mortar background
        g.setColor(Color.lightGray);
        g.fillRect(x, y, width, width);

        // Draw tile with rectangles
        drawRect(g, x + mortar, y + mortar, shortSide, longSide, honey);
        drawRect(g, x + shortSide + mortar * 3, y + mortar, shortSide, longSide, honey);
        drawRect(g, x + mortar * 3 + longSide, y + mortar, longSide, shortSide, clay);
        drawRect(g, x + mortar * 3 + longSide, y + mortar * 3 + shortSide, longSide, shortSide, clay);
        drawRect(g, x + mortar, y + mortar * 3 + longSide, longSide, shortSide, clay);
        drawRect(g, x + mortar, y + mortar * 5 + longSide + shortSide, longSide, shortSide, clay);
        drawRect(g, x + mortar * 3 + longSide, y + mortar * 3 + longSide, shortSide, longSide, honey);
        drawRect(g, x + mortar * 5 + longSide + shortSide, y + mortar * 3 + longSide, shortSide, longSide, honey);
    }
}

/**
 * Draws a Pythagorean tile with mortar
 */
class PythagoreanMortar extends Tile
{
    /**
     * Constructor initializes values
     */
    public PythagoreanMortar()
    {
        width = 50;
        title = "Pythagorean with Mortar";
    }

    /**
     * Draws a tile
     * @param g Graphics object which will be drawn on
     * @param x X coordinate to draw the tile
     * @param y Y coordinate to draw the tile
     */
    public void drawTile(Graphics g, int x, int y)
    {
        // Define measures
        int mortar = 1;
        int longSide = (int) (width * (2 / 5.0)) - mortar * 2;
        int shortSide = longSide / 2 - mortar;

        // Define colors
        Color blue = new Color(64, 64, 192);
        Color aqua = new Color(136, 204, 204);

        // Draw mortar background
        g.setColor(Color.lightGray);
        g.fillRect(x, y, width, width);

        // Draw tile with rectangles
        drawRect(g, x + mortar, y + mortar, longSide, longSide, aqua);
        drawRect(g, x + mortar * 3 + longSide, y + mortar * 3 + shortSide, longSide, longSide, aqua);
        drawRect(g, x + mortar * 3 + longSide, y + mortar, shortSide, shortSide, blue);
        drawRect(g, x - mortar - shortSide, y + mortar * 3 + longSide, longSide, longSide, aqua);
        drawRect(g, x + mortar * 5 + longSide + shortSide, y - mortar - shortSide, longSide, longSide, aqua);
        drawRect(g, x + mortar * 3 + shortSide, y + mortar * 3 + longSide, shortSide, shortSide, blue);
        drawRect(g, x + mortar * 5 + longSide * 2, y + mortar * 3 + shortSide, shortSide, shortSide, blue);
        drawRect(g, x + mortar, y + mortar * 5 + longSide * 2, shortSide, shortSide, blue);
        drawRect(g, x + mortar * 3 + shortSide, y + mortar * 5 + longSide + shortSide, longSide, longSide, aqua);
        drawRect(g, x + mortar * 5 + longSide + shortSide, y + mortar * 5 + shortSide + longSide, shortSide, shortSide, blue);
    }
}


/**
 * Draws an open weave tile with mortar
 */
class OpenWeaveMortar extends Tile
{
    /**
     * Constructor initializes values
     */
    public OpenWeaveMortar()
    {
        this.width = 60;
        title = "Open Weave with Mortar";
    }

    /**
     * Draws a tile
     * @param g Graphics object which will be drawn on
     * @param x X coordinate to draw the tile
     * @param y Y coordinate to draw the tile
     */
    public void drawTile(Graphics g, int x, int y)
    {
        // Define measures
        int mortar = 1;
        int longSide = (int) (width * (2 / 3.0));
        int shortSide = (int) (width * (1 / 3.0)) - mortar * 4;
        int squareSide = (int) (width * (1 / 6.0));

        // Define colors
        Color pink = new Color(204, 136, 204);
        Color maroon = new Color(154, 32, 64);

        // Draw mortar background
        g.setColor(Color.lightGray);
        g.fillRect(x, y, width, width);

        // Draw tile with rectangles
        drawRect(g, x + mortar, y + mortar, longSide, shortSide, pink);
        drawRect(g, x + mortar * 3 + longSide, y - mortar - squareSide, shortSide, longSide, pink);
        drawRect(g, x + mortar, y + mortar * 3 + shortSide, squareSide, squareSide, maroon);
        drawRect(g, x + mortar * 3 + squareSide, y + mortar * 3 + shortSide, shortSide, longSide, pink);
        drawRect(g, x + mortar * 5 + squareSide + shortSide, y + mortar * 3 + shortSide, squareSide, squareSide, maroon);
        drawRect(g, x + mortar, y + mortar * 7 + shortSide * 2 + squareSide, squareSide, squareSide, maroon);
        drawRect(g, x + mortar * 5 + squareSide + shortSide, y + mortar * 7 + shortSide * 2 + squareSide, squareSide, squareSide, maroon);
        drawRect(g, x + mortar * 7 - shortSide - squareSide * 2, y + mortar * 5 + shortSide + squareSide, longSide, shortSide, pink);

    }
}


