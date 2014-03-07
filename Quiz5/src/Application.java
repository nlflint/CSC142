/**
 * Created by nate on 2/9/14.
 */
public class Application
{
    public static void main(String[] args)
    {
        float number = 3.0f;
        for (int counter = 1; counter < 100; counter++)
        {
            number *= 10.0;
            System.out.println("Float Iteration: " + counter + " Number: " + number);
        }



        double doubleNumber = 3;
        for (int counter = 1; counter < 100; counter++)
        {
            doubleNumber *= 10.0;
            System.out.println("DoublesIteration: " + counter + " Number: " + doubleNumber);
        }

    }
}
