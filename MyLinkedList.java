public class MyLinkedList{
    private int size;
    private Node start,end;  
    public MyLinkedList(){
        /*create a constructor*/
        size = 0;
    }
    public int size() {
        int count = 0;
        curr = start;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }
    public boolean add(String value) {
        //adds to end of list;
        Node added = new Node(value);
        end.next() = added;
        end = added;
    }
    public void add(int index, String value) {

    }
    public String get(int index) {
        int pos = 0;
        String result = "";
        curr = start;
        while (curr != null) {
            if (pos == index) {
               result =  curr.value();
            }
            curr = curr.next();
        }
        return result;
    }
    public String set(int index, String value) {

    }
    public String toString() {
        
    }
 //Any helper method that returns a Node object MUST BE PRIVATE!
}