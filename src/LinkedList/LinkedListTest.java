package LinkedList;

import java.util.Random;
import java.util.Scanner;

// Prompt Test
public class LinkedListTest {
    public static void main(String[] args) throws Exceptions {
        Scanner s = new Scanner(System.in);
        DisplayTestChoiceMenu();
        char result = s.nextLine().toUpperCase().charAt(0);
        boolean resultValid = false;

        while (!resultValid) {
            switch (result) {
                case '1':
                    Test1();
                    resultValid = false;
                    break;
                case '2':
                    ListOperationPrompt(GenerateLList(),s);
                    resultValid = true;
                    break;
                case '3':
                    resultValid = true;
                    System.out.println("What is the name of your linked list? ");
                    String listName = s.nextLine();
                    LinkedList newList = new LinkedList(listName);
                    ListOperationPrompt(newList,s);
                    break;
                default:
                    resultValid = false;
                    System.out.println("Please enter a valid response.");
                    DisplayTestChoiceMenu();
                    result = s.next().toUpperCase().charAt(0);
            }
        }
    }

        // List Operation Prompt
        public static void ListOperationPrompt (LinkedList newList, Scanner s) throws Exceptions {
            boolean endOp = false;
            while (!endOp) {
                DisplayListOperationMenu(newList);
                String choice = s.next();
                switch (choice) {
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

                        Node node = newList.SearchNode(s.next());
                        if (node == null) {
                            System.out.println("The Node is not found in the list");
                        } else {
                            System.out.println("The Node is found at" + node + ", " +
                                    "" + "The value is: " + node.getData());
                        }
                        break;
                    case "6":
                        System.out.print("Please enter data for node 1: ");
                        var value1 = s.next();
                        System.out.print("Please enter data for node 2: ");
                        var value2 = s.next();
                        newList.SwapNodes(value1, value2);
                        System.out.println(value1+"'s Final Node Address is: "+newList.SearchNode(value1));
                        System.out.println(value2+"'s Final Node Address is: "+newList.SearchNode(value2));
                        break;
                    default:
                        endOp = true;
                        break;
                }
            }
        }

        // Displays List Operation Menu
        public static void DisplayListOperationMenu (LinkedList list){
            list.Display();
            System.out.println("1. Add an element to front of list.");
            System.out.println("2. Add an element to end of list.");
            System.out.println("3. Remove an element from front of list.");
            System.out.println("4. Remove an element from back of list.");
            System.out.println("5. Search for a node.");
            System.out.println("6. Swap two nodes.");
            System.out.println("Anything else to stop list operations");
        }

    // Displays List Operation Menu
    public static void DisplayTestChoiceMenu (){
        System.out.println("Choose Test to Run: ");
        System.out.println("1. Using randomly generated integer and double list");
        System.out.println("2. Using preloaded string list");
        System.out.println("3. Generates user list");
        System.out.println("Anything else to stop list operations");
    }

        // Default Test 1
        public static void Test1 () {
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
        private static int[] GenerateIntArray ( int length){
            Random rnd = new Random();
            int[] rndArray = new int[length];
            for (int i = 0; i < rndArray.length; ++i) {
                rndArray[i] = rnd.nextInt(10);
            }
            return rndArray;
        }

        ///Generate Random Double Array
        private static double[] GenerateDblArray ( int length, int magnitude, int dec){
            Random rnd = new Random();
            double[] rndArray = new double[length];
            for (int i = 0; i < rndArray.length; ++i) {
                rndArray[i] = Math.round(rnd.nextDouble() * magnitude * Math.pow(10, dec)) / (magnitude * Math.pow(10, dec)); // Round the value
            }
            return rndArray;
        }

        // Placeholder String Linked List
        private static LinkedList GenerateLList () {
            LinkedList newList = new LinkedList("Test List");
            newList.Postpend("George");
            newList.Postpend("Reza");
            newList.Postpend("Michael");
            newList.Postpend("Jonathan");
            newList.Postpend("David");
            newList.Postpend("Lucy");
            newList.Postpend("Mary");
            newList.Postpend("Garret");
            return newList;
        }
    }
