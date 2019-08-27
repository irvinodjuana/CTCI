package data_structures.linked_lists;

public class Question2_3 {
    public static void deleteMiddle(Node n) {
        n.data = n.next.data;
        n.next = n.next.next;
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(4);
        Node n3 = new Node(3);
        Node n4 = new Node(8);
        Node n5 = new Node(0);

        l.head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(l);
        deleteMiddle(n3);
        System.out.println(l);
    }
}
