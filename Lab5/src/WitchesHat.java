/**
 * This is a witch type hat.
 *
 * @author Nathan Flint
 * @version Lab5: SnowmanIII
 */
public class WitchesHat extends NsccComponent
{
    // The pieces of the top hat
    private NsccComponent brim;
    private NsccComponent pointyTop;

    /**
     * The 'default' constructor for TopHat.
     * This creates a black hat at location (10, 10).
     */
    public WitchesHat() {
        this(10, 10);
    }

    /**
     * A constructor for MyHat. This creates a witch style hat
     * of the 'standard' size, at the specified location.
     *
     * @param x The x-coordinate for the top hat.
     * @param y The y-coordinate for the top hat.
     */
    public WitchesHat(int x, int y) {
        super(x, y, 110, 35);
        // create the pieces of the hat
        brim = new NsccEllipse(0, 25, 110, 10);
        brim.setBackground(java.awt.Color.BLACK);
        brim.setFilled(true);
        pointyTop = new NsccUpTriangle(30, 0, 50, 30);
        pointyTop.setBackground(java.awt.Color.BLACK);
        pointyTop.setFilled(true);
        // add the pieces to the hat
        add(brim);
        this.add(pointyTop);
    }
}
