import java.awt.*;

/**
 * Created by nate on 3/22/14.
 */
public interface Tile
{
    public int getWidth();
    public int getHeight();
    public void drawTile(Graphics g, int x, int y);
}
