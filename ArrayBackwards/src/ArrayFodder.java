/**
 * Created by nathanf on 2/18/14.
 */
public class ArrayFodder
{
    public static void main(String[] args)
    {
        int[] numbers = { 7, 3, 5, -2, 8, 4 };

        int idx = 0;
        while(idx < numbers.length) {
            System.out.println(numbers[idx]);
            idx++;
        }

        System.out.println("\nNow printing backwards");

        int[] numbers = { 7, 3, 5, -2, 8, 4 };

        idx = numbers.length - 1;
        while(idx > -1)
        {
            System.out.println(numbers[idx]);
            idx--;
        }


    }
}
