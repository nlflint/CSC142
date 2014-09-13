import java.awt.*;
import java.util.HashSet;

/**
 * Created by nathanf on 4/2/14.
 */
public class PythagoreanTree
{
    private int mortarWidth;
    private HashSet<String> shapeTracker;
    private DrawingPanel panel;
    private Graphics draw;

    private final int WIDTH = 121;
    private final int HEIGHT = 786;

    private int longWidth;
    private int shortWidth;

    private final Color aqua = new Color(136, 204, 204);
    private final Color blue = new Color(64, 64, 192);


    public PythagoreanTree(int mortarWidth, int baseWidth)
    {
        this.mortarWidth = mortarWidth;
        longWidth = baseWidth * 2;
        shortWidth = baseWidth;
        shapeTracker = new HashSet<String>();

        panel = new DrawingPanel(WIDTH,HEIGHT);
        draw = panel.getGraphics();
        draw.setColor(Color.lightGray);
        draw.fillRect(0,0,WIDTH,HEIGHT);
        DrawSquare(new Point(0,0), true);
        panel.repaint();
    }

    private void DrawSquare(Point upperLeftCorner, boolean drawBigSquare)
    {
        int width = drawBigSquare ? longWidth : shortWidth;

        if (squareOutSideWindowBoundary(upperLeftCorner, width))
            return;

        String signature = upperLeftCorner.toString();
        if (shapeTracker.contains(signature))
            return;

        Color color = drawBigSquare ? aqua : blue;
        drawRect(upperLeftCorner, width, color);
        shapeTracker.add(signature);

        int x = upperLeftCorner.x;
        int y = upperLeftCorner.y;
        int multiplyDirection = drawBigSquare ? 1 : -1;
        int longWithMortar = (mortarWidth + longWidth) * multiplyDirection;
        int shortWithMortar = (shortWidth + mortarWidth) * multiplyDirection;
        int shortOnly = shortWidth * multiplyDirection;

        DrawSquare(new Point(x + longWithMortar, y), !drawBigSquare);
        DrawSquare(new Point(x + shortOnly, y + longWithMortar), !drawBigSquare);
        DrawSquare(new Point(x - shortWithMortar, y + shortOnly), !drawBigSquare);
        DrawSquare(new Point(x, y - shortWithMortar), !drawBigSquare);
    }

    private boolean squareOutSideWindowBoundary(Point upperLeftCorner, int width) {
        int x = upperLeftCorner.x;
        int y = upperLeftCorner.y;

        if (x < 0 - width)
            return true;
        if (x > WIDTH + width)
            return true;
        if (y < 0 - width)
            return true;
        if (y > HEIGHT + width)
            return true;

        return false;
    }

    private void drawRect(Point upperLeftCorner, int width, Color c) {
        int x = upperLeftCorner.x;
        int y = upperLeftCorner.y;

        // the colored rect
        draw.setColor(c);
        draw.fillRect(x, y, width, width);

        // Draw lines around the rect
        draw.setColor(Color.black);
        draw.drawRect(x, y, width, width);

        try {
            panel.repaint();
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
