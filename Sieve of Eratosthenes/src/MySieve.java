import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Calculates prime numbers to N using "Sieve of Eratosthenes" algorithm.
 *
 * @author Nathan Flint
 * @version Assignment 9: Sieve of Eratosthenes
 *
 * Grading Level: Standard
 */
public class MySieve implements Sieve
{
    // list used in the algorithm
    private List<Integer> primeCanidates;
    private List<Integer> primes;


    /**
     * Constructor.
     *
     */
    public MySieve()
    {
        // Instantiate new arrays
        primeCanidates = new ArrayList<Integer>();
        primes = new ArrayList<Integer>();
    }

    /**
     * Calculates and returns a list of primes from 1 to N.
     *
     * @param n Limit when search for primes.
     * @return A list of primes between 1 and n.
     */
    public List<Integer> getPrimes(int n) {
        // fill the arrays with data
        populatePrimeCanidates(n);

        // loop while there are still prime candidates to examine.
        while (primeCanidates.size() > 0)
        {
            // remove the first item in the list.
            int number = primeCanidates.remove(0);

            // it is prime, so add it to the prime list.
            primes.add(number);

            // After we are greater than the sqrt of N, all remaining prime candidates will be prime
            // so don't bother searching for multiples anymore.
            if (number <= Math.sqrt(n))
                // Remove all remaining multiples of this prime.
                removeMultiplesOf(number);
        }

        return primes;
    }

    // Initialized the arrays with numbers
    private void populatePrimeCanidates(int primeLimit)
    {
        // Make sure the lists are clean
        primeCanidates.clear();
        primes.clear();

        // Populate array using loop
        for (int i = 2; i <= primeLimit; i++)
        {
            primeCanidates.add(i);
        }

    }

    // Cycles through the prime candidates and removes multiples of the given number.
    private void removeMultiplesOf(int multiple)
    {
        // Get iterator
        ListIterator<Integer> iterator = primeCanidates.listIterator();

        // Loop while the iterator still has primes in it.
        while (iterator.hasNext())
        {
            // Get a prime candidate
            int number = iterator.next();

            // Check if it is a multiple of the given number
            if (number % multiple == 0)
            {
                // If so, go back one to remove it.
                iterator.previous();
                iterator.remove();
            }
        }
    }
}
