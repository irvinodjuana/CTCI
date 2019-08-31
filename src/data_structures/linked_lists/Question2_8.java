package data_structures.linked_lists;
import java.util.HashSet;

public class Question2_8 {
    public static Node circularLoopStart(Node n) {
        // Requires: Node n is the start of a corrupted Linked List with a circular reference
        HashSet<Node> nodes = new HashSet<Node>();

        while (n != null) {
            if (nodes.contains(n)) {
                return n;
            } else {
                nodes.add(n);
            }
            n = n.next;
        }

        return null; // should not reach here - only if list is not circular
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node (5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;

        System.out.println(circularLoopStart(n1));
    }
}
