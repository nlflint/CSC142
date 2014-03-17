import java.util.*;

/**
 * Created by nate on 3/16/14.
 */
public class commonTwo {
    public int commonTwo(String[] a, String[] b) {

        Set<String> set = new HashSet<String>();
        set.addAll(Arrays.asList(a));
        List<String> list = new ArrayList<String>();
        list.addAll(set);
        Collections.sort(list);
        a = list.toArray(new String[1]);

        set.clear();
        set.addAll(Arrays.asList(b));
        list = new ArrayList<String>();
        list.addAll(set);
        Collections.sort(list);
        b = list.toArray(new String[1]);


        int aIndex = 0;
        int bIndex = 0;
        int totalPasses = a.length + b.length - 1;

        int sameCount = 0;

        for (int i = 0; i < totalPasses; i++)
        {
            if (a[aIndex].equals(b[bIndex]))
            {
                sameCount++;
                if (++aIndex == a.length)
                  break;
                if (++bIndex == b.length)
                  break;
                continue;
            }

            if (a[aIndex].compareTo(b[bIndex]) < 0)
            {
                if ((++aIndex) == a.length)
                  break;
            }
            else
            {
                if (++bIndex == b.length)
                  break;
            }
        }
        return sameCount;

    }

    public static void main(String[] args)
    {
        int blah = new commonTwo().commonTwo(
                new String[] {"a", "a", "b", "b", "c"},
                new String[] {"b", "b", "b","x"});
    }

}
