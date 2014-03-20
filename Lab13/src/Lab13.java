import java.awt.*;

/**
 * This class draws the shapes required by lab 13: A traffic light and some nested shapes
 *
 * @author Nathan Flint
 * @version Lab13: DrawingPanel
 *
 * Grading Level: Plus
 *
 */
public class Lab13
{
    // Creates a window and draws a traffic light inside it
    private void DrawTrafficLight()
    {
        // Instantiates a Drawing panel
        DrawingPanel panel = new DrawingPanel(130, 290);
        panel.setTitle("Traffic Light");

        // Get graphics from panel
        Graphics draw = panel.getGraphics();

        // Draw light housing
        drawRect(draw, 20, 20, 90, 250, Color.lightGray);

        // Draw red light
        drawCircle(draw, 30, 30, 70, Color.red );

        // Draw yellow light
        drawCircle(draw, 30, 110, 70, Color.yellow );

        // Draw green light
        drawCircle(draw, 30, 190, 70, new Color(0, 127, 0) );
    }

    private void drawRect(Graphics g, int x, int y, int width, int height, Color backgroundColor)
    {
        //draw filled rectangle
        g.setColor(backgroundColor);
        g.fillRect(x, y, width, height);

        // draw outline
        g.setColor(Color.black);
        g.drawRect(x, y, width - 1, height - 1);
    }

    private void drawCircle(Graphics g, int x, int y, int diameter, Color backgroundColor)
    {
        // Correct the diameter to account for drawing artifacts
        int correctedDiameter = diameter - 1;

        // draw circle background
        g.setColor(backgroundColor);
        g.fillOval(x, y, correctedDiameter, correctedDiameter);

        // draw outline
        g.setColor(Color.black);
        g.drawOval(x, y, correctedDiameter, correctedDiameter);

    }

    // Draws nested shapes from the lab
    private void drawNestedShapes()
    {
        // Instantiates a Drawing panel
        DrawingPanel panel = new DrawingPanel(250, 250);
        panel.setTitle("Nested Shapes");

        // Get graphics from panel
        Graphics draw = panel.getGraphics();

        // Draw green square
        drawRect(draw, 25, 25, 200, 200, Color.green);

        // Draw cyan circle
        drawCircle(draw, 25, 25, 200, Color.magenta);

        // Draw cyan diamond
        draw.setColor(Color.cyan);
        draw.fillPolygon(new int[] {125, 224, 124, 25}, new int[] {25, 124, 224, 125 }, 4 );

        // Draw outline around diamond
        draw.setColor(Color.black);
        draw.drawPolygon(new int[] {125, 224, 124, 25}, new int[] {25, 124, 224, 125 }, 4 );
    }

    /**
     * Application method
     * @param args Command line arguments
     */
    public static void main(String[] args)
    {
        // Instantiate the lab, and call the draw functions
        Lab13 lab = new Lab13();
        lab.DrawTrafficLight();
        lab.drawNestedShapes();

    }
}
