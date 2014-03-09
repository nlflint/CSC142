import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Calculates prime numbers to N using "Sieve of Eratosthenes" algorithm.
 *
 * @author Nathan Flint
 * @version Assignment 9: Sieve of Eratosthenes
 *
 * Grading Level: Challenge
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
        primeCanidates = new ArrayList<Integer>();
        primes = new ArrayList<Integer>();
    }

    /**
     * Calculates and returns a list of primes from 1 to N.
     *
     * @param n Limit to search for primes.
     * @return A list of primes between 1 and n.
     */
    public List<Integer> getPrimes(int n) {
        populatePrimeCanidates(n);

        while (primeCanidates.size() > 0)
        {
            int number = primeCanidates.remove(0);
            primes.add(number);
            if (number <= Math.sqrt(n))
                removeMultiplesOf(number);
        }

        return primes;
    }

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

    private void removeMultiplesOf(int multiple)
    {
        ListIterator<Integer> iterator = primeCanidates.listIterator();

        while (iterator.hasNext())
        {
            int number = iterator.next();
            if (number % multiple == 0)
            {
                iterator.previous();
                iterator.remove();
            }
        }
    }
}
