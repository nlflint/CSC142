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

            if ((value % 2 == 1) || (value % 3 == 0))
            {
                sum += value;
            }
        }
        return sum;
    }
}