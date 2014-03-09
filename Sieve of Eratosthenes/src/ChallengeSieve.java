import java.util.ArrayList;
import java.util.List;

/**
 * Created by nate on 3/8/14.
 */
public class ChallengeSieve
{
    private List<Integer> ArrayListWithGetter(int bound)
    {
        // populate arrays
        List<Integer> primeCanidates = new ArrayList();
        List<Integer> primes = new ArrayList();


        while (primeCanidates.size() > 0)
        {
            int number = primeCanidates.remove(0);
            primes.add(number);
            if (number <= Math.sqrt(n))
                removeMultiplesOf(number);
        }

        return primes;
    }

    private List<Integer> ArrayListWithIterator(int bound)
    {
        return null;
    }

    private List<Integer> LinkedListWithGetter(int bound)
    {
        return null;
    }

    private List<Integer> LinkedListWithIterator(int bound)
    {
        return null;
    }

    public void runTests(int bound, int expectedPrimes)
    {
        List<Integer> answer;

        // Test ArraryList with getter
        long start = System.nanoTime();
        answer = ArrayListWithGetter(bound);
        long end = System.nanoTime();
        long elapsed = (end - start) / 1000000;
        // check accuracy
        if(answer.size() == expectedPrimes) {
            printElapsedTime("ArrayList with getter", bound, elapsed);
        } else {
            printError("ArrayList with getter");
        }

        // Test ArraryList with iterator
        start = System.nanoTime();
        answer = ArrayListWithIterator(bound);
        end = System.nanoTime();
        elapsed = (end - start) / 1000000;
        // check accuracy
        if(answer.size() == expectedPrimes) {
            printElapsedTime("ArrayList with iterator", bound, elapsed);
        } else {
            printError("ArrayList with iterator");
        }

        // Test linkedList with getter
        start = System.nanoTime();
        answer = LinkedListWithGetter(bound);
        end = System.nanoTime();
        elapsed = (end - start) / 1000000;
        // check accuracy
        if(answer.size() == expectedPrimes) {
            printElapsedTime("linkedList with getter", bound, elapsed);
        } else {
            printError("linkedList with getter");
        }

        // Test linkedList with iterator
        start = System.nanoTime();
        answer = LinkedListWithIterator(bound);
        end = System.nanoTime();
        elapsed = (end - start) / 1000000;
        // check accuracy
        if(answer.size() == expectedPrimes) {
            printElapsedTime("linkedList with iterator", bound, elapsed);
        } else {
            printError("linkedList with iterator");
        }
    }

    private void printElapsedTime(String testType, int bound, long time)
    {
        System.out.printf("%s for %d primes. Ran for %lms\n", testType, bound, time);
    }

    private void printError(String testType)
    {
        System.out.printf("Failure in test: %s\n", testType);
    }

    public static void main(String[] args)
    {
        ChallengeSieve testRunner = new ChallengeSieve();
        testRunner.runTests(10000, 1229);
        testRunner.runTests(20000, 2262);


    }
}
