package LinkedList;

public class Node<T> {

    private T data;
    // Getter for Data
    public T getData() {
        return data;
    }
    // Setter for Data
    public void setData(T data) {
        this.data = data;
    }

    // Reference for Next node
    private Node<T> next;
    // Getter of Next
    public Node<T> getNext() {
        return next;
    }
    // Setter for Next
    public void setNext(Node<T> next) {
        next = next;
    }

    //Constructor
    public Node(T dataValue, Node<T> nextNode){
        data = dataValue;
        next = nextNode;
    }

}
