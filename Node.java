public class Node{
    public Node(String value) {
        /*create a constructor*/
        data = value;
    }
    private String data;
    private Node next,prev;
    //write get/set methods for all three instance variables.
    public String value() {
        return data;
    }
    public void setValue(String n) {
        data = n;
    }
    public Node next() {
        return next;
    }
    public void setNext(Node n) {
        next = n;
    }
    public Node prev() {
        return prev;
    }
    public void setPrev(Node n) {
        prev = n;
    }
}