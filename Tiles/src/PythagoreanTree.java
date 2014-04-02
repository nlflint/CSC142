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

    private final int WIDTH = 500;
    private final int HEIGHT = 500;

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
        DrawSquare(0, 0, true);
        panel.repaint();
    }

    private void DrawSquare(int x, int y, boolean drawBigSquare)
    {
        int width = drawBigSquare ? longWidth : shortWidth;

        if (x < 0 - width)
            return;
        if (x > WIDTH + width)
            return;
        if (y < 0 - width)
            return;
        if (y > HEIGHT + width)
            return;

        String signature = String.format("%d,%d", x, y);
        if (shapeTracker.contains(signature))
            return;

        Color color = drawBigSquare ? aqua : blue;
        drawRect(x, y, width, width, color);
        shapeTracker.add(signature); 

        int multiplyDirection = drawBigSquare ? 1 : -1;
        int longWithMortar = (mortarWidth + longWidth) * multiplyDirection;
        int shortWithMortar = (shortWidth + mortarWidth) * multiplyDirection;
        int shortOnly = shortWidth * multiplyDirection;

        DrawSquare(x + longWithMortar, y, !drawBigSquare);
        DrawSquare(x + shortOnly, y + longWithMortar, !drawBigSquare);
        DrawSquare(x - shortWithMortar, y + shortOnly, !drawBigSquare);
        DrawSquare(x, y - shortWithMortar, !drawBigSquare);
    }

    private void drawRect(int x, int y, int width, int height, Color c) {
        // the colored rect
        draw.setColor(c);
        draw.fillRect(x, y, width, height);

        // Draw lines around the rect
        draw.setColor(Color.black);
        draw.drawRect(x, y, width, height);

        try {
            panel.repaint();
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
