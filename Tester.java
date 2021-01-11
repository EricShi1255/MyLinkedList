public class Tester {
    public static void main(String[] args) {
        //Node Testing
        Node A = new Node("unit 01");
        Node B = new Node("unit 02");
        Node aa = new Node("unit 00");
        A.setNext(B); 
        A.setPrev(aa);
        System.out.println(A.value());
        System.out.println((A.next()).value());
        System.out.println((A.prev()).value());

        //LinkedList Testing
        MyLinkedList Units = new MyLinkedList();
        Units.add("apple");
        Units.add("berry");
        Units.add("cola");
        Units.add("durian");
        Units.add("egg");
        Units.set(2, "cherry");
        Units.add(2, "asushin");
        Units.add(0,"first");
        Units.add(6, "EGG2");
        System.out.println(Units.toString());
    }
}
