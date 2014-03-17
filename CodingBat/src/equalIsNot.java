/**
 * Created by nate on 3/16/14.
 */
public class equalIsNot {

    public boolean equalIsNot(String str) {
        int is = numberOf(str, "is");
        int not = numberOf(str, "not");
        return  is == not;
    }

    private int numberOf(String str, String token)
    {
        int matches = 0;
        outer: for (int i = 0; i <= str.length() - token.length(); i++)
        {
            innter: for (int j = 0; j < token.length(); j++)
            {
                char strChar =  str.charAt(i + j);
                char tokenChar =  token.charAt(j);
                if (strChar != tokenChar)
                    continue outer;
            }
            matches++;

        }
        return matches;
    }

    public static void main(String[] args)
    {

        boolean blah = new equalIsNot().equalIsNot("This is not");

    }
}
