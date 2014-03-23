import java.util.HashMap;
import java.util.Map;

/**
 * Gets the word count of given txt files
 *
 * @author Nathan Flint
 * @version Quiz 11: Word Count
 */
public class WordCount {

    /**
     * Gets the word count, given a full filename and path
     * @param fullTxtFilepath full pathname to a txt file
     */
    public static void tokenCount(String fullTxtFilepath) {

        java.util.Scanner scan;

        // open the file for reading using Scanner
        try {
            scan = new java.util.Scanner(new java.io.File(fullTxtFilepath));
        } catch(java.io.FileNotFoundException e) {
            System.err.println("Error opening file: " + fullTxtFilepath);
            return;
        }

        // Map will hold the token counts
        Map<String,Integer> tokens = new HashMap<String,Integer>();

        // process the file, token by token
        int totalTokens = 0;
        while(scan.hasNext()) {
            String token = scan.next().toLowerCase();
            totalTokens ++;

            // Increment token or if it doesn't exist, then add the token.
            if (tokens.containsKey(token))
            {
                int currentTokenCount = tokens.get(token);
                tokens.put(token, ++currentTokenCount);
            }
            else
            {
                tokens.put(token,1);
            }
        }

        // close the file
        scan.close();

        // output overall
        System.out.printf("%s: %d different tokens\n", fullTxtFilepath, totalTokens);

        // Loop throught tokens and print stats for counts > 2
        for (Map.Entry<String, Integer> entry: tokens.entrySet())
            if (entry.getValue() > 2)
                System.out.printf("%4d : %s\n", entry.getValue(), entry.getKey());
        System.out.println();

    }

    /**
     * Application method
     * @param args filenames and paths
     */
    public static void main(String[] args) {

        for(String arg : args) {
            tokenCount(arg);
        }

    }

}