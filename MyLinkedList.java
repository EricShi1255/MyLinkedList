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
            added.setPrev(end);
            end = added;
        }
        size++;
        return true;
    }
    
    public void add(int index, String value) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of Range!");
        }
        Node newElement = new Node(value);  
        //empty && beginning
        if (index == 0) {
            if (size() > 0) {
              newElement.setNext(start);
              start.setPrev(newElement);
              start = newElement;
            }
            else {
              start = newElement;
              end = newElement;
            }
          }
        //end
        else if (index == size()) {
            newElement.setPrev(end);
            end.setNext(newElement);
            end = newElement;
        }
        else {
            Node prev = getNode(index-1);
            Node after = getNode(index);  
            newElement.setNext(after);
            prev.setNext(newElement);
            newElement.setPrev(prev);
            after.setPrev(newElement);
        }
        size();
    }
    
    public String get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of Range!");
        }
        int pos = 0;
        String result = "";
        Node curr = start;
        while (curr != null) {
            if (pos == index) {
               result =  curr.value();
            }
            curr = curr.next();
            pos++;
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
               return curr;
            }
            curr = curr.next();
            pos++;
        }
        return result; //should be unreachable
    }
    public String set(int index, String value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of Range!");
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
            throw new IndexOutOfBoundsException("Index out of Range!");
        }
        String removed = get(index);
        Node prev = getNode(index-1);
        Node after = getNode(index+1); 
        //null after removal
        if (size == 1) {
            start = null;
        }
         //beginning 
        else if (index == 0) {
            start = after;
            //start.setPrev(null);
        }
        //nd
        else if (index == size()-1) {
            end = prev;
            //end.setNext(null);
        } 
        else {
            prev.setNext(after);
            after.setPrev(prev);
        }
        size--;
        return removed;
    }
    public void extend(MyLinkedList other){
        /*
        *@postcondition: All of the elements from other are removed from the other, and connected to the end of this linked list.
        *@postcondition: The size of other is reduced to 0.
        *@postcondition: The size of this is now the combined sizes of both original lists
        */
        if (size() == 0) {
            start = other.start;
            end = other.end;
            size = other.size;
            
            other.size = 0;
            other.start = null;
            other.end = null;
        }
        else if (other.size == 0) {
        }
        else {
            end.setNext(other.start); 
            end = other.end;
            size = size + other.size;
            
            other.size = 0;
            other.start = null;
            other.end = null;
        }
    }
    public String toStringReversed() {
        String result = "[";
        Node curr = end;
        while (curr != null) {
            result += curr.value();
            if (curr.prev() != null) {
                result += ", ";
            }
            curr = curr.prev();
        } 
        return(result + "]");
    }

}