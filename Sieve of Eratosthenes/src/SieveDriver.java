import java.util.Iterator;
import java.util.Scanner;

/**
 * Coordinates the calculation and printing of prime numbers.
 *
 * @author Nathan Flint
 * @version Assignment 9: Sieve of Eratosthenes
 *
 * Grading Level: Standard
 */
public class SieveDriver {

    // Reads keyboard input
    private java.util.Scanner scan;

    // My implementation of the the sieve algorithm
    private Sieve theSieve;


    /**
     * Constructor. Prepares for execution.
     */
    public SieveDriver()
    {
        // Instantiate private fields
       scan = new Scanner(System.in);
       theSieve = new MySieve();
    }

    /**
    * Coordinates the calculation of prime numbers.
    */
    public void go() {
       // variable to hold primes
       java.util.List<Integer> primes;

       // get initial input
       int n = getNumber();

       // Rerun program until user enters zero.
       while (n > 0)
       {
           // Calculate primes
           primes = theSieve.getPrimes(n);

           // print primes
           printPrimes(n, primes);

           // Ask for input again
           n = getNumber();
       }

       // Print exit message
       System.out.print("Exiting.");
    }

    /**
     * Asks for positive integer input from the user.
     * @return a positive integer
     */
    public int getNumber()
    {
       // declare input value
       int inputValue = 0;

       // prompt user for a number
       printPrompt();

       // wait for input.
       while (scan.hasNext())
       {
           // Check if input was an int
           if (scan.hasNextInt())
           {
               // Get the int.
               inputValue = scan.nextInt();

               //make sure it's positive.
               if (inputValue >= 0)
                   break;
           }
           else
           {
               // take the non-int off the scanner.
               scan.next();
           }

           // Input was invalid. print error.
           System.out.println("Input must be positive.");
           printPrompt();
       }
       return inputValue;
    }

    // Prints text to prompt user for a number.
    private void printPrompt()
    {
       System.out.print("\nEnter the upper bound (0 to exit): ");
    }

    public void printPrimes(int bound, java.util.List<Integer> list) {
        System.out.printf("Here are the primes between 2 and %d\n", bound);

        // Setup and iterator and counter for the loop
        Iterator<Integer> iterator = list.iterator();
        int numberPrimes = 0;

        // Loop through list of primes
        while (iterator.hasNext())
        {
            // check to see if current number is at the end of the row.
            if (++numberPrimes % 12 != 0)
            {
                // Not at end of the row. Just print it.
                System.out.print(iterator.next() + " ");
            }
            else
            {
                // number is at the end of the line. print number and print line.
                System.out.println(iterator.next());
            }
        }

        System.out.println();

         // print ratio of primes found
         printRatioPrimes(list.size(), bound);
    }

    // Prints ratio of primes found to total primes searched
    private void printRatioPrimes(int primesFound, int primeCanidates)
    {
        int percent = 100 * primesFound / primeCanidates;
        System.out.printf("%d%% of the numbers between 1 and %s are prime.\n",percent, primeCanidates );
    }

    /**
     * The application method
     * @param args command line arguments
     */
    public static void main(String[] args) {

        // Starts the program.
        new SieveDriver().go();

    }

}