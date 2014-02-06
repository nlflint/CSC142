/**
 * This class contains some methods that count to 205, by 17s.
 * The methods differ by type of loop. There are methods for these
 * loop types: for, while, and do.
 *
 * @author Nathan Flint
 * @version Lab6: Loops
 *
 * Grading Level: Plus
 */
public class CountingWithLoops {

    /**
     * Prints numbers 1 to 205, by 17s, using a for loop.
     */
    public void CountWithForLoop()
    {
        // Title before the numbers
        System.out.println("Using a for loop:");

        // For loop counts to 188, one iteration before 205.
        for (int count = 1; count < 188 ; count+=17)
        {
            //Print out the number and a comma after. No carriage return.
            System.out.print(count + ", ");
        }

        // Append "205." and two carriage returns to the output. This is an ending fencepost.
        System.out.print("205.\n\n");
    }

    /**
     * Prints numbers 1 to 205, by 17s, using a while loop.
     */
    public void CountWithWhileLoop()
    {
        // Title before the numbers
        System.out.println("Using a while loop:");

        // Initialize the variable for counting
        int count = 1;

        // While loop counts to 188, one iteration before the required 205.
        while (count < 188)
        {
            System.out.print(count + ", ");
            count += 17;
        }

        // Append "205." and two carriage returns to the output. This is an ending fencepost.
        System.out.print("205.\n\n");
    }

    /**
     * Prints numbers 1 to 205, by 17s, using a do loop.
     */
    public void CountWithDoLoop()
    {
        // Title before the numbers
        System.out.println("Using a do loop:");

        // Initialize the variable for counting
        int count = 1;

        // Do loop counts to 188, one iteration before the required 205.
        do
        {
            // Output the number and a comma, no carriage return
            System.out.print(count + ", ");

            // Increment the counter
            count += 17;

        } while (count < 188);

        // Append "205." and two carriage returns to the output. This is an ending fencepost.
        System.out.print("205.\n\n");
    }
}
