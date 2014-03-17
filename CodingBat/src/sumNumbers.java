import sun.jvm.hotspot.utilities.Assert;

/**
 * Created by nate on 3/16/14.
 */
public class sumNumbers {

    public int sumNumbers(String str)
    {
        String currentNumber = "";
        int sum = 0;

        for (int i = 0; i < str.length(); i++)
        {
            char strChar = str.charAt(i);
            if (Character.isDigit(strChar))
            {
                currentNumber += strChar;
            }
            else if (currentNumber.length() > 0)
            {
                sum += Integer.parseInt(currentNumber);
                currentNumber = "";
            }
        }

        if (currentNumber.length() > 0)
        {
            sum += Integer.parseInt(currentNumber);
        }

        return sum;
    }

    public static void main(String[] args)
    {
        int sum = new sumNumbers().sumNumbers("a1234bb11");
        Assert.that(sum == 1245, "number not equal to 1245: " + sum);
    }
}
