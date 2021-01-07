public class MyLinkedList{
    private int size;
    private Node start,end;  
    public MyLinkedList(){
        /*create a constructor*/
        size = 0;
    }
    public int size() {
        int count = 0;
        Node curr = start;
        while (curr != null) {
            curr = curr.next();
            count++;
        }
        return count;
    }
    public boolean add(String value) {
        //adds to end of list;
        Node added = new Node(value);
        if (start == null) {
            start = added;
            end = added;
        }
        else {
            end.setNext(added);
            end = added;
        }
        return true;
    }
    public void add(int index, String value) {
        //to do
    }
    public String get(int index) {
        int pos = 0;
        String result = "";
        Node curr = start;
        while (curr != null) {
            if (pos == index) {
               result =  curr.value();
            }
            curr = curr.next();
        }
        return result;
    }
    public String set(int index, String value) {
        int pos = 0;
        String result = "";
        Node curr = start;
        while (curr != null) {
            if (pos == index) {
               result =  curr.value(); //value popped out
               curr.setValue(value); //value inserted
            }
            curr = curr.next();
            pos++;
        }
        return result;
    }
    public String toString() {
        String result = "[";
        Node curr = start;
        while (curr != null) {
            result += curr.value();
            if (curr.next() != null) {
                result += ", ";
            }
            curr = curr.next();
        }
        return(result + "]");
    }
 //Any helper method that returns a Node object MUST BE PRIVATE!
}