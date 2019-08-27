package data_structures.linked_lists;

public class Question2_4 {
    public static void partition(LinkedList l, int partition) {
        Node n1 = l.head;
        Node n2 = new Node(0); // initialized to dummy value 0
        Node head2 = n2; // keep track of start of second linkedlist nodes

        while (n1.next != null) {
            if (n1.data >= partition) {
                // Add current node value to the end of the second list
                n2.next = new Node(n1.data);
                n2 = n2.next;
                // Remove current node value from the first list
                n1.data = n1.next.data;
                n1.next = n1.next.next;
            } else {
                // continue to next node
                n1 = n1.next;
            }
        }

        n1.next = head2.next; // append partitioned list n2 to n1, skipping first dummy value
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 5, 10, 2, 1};
        LinkedList list = new LinkedList(arr);
        System.out.println(list);
        partition(list, 5);
        System.out.println(list);
    }
}
