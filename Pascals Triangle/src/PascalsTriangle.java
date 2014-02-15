import java.util.Scanner;

/**
 * This class overrides the base class for printing pascal's triangle.
 * It implements pascal triangles up to a height of 15.
 *
 * @author Nathan Flint
 * @version Assignment 6: Pascal's Triangle, Implementation
 *
 * Grading level: Challenge
 */
public class PascalsTriangle extends PascalsTriangleBase
{
    public static void main(String[] args)
    {
        // Instantiate my pascalTriangle implementation
        PascalsTriangle triangle = new PascalsTriangle();

        // print several triangles using assigned heights
        triangle.printTriangle(0);
        triangle.printTriangle(10);
        triangle.printTriangle(3);
        triangle.printTriangle(7);

        // Print input prompt
        String prompt = "\nEnter height of next pascal triangle: ";
        System.out.print(prompt);

        // Create scanner
        Scanner scan = new Scanner(System.in);

        // Loop continuously gathering input
        while (scan.hasNext())
        {
            // make sure input is a number
            if (scan.hasNextInt())
            {
                // print the custom triangle
                triangle.printTriangle(scan.nextInt());

                // exit loop and end program
                break;
            }

            // input is not a number so:
            // print error
            // remove input from buffer
            // prompt for another input
            System.out.println("Invalid entry, height must be a number: " + scan.next());
            System.out.print(prompt);
        }
    }

    // Constructor
    public PascalsTriangle()
    {
        // enable double spacing
        doubleSpace = true;
    }

    // Overriding method from base class
    protected void printInt(int n) {
        // prints number with minimum length of 6
        System.out.printf("%-6d", n);
    }

    // Overriding method from base class.
    // Adds appropriate padding and prints 1 as the first digit for each row.
    protected void printOne(int row, int height) {
        // identify last row
        int lastRow = height;

        // add padding unless it's the last row
        if (row != lastRow)
        {
            // Calculates amount of padding needed
            int paddingAmount = (height - row) * 3 ;

            // print padding
            System.out.printf("%" + paddingAmount + "s", "");
        }

        // print first number for the row, a one.
        printInt(1);
    }

    // Overriding method from base class.
    // Validates that height is positive and less than or equal to 15
    protected boolean heightOutOfRange(int height) {
        return height < 0 || height > 15;
    }

    // Overriding method from base class.
    // Gets a coefficient from pascals triangle.
    // N is row of triangle, K is column.
    protected int nChooseK(int n, int k) {
        // creates factors for n!
        int[] numeratorFactors = createFactorialFactors(n);

        // creates factors for k! and (n-k)!
        int[] denominatorFactors = createDemoninatorFactors(n, k);

        // cancels factors shared between numerator and denominator
        cancelCommonFactors(numeratorFactors, denominatorFactors);

        // multiple numerators
        int numerator = multiplyFactors(numeratorFactors);

        //multiple denominators
        int denominator = multiplyFactors(denominatorFactors);

        // return coefficient
        return numerator / denominator;
    }

    // creates an array with the factors of a factorial
    private int[] createFactorialFactors(int factorial)
    {
        // initialize an array for all factors
        int[] factors = new int[factorial];

        // add each factor to the array
        for (int factor = 1; factor <= factorial; factor++)
        {
            // assign factor to array
            factors[factor - 1] = factor;
        }

        // return array
        return factors;
    }

    // Creates two sets of factorial factors, and puts them together for the denominator.
    private int[] createDemoninatorFactors(int n, int k)
    {
        // create first set of factors from the denominator
        int[] leftFactors = createFactorialFactors(k);

        // create second set of factors from the denominator
        int[] rightFactors = createFactorialFactors(n - k);

        // join left and right factors and return them all
        return concatArrays(leftFactors, rightFactors);
    }

    // Creates a new array with contents of both given arrays
    private int[] concatArrays(int[] arrayOne, int[] arrayTwo)
    {
        // Initialize final array that will contain all elements from both arrays
        int[] finalArray = new int[arrayOne.length + arrayTwo.length];

        // Copy first array into final array
        System.arraycopy(arrayOne, 0, finalArray, 0, arrayOne.length);

        // Copy second array into final array but don't overwrite first array elements.
        System.arraycopy(arrayTwo, 0, finalArray, arrayOne.length , arrayTwo.length);

        // return concatenated array
        return finalArray;
    }

    // Cancels out factors that match between arrays
    private void cancelCommonFactors(int[] numeratorFactors, int[] denominatorFactors )
    {
        // Cycles through numerator array
        for (int numeratorIndex = 0; numeratorIndex < numeratorFactors.length; numeratorIndex++)
        {
            // Look for a match in denominator and try to cancel it
            if (tryToCancelFactor(denominatorFactors, numeratorFactors[numeratorIndex]))
            {
                // match was found and canceled in denominator.
                // so cancel factor from numerators too.
                cancelFactor(numeratorFactors, numeratorIndex);
            }
        }
    }

    // Looks for matches and then cancels them if found.
    // returns true if match found and canceled, false if no match found.
    private boolean tryToCancelFactor(int[] factors, int cancelingFactor)
    {
        // Cycle through elements
        for (int index = 0; index < factors.length; index++)
        {
            // Compare array element to factor we want to cancel
            if (factors[index] == cancelingFactor)
            {
                // cancel factor
                cancelFactor(factors, index);

                // Only cancel the first match, so return now.
                return true;
            }
        }

        // no match found
        return false;
    }

    // Cancels out factor by setting it to 1.
    // Factors will be multiplied later so setting to 1 is same as canceling.
    private void cancelFactor(int[] factors, int indexToCancel)
    {
        factors[indexToCancel] = 1;
    }

    // Multiplies array elements and returns product
    private int multiplyFactors(int[] factors)
    {
        // initialize final answer
        int finalProduct = 1;

        // Loop through array
        for (int index = 0; index < factors.length; index++)
        {
            // multiply factor with final product
            finalProduct *= factors[index];
        }

        // return product of array elements
        return finalProduct;
    }
}
