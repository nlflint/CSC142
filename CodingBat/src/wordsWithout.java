import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nate on 3/16/14.
 */
public class wordsWithout {
    public String[] wordsWithout(String[] words, String target) {
        List<String> wordsList = makeList(words);
        Iterator<String> it = wordsList.listIterator();

        while (it.hasNext())
        {
            String word = it.next();
            if (word.equals(target))
                it.remove();
        }
        String[] array = new String[wordsList.size()];
        return wordsList.toArray(array);
    }

    public static void main(String[] args)
    {
        wordsWithout ww = new wordsWithout();
        String[] blah = ww.wordsWithout(new String[] {"a","b","c","a"}, "a");

    }

    private List<String> makeList(String[] array)
    {
        List<String> list = new ArrayList<String>();
        list.addAll(Arrays.asList(array));
        return list;
    }
}
