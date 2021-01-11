import java.util.IllegalArgumentException;
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
        size = count;
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
        size();
        return true;
    }
    public void add(int index, String value) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of Range!");)
        }
        int pos = 0;
        Node curr = start;
        Node newElement = new Node(value);  
        Node elementAfter = getNode(index);
        //middle  
        while (curr != null) {
            //beginning 
            if (index == 0) {
                start = newElement;
            }
            //end
            if (index == size()-1) {
                newElement.setPrev(getNode(size()-2));
            }
            if (pos == index-1) {
                curr.setNext(newElement);
                newElement.setPrev(curr);
            }
            if (index == 0 || index == size()-1 || pos == index-1) {
                newElement.setNext(elementAfter);
                elementAfter.setPrev(newElement);
            }
            curr = curr.next();
            pos++;
        }
        size();
    }
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of Range!");)
        }
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
    private Node getNode(int index) {
        
        int pos = 0;
        Node result = new Node("");
        Node curr = start;
        while (curr != null) {
            if (pos == index) {
               //this is to keep the properties the same 
               result.setValue(curr.value());
               result.setNext(curr.next());
               result.setPrev(curr.prev());
            }
            curr = curr.next();
            pos++;
        }
        return result;
    }
    public String set(int index, String value) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of Range!");)
        }
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
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of Range!");)
        }
        int pos = 0;
        Node curr = start;
        String removed = getNode(index).value();
        Node elementBefore = getNode(index-1);
        Node elementAfter = getNode(index+1);
        //middle  
        while (curr != null) {
            //beginning 
            if (index == 0) {
                start = elementAfter;
            }
            //end
            if (index == size()-1) {
                end = elementBefore;
            }
            if (pos == index-1) {
                curr.setNext(elementAfter);
                elementAfter.setPrev(curr);
            }
            curr = curr.next();
            pos++;
        }
        size();
        return removed;
    }
    public void extend(MyLinkedList other){
        /*
        *@postcondition: All of the elements from other are removed from the other, and connected to the end of this linked list.
        *@postcondition: The size of other is reduced to 0.
        *@postcondition: The size of this is now the combined sizes of both original lists
        */
        end.setNext(other.getNode(0));

    }
   
}