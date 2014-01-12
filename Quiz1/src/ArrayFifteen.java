/*
Author: Nathan Flint
Assignment: Quiz 1: Basic programming competence
 */

public class ArrayFifteen
{
    /*
    This is the main program function. It builds an array of 15 ints,
    and displays the sum.
     */
    public static void main(String[] args)
    {
        int[] arrayFifteen = new int[15];
        for (int index = 0, value = 1; index < arrayFifteen.length ; index++,value++)
        {
            arrayFifteen[index] = value;
        }

        int sum = SumArray(arrayFifteen);
        System.out.println(sum);
    }

    /*
    This is the helper function sums values that are odd or multiples of three
     */
    private static int SumArray(int[] array)
    {
        int sum = 0;

        for (int index = 0; index < array.length; index++)
        {
            int value = array[index];

            if (IsOdd(value) || IsMultipleOfThree(value))
            {
                sum += value;
            }
        }
        return sum;
    }

    /*
    Helper function that determines if an int is a multiple of three
     */
    private static boolean IsOdd(int number)
    {
        if (number % 2 == 1)
            return true;
        return false;
    }

    /*
    Helper function that determines if an int is a multiple of three
     */
    private static boolean IsMultipleOfThree(int number)
    {
        if (number % 3 == 0)
            return true;
        return false;
    }
}