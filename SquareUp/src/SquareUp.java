/**
 * Created by nathanf on 2/28/14.
 */
public class SquareUp
{
    public static int[] squareUp(int n) {
        int[] fullArray = new int[n*n];
        int[] partialArray = new int[n];

        for (int i = 0; i < partialArray.length; i++)
            partialArray[i] = n - i;

        for (int i = n - 1; i < fullArray.length; i += n)
        {
            int groupNumber =  (i + 1) / n;
            int limit = i - groupNumber;
            for (int j = i; j > limit ; j--)
                fullArray[j] = partialArray[j % n];
        }

        return fullArray;
    }

    public static void main(String[] args)
    {
        squareUp(6);

    }
}
