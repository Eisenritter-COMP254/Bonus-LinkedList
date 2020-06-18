package LinkedList;

import java.util.Random;
import java.util.Scanner;

// Prompt Test
public class LinkedListTest {
    public static void main(String[] args) throws Exceptions {
        Scanner s = new Scanner(System.in);
        System.out.print("Do you want to run the default test? Enter Y or N ");
        char result = s.nextLine().toUpperCase().charAt(0);
        boolean resultValid = false;
        boolean endOp = false;
        while (!resultValid) {
            switch (result) {
                case 'Y':
                    resultValid = true;
                    Test1();
                    break;
                case 'N':
                    resultValid = true;
                    System.out.println("What is the name of your linked list? ");
                    String listName =  s.nextLine();
                    LinkedList newList =  new LinkedList(listName);
                    while (!endOp){
                        DisplayListOperationMenu(newList);
                        String choice = s.next();
                        switch (choice){
                            case "1":
                                System.out.print("Please enter data: ");
                                newList.Prepend(s.next());
                                break;
                            case "2":
                                System.out.print("Please enter data: ");
                                newList.Postpend(s.next());
                                break;
                            case "3":
                                newList.RemoveFromFront();
                                break;
                            case "4":
                                newList.RemoveFromBack();
                                break;
                            case "5":
                                System.out.print("Please enter data for node you want to search for: ");
                                var value =s.next();
                                Node node = newList.SearchNode(value);
                                if(node==null){
                                    System.out.println("The Node is not found in the list");
                                }
                                else {
                                    System.out.println("The Node is found at" + node+", " +
                                            ""+"The value is: " + node.getData());
                                }
                                break;
                            default:
                                endOp = true;
                                break;
                        }
                    }
                    break;
                default:
                    resultValid = false;
                    System.out.println("Please enter a valid response.");
                    System.out.print("Do you want to run the default test? Enter Y or N ");
                    result = s.next().toUpperCase().charAt(0);
            }
        }

    }

    // Displays List Operation Menu
    public static void DisplayListOperationMenu(LinkedList list){
        list.Display();
        System.out.println("1. Add an element to front of list.");
        System.out.println("2. Add an element to end of list.");
        System.out.println("3. Remove an element from front of list.");
        System.out.println("4. Remove an element from back of list.");
        System.out.println("5. Search for a node.");
        System.out.println("Anything else to stop list operations");
    }

    // Default Test 1
    public static void Test1() {
        // Creates Linked Lists and name them
        LinkedList intList = new LinkedList("Integer List");
        LinkedList dblList = new LinkedList("Double List");

        // Generate randomized array
        int[] intArray = GenerateIntArray(10);
        double[] dblArray = GenerateDblArray(10, 100, 2);

        // Insert generate value into end of list (Stack)
        for (int e : intArray) {
            intList.Postpend(e);
            System.out.println(e + " Added to the end of list");
        }
        intList.Display();

        System.out.println("");
        // Insert generated value into beginning of list (Queue)
        for (double e : dblArray) {
            dblList.Prepend(e);
            System.out.println(e + " Added to the front of list");
        }
        dblList.Display();
    }

    // Generates Random Int Array
    private static int[] GenerateIntArray(int length) {
        Random rnd = new Random();
        int[] rndArray = new int[length];
        for (int i = 0; i < rndArray.length; ++i) {
            rndArray[i] = rnd.nextInt(10);
        }
        return rndArray;
    }

    ///Generate Random Double Array
    private static double[] GenerateDblArray(int length, int magnitude, int dec) {
        Random rnd = new Random();
        double[] rndArray = new double[length];
        for (int i = 0; i < rndArray.length; ++i) {
            rndArray[i] = Math.round(rnd.nextDouble() * magnitude * Math.pow(10, dec)) / (magnitude * Math.pow(10, dec)); // Round the value
        }
        return rndArray;
    }
}
