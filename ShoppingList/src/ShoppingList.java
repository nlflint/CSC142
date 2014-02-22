/**
 * Implements a shopping list where items can be added and removed via command line interface.
 *
 * @author Nathan Flint
 * @version Assignment 7: Shopping List
 *
 * Grading Level: Challenge
 */
public class ShoppingList {

    // gets command line input
    private java.util.Scanner scan;

    // items currently in the shopping list
    private String[] shoppingItems;

    // keeps a count of items in the shopping list
    private int shoppingItemsCount;

    /**
     * This is the constructor. It initialized the counter and shopping list array.
     *
     */
    public ShoppingList() {
        scan = new java.util.Scanner(System.in);

        // initialize storage for list items
        shoppingItems = new String[10];

        // initialize counter
        shoppingItemsCount = 0;

        // configure scanner to tokenize on new line, rather than whitespace.
        scan.useDelimiter("\n");
    }

    /**
     * Prints a list of the items on the shopping list.
     */
    public void printList() {
        System.out.println("Your shopping list:");

        if (shoppingItemsCount == 0)
        {
            System.out.println("  * No items on the list.");
            return;
        }

        // print the list
        for (int i = 0; i < shoppingItemsCount; i++)
            System.out.printf("  %d. %s\n", i + 1, shoppingItems[i]);

    }

    /**
     * Add an item to the shopping list.
     *
     * @param item Item to add to the shopping list.
     */
    public void addToList(String item) {
        //Check if list is at its limit
        if (shoppingItemsCount == 10)
        {
            System.out.printf("List is full. Item %s not added to list.\n", item);
            return;
        }

        if (ShoppingListContains(item))
        {
           System.out.printf("Duplicate item %s not added to list.\n", item);
            return;
        }

        if (item.trim().equals(""))
            return;

        // add item to the list
        shoppingItems[shoppingItemsCount++] = item;
    }

    // Checks if the list to see if it contains the given item. Is case sensitive.
    private boolean ShoppingListContains(String item) {
        // Loop through all items in the shopping list
        for (int i = 0; i < shoppingItemsCount; i++)
            // Check for a duplicate
            if (item.equals(shoppingItems[i]))
                // Duplicate found so return true
                return true;

        // Loop completed and nothing was found so return false.
        return false;
    }

    /**
     * Removes all items from the shopping list
     */
    public void emptyList() {
        // empty the list
        shoppingItems = new String[10];
        shoppingItemsCount = 0;
    }

    /**
     * Gets and/or waits for input from the keyboard.
     *
     * @return Text from the keyboard.
     */
    public String getInput() {
        System.out.print("Enter your item or command: ");
        return scan.next().trim();
    }

    /**
     * Prints the welcome message
     */
    public void printWelcome() {
        System.out.println("Welcome to Nate's fantastic Shopping List Program.");
    }

    /**
     * Prints the good buy message
     */
    public void printThankYou() {
        System.out.println("Thank you for using Nate's fantastic Shopping List Program.");
    }

    /**
     * Prints a list of of commands
     */
    public void printHelp() {
        System.out.println("Here are the list of commands:");
        System.out.println("  -p   : Print the list");
        System.out.println("  -e   : Empty the list");
        System.out.println("  -r n : Remove the nth item from the list");
        System.out.println("  -x   : Exit the application");
        System.out.println("  -h   : Print this command list");
    }

    /**
     * Runs the shopping list program by implementing a menu
     * and getting using input.
     */
    public void go() {
        String input;

        printWelcome();
        printHelp();
        input = getInput();
        while( ! input.equals("-x")) {
            switch(input) {
                case "-h":
                    printHelp();
                    break;
                case "-p":
                    printList();
                    break;
                case "-x":
                    break;
                case "-e":
                    emptyList();
                    break;
                default:
                    if (input.startsWith("-r "))
                        removeFromList(input);
                    else if (isUnknownCommand(input))
                        printUnknownCommand(input);
                    else
                        addToList(input);

            }
            input = getInput();
        }
        printThankYou();
    }

    // Removes an item from the list.
    private void removeFromList(String input)
    {
        // Check if there are any items available to remove
        if (shoppingItemsCount < 1)
        {
            System.out.println("Cannot remove items from the list because it is empty.");
            return;
        }

        // Make sure command has minimum length to contain an integer
        if (input.length() < 4)
        {
            printUnknownCommand(input);
            return;
        }

        // remove "-r " from the input
        String trimmedInput = input.substring(3);

        // Declare value that will hold the parsed int
        int itemToRemove;

        // Attempt to parse the integer
        try
        {
            // Parse integer
            itemToRemove = Integer.parseInt(trimmedInput);
        }
        catch (NumberFormatException nfe)
        {
            // There was a problem parsing the integer so show an error and exit method
            System.out.printf("\"%s\" is not a valid integer.\n",trimmedInput);
            return;
        }

        // check if number is within range
        if (itemToRemove < 1 || itemToRemove > shoppingItemsCount)
        {
            // Not within range, so print error
            System.out.printf("Invalid item number. Must be between 1 and %d.\n", shoppingItemsCount);
            return;
        }

        // Check if item to remove is NOT the last item
        if (itemToRemove != shoppingItemsCount)
        {
            // If it's not the last item, then adjustment is required
            for (int i = itemToRemove; i < shoppingItemsCount; i++ )
            {
                // Overwrites the previous item in the array.
                // Happens multiple times to "shift" items up
                shoppingItems[i - 1] = shoppingItems[i];
            }
        }

        // adjust shopping list count
        shoppingItemsCount--;
    }

    // Checks to see if input looks like an command
    private boolean isUnknownCommand(String input) {
        // Check if input begins with "-", like all commands
        if (input.startsWith("-"))
            // Input looks like an unknown command
            return true;

        // input does not look like a command
        return false;
    }

    // notifies users that an invalid command was input, then
    // prints help.
    private void printUnknownCommand(String unknownCommand) {
        System.out.printf("Unrecognized command: %s\n", unknownCommand);
        printHelp();
    }

    /**
     * The application method
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {

        // Start taking user input and run the program.
        new ShoppingList().go();
    }

}