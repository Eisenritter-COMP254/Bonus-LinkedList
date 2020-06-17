package LinkedList;

public class Node<T> {

    public T data;
    // Getter for Data
    public T getData() {
        return data;
    }
    // Setter for Data
    public void setData(T data) {
        this.data = data;
    }

    // Reference for Next node
    public Node<T> next;
    // Getter of Next
    public Node<T> getNext() {
        return next;
    }
    // Setter for Next
    public void setNext(Node<T> next) {
        next = next;
    }

    public Node(T dataValue){
        data = dataValue;
    }
    //Constructor Overloading if has nextNode
    public Node(T dataValue, Node<T> nextNode){
        data = dataValue;
        next = nextNode;
    }

}