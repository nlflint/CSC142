/**
 * Created by nate on 2/6/14.
 */
public class Application
{
    public static void main(String[] args)
    {
        System.out.println("DoLoop\n");
        DoLoop();

        System.out.println("\nForLoop:\n");
        ForLoop();

        System.out.println("\nWhileLoop:\n");
        WhileLoop();



    }

    public static void DoLoop()
    {
        int k = 0;
        do {
            System.out.print (k);
            k ++;
        } while(k < 5);
    }

    public static void ForLoop()
    {
        for(int k = 0; k < 5; k++) {
            System.out.println(k);
        }
    }

    public static void WhileLoop()
    {
        int k = 0;
        while(k < 5) {
            System.out.print (k);
            k ++;
        }
    }
}
