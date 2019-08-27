package data_structures.linked_lists;

public class Question2_2 {
    public static Node returnKthToLast(LinkedList list, int k) {
        // requires: k must be >= 1
        Node n1 = list.head;
        Node n2 = list.head;
        int i = 0;

        while (n1.next != null) {
            n1 = n1.next;
            i++;

            if (i > k) {
                n2 = n2.next;
            }
        }
        return n2.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 0, 6, 8, 9, 3, 5, 5, 7};
        LinkedList newList = new LinkedList(arr);
        System.out.println(newList);
        System.out.println(returnKthToLast(newList, 3)); // expect: 5
        System.out.println(returnKthToLast(newList, 6)); // expect: 8
    }
}
