package data_structures.linked_lists;
import java.util.HashSet;

public class Question2_7 {
    public static Node intersect(Node n1, Node n2) {
        HashSet<Node> nodes = new HashSet<Node>();

        while (n1 != null) {
            nodes.add(n1);
            n1 = n1.next;
        }
        while (n2 != null) {
            if (nodes.contains(n2)) {
                return n2;
            }
            n2 = n2.next;
        }

        return null;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node (5);
        Node n6 = new Node (6);
        Node n7 = new Node(7);

        n1.next = n2; // 1 2 3 4
        n2.next = n3;
        n3.next = n4;

        n5.next = n6; // 5 6 3 4
        n6.next = n3;

        System.out.println(intersect(n1, n3)); // expect n3 ( [3] )
        System.out.println(intersect(n1, n7)); // expect null


    }
}
