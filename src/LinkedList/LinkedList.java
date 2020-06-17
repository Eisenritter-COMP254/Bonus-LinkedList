package LinkedList;

public class LinkedList {
    private Node firstNode;
    private Node lastNode;
    private String name; // string like "list" to display

    // Construct empty List with unspecified
    public LinkedList(){
        name="Unnamed List";
        firstNode = lastNode = null;
    }
    // Construct empty List with specified name
    public LinkedList(String listName){
        name=listName;
        firstNode = lastNode = null;
    }

    // Insert object Node in front
    public<T> void Prepend(T data){
        firstNode=IsEmpty()?lastNode = new Node(data):new Node(data,firstNode);
    }

    // Insert object Node at back
    public<T> void Postpend(T data){
        if (IsEmpty()){
            firstNode = lastNode = new Node(data);
        }
        else {
            lastNode = lastNode.next= new Node(data);
        }
    }

    // Remove first node from List
    public <T> T RemoveFromFront() throws Exceptions {
        if (IsEmpty()){
            throw new Exceptions("Empty List",
            "The List is empty, please make sure there are items in list first.");
        }

        T removeItem = (T)firstNode.data;
        // If first node is the last node, then set it to null, else, the next node becomes the first node.
        firstNode = (firstNode==lastNode)?lastNode=null:firstNode.next;
        return removeItem;
    }

    // Remove last node from List
    public <T> T RemoveFromBack() throws Exceptions {
        if (IsEmpty()){
            throw new Exceptions("Empty List",
                    "The List is empty, please make sure there are items in list first.");
        }

        T removeItem = (T)lastNode.data;
        // If first node is the last node, then set it to null, else, the next node becomes the first node.
        if(firstNode == lastNode){
            firstNode = lastNode =null;
        }
        else{
            Node current = firstNode;
            // Loop throw list until current node is the one before l;ast node
            while (current.next != lastNode){
                current = current.next; // move to next node
            }
            lastNode = current; // set last node to current node
            current.next = null; // empty last node
        }

        return removeItem;
    }

    // Check for empty list
    public boolean IsEmpty(){
        return firstNode == null;
    }

    // Output List contents
    public void Display()
    {
        if (IsEmpty())
        {
            System.out.println("Empty "+name);
        }
        else
        {
            System.out.println("The "+name +" is: ");

            Node current = firstNode;

            // output current node data while not at end of list
            while (current != null)
            {
                System.out.print(current.data + " ");
                current = current.next;
            }

            System.out.println("\n");
        }
    }

    public String getName() {
        return name;
    }
}
