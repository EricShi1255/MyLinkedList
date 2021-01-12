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
        size();
        return true;
    }
    public void add(int index, String value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of Range!");
        }
        int pos = 0;
        Node curr = start;
        Node newElement = new Node(value);  
        //empty
        if (start == null) {
            start = newElement;
            end = newElement;
        }
        //beginning 
        else if (index == 0) {
            newElement.setNext(start);
            start.setPrev(newElement);
            start = newElement;
        }
        //end
        else if (index == size()) {
            end.setNext(newElement);
            newElement.setPrev(end);
            end = newElement;

        }
        while (curr != null) {
            //middle
            if (pos == index-1) {
                Node elementAfter = getNode(index);  
                newElement.setNext(elementAfter);
                curr.setNext(newElement);
                newElement.setPrev(curr);
                elementAfter.setPrev(newElement);
            }
            curr = curr.next();
            pos++;
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
        Node elementBefore = getNode(index-1);
        Node elementAfter = getNode(index+1); 
         //beginning 
        if (index == 0) {
            start = elementAfter;
            start.setPrev(null);
        }
        //end
        if (index == size()-1) {
            end = elementBefore;
            end.setNext(null);
        } 
        else {
            elementBefore.setNext(elementAfter);
            elementAfter.setPrev(elementBefore);
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