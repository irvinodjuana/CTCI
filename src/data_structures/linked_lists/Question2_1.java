package data_structures.linked_lists;
import java.util.HashSet;

public class Question2_1 {
    public static Node removeDupes(Node head) {
        HashSet<Integer> uniques = new HashSet<Integer>();
        Node n = head;
        uniques.add(n.data);

        while(n.next != null) {
            if (!uniques.contains(n.next.data)) {
                uniques.add(n.next.data);
                n = n.next;
            } else {
                n.next = n.next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node newList = new Node(1);
        newList.appendToTail(2);
        newList.appendToTail(3);
        newList.appendToTail(3);
        newList.appendToTail(5);
        newList.appendToTail(2);
        newList.appendToTail(5);
        System.out.println(newList);

        System.out.println(removeDupes(newList));
    }
}
