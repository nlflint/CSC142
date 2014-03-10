import java.util.ArrayList;
import java.util.Iterator;

/**
 * This is the starting point code for Lab 12.
 */
public class Reindeer {

    // The reindeer
    private java.util.Collection<String> reindeer;

    /**
     * Constructor, which you will write
     */
    public Reindeer()
    {
        reindeer = new ArrayList<String>();
    }

    /**
     * Add the names of the reindeer to the collection.
     */
    public void addReindeer() {
        reindeer.add("Dasher");
        reindeer.add("Dancer");
        reindeer.add("Prancer");
        reindeer.add("Vixen");
        reindeer.add("Comet");
        reindeer.add("Cupid");
        reindeer.add("Dunder");
        reindeer.add("Blixem");
    }

    /**
     * A simple method to print out the contents of
     * the collection.
     */
    public void print()
    {
        Iterator<String> reindeerIterator = reindeer.iterator();

        while(reindeerIterator.hasNext())
            System.out.print(reindeerIterator.next() + " ");

        System.out.println();
    }

    /**
     * The application method, which you will write
     * @param args Command-line arguments
     */
    public static void main(String[] args)
    {
        Reindeer app = new Reindeer();
        app.addReindeer();
        app.print();
        app.reindeer = new java.util.LinkedList<String>();
        app.addReindeer();
        app.print();
        app.addReindeer();
        app.print();
        app.reindeer = new java.util.HashSet();
        app.addReindeer();
        app.print();
        app.addReindeer();
        app.print();
    }

}