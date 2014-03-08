import java.text.NumberFormat;

/**
 * This class adds number from the command line and shows the addition process.
 *
 * @author Nathan Flint
 * @version Assignment 8: Addition
 *
 * Grading Level: Challenge
 */
public class Addition
{
    // the raw command line arguments
    private String[] commandLineArguments;

    // Running total of the numbers
    private int runningTotal;

    // Collection of valid arguments
    private int[] validArgs;
    private int numberOfValidArgs;

    // Collection of invalid arguments
    private String[] invalidArgs;
    private int numberOfInvalidArgs;

    /**
     * Application method for addition program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        // see if any arguments were provided.
        if (args.length < 1)
        {
            System.out.println("No Arguments provided.");
            return;
        }

        // Initialize addition class.
        Addition add = new Addition(args);

        // Validate arguments and store results for later use
        add.ProcessArguments();

        // Do addition and print results
        add.ShowAdditionOfNumbers();

        // Show validation errors if there are any
        add.printValidationFailures();
    }

    /**
     * Constructor validates args are prepares the class for running.
     *
     * @param args Command line arguments
     */
    public Addition(String[] args)
    {
        // Store raw command line arguments.
        commandLineArguments = args;

        // Initialize array for valid arguments
        validArgs = new int[args.length];
        numberOfValidArgs = 0;

        // Initialize array for invalid arguments
        invalidArgs = new String[args.length];
        numberOfInvalidArgs = 0;

        // Initialize running total
        runningTotal = 0;
    }

    /**
     * Separates and stores valid and invalid arguments.
     */
    public void ProcessArguments()
    {
        // Loop throught command line aguments
        for (int i = 0; i < commandLineArguments.length; i++)
        {
            // use cleaner looking variable to store current argument
            String argument = commandLineArguments[i];

            // Test if the argument is valid or not.
            if (isValid(argument))
            {
                // Remove formatting from argument
                int numberValue = stripFormatting(argument);
                // store value in valid args array
                validArgs[numberOfValidArgs++] = numberValue;
            }
            else
            {
                invalidArgs[numberOfInvalidArgs++] = argument;
            }
        }
    }

    // Validates if argument is valid argument. Commas are optional, but if used, then they must be used correctly.
    private boolean isValid(String argument)
    {
        // split argument by commas, each section is a group.
        // There will be only 1 grouping if commas aren't used.
        String[] groups = argument.split(",");

        // there should always be one more group than there are commas.
        // this check catches a few weird errors, like a lone comma at the end.
        if (groups.length != numberOfCommas(argument) + 1)
            return false;

        // make the first group an easy to read variable. It's a special case.
        String firstGrouping = groups[0];

        // remove optional '-' from first grouping
        if (firstGrouping.length() > 0 && firstGrouping.charAt(0) == '-')
            firstGrouping = firstGrouping.subSequence(1, firstGrouping.length()).toString();

        // if there are commas in the argument, then the first grouping must not have have length > 3
        if (argument.contains(",") && firstGrouping.length() > 3)
            return false;

        // validate first (or only) grouping.
        if (! firstGroupingIsValid(firstGrouping))
            return false;

        // Loop through and validate remaining groups with stricter validation.
        for (int i = 1; i < groups.length; i++)
        {
            // make sure grouping is valid
            if (! groupIsValid(groups[i]))
                // Something was invalid
                return false;

        }

        // everything looks good.
        return true;
    }

    // Gets the count of commas in the argument
    private int numberOfCommas(String argument)
    {
        int commaCount = 0;
        for (int i = 0; i < argument.length(); i++)
            if (argument.charAt(i) == ',')
                commaCount++;
        return  commaCount;
    }

    // Validates the first or only grouping in a number
    private boolean firstGroupingIsValid(String firstGrouping)
    {
        // first grouping will allow numbers without commas. Length over 10 is too great for integers.
        if (firstGrouping.length() > 10 || firstGrouping.length() < 1)
            return false;

        // Loop through characters, validating they are numbers
        for (int i = 0; i < firstGrouping.length(); i++ )
        {
            // Make variable easier to read
            char currentChar = firstGrouping.charAt(i);

            // check if character is a digit
            if (Character.isDigit(currentChar))
                continue;
            else
                return false;
        }

        // everything looks good.
        return true;
    }

    // Validates a grouping between commas in number.
    private boolean groupIsValid(String group)
    {
        // group must have length 3
        if (group.length() != 3)
            return false;

        // each character must be a digit.
        if (Character.isDigit(group.charAt(0)) &&
            Character.isDigit(group.charAt(1)) &&
            Character.isDigit(group.charAt(2)))
        {
            // everything looks good.
            return true;
        }

        // one character is not a digit.
        return false;

    }

    // Strips formatting from the argument. Assumes formatting is valid.
    private int stripFormatting(String argument)
    {
        // Remove commas
        String commasRemoved = argument.replace(",","");

        // convert argument to integer and return.
        return Integer.parseInt(commasRemoved);
    }

    /**
     * Prints the sum of the given arguments. Ignores invalid numbers.
     */
    public void ShowAdditionOfNumbers()
    {
        // See if there are any good results to print
        if (validArgs.length < 1)
        {
            // No good results so exit
            return;
        }

        // create an easy to read variable for the first argument
        final int firstNumber = validArgs[0];

        // Add first argument to running total
        runningTotal += firstNumber;

        // Print the first argument, first fencepost
        printInitialNumber(firstNumber);

        // Loop through remaining arguments and print them
        for (int i = 1; i < numberOfValidArgs; i++)
        {
            // Create an easy to read variable
            int currentNumber = validArgs[i];

            // Add number to running total
            runningTotal += currentNumber;

            // Print number
            printNumber(currentNumber);
        }

        // Prints the sum.
        printTotal();
    }

    /**
     * Prints invalid arguments found during validation.
     */
    public void printValidationFailures()
    {
        if (numberOfInvalidArgs > 0)
        {
            System.out.print("Ignored arguments: ");
            for (int i = 0; i < numberOfInvalidArgs; i++)
                System.out.printf("%s ", invalidArgs[i]);
        }
    }

    // Prints first number. This is a front end fence post.
    private void printInitialNumber(int number)
    {
        String formattedNumber = format(number);
        System.out.printf("%s ", formattedNumber);
    }

    // Adds commas to an integer and gives a string.
    private String format(int number)
    {
        // Use number formatter to add commas based on US culture.
        return NumberFormat.getNumberInstance(java.util.Locale.US).format(number);
    }

    // Prints number with a sign.
    private void printNumber(int number)
    {
        // Set a plus or minus sign.
        String sign;
        if (number < 0)
        {
            sign = "-";
        }
        else
        {
            sign = "+";
        }

        // Set number to absolute
        int numberWithoutSign = Math.abs(number);

        // Add commas to number
        String formattedNumber = format(numberWithoutSign);

        // Print number with sign.
        System.out.printf("%s %s ",sign, formattedNumber);
    }

    // prints the end of the equation. This is an ending fencepost.
    private void printTotal()
    {
        // add commas to the number
        String formattedNumber = format(runningTotal);

        // print the number with equals sign.
        System.out.printf("= %s\n", formattedNumber);
    }
}
