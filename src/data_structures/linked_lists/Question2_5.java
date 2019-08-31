package data_structures.linked_lists;

public class Question2_5 {
    public static Node sumLists(Node n1, Node n2) {
        // sum two linked lists representing integers
        int sum, carry = 0;
        Node n3 = new Node(0);
        Node head = n3;

        while (n1 != null || n2 != null) {
            if (n1 != null && n2 != null) {
                sum = n1.data + n2.data + carry;
                n1 = n1.next;
                n2 = n2.next;
            } else if (n1 != null) {
                sum = n1.data + carry;
                n1 = n1.next;
            } else {
                sum = n2.data + carry;
                n2 = n2.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            n3.next = new Node(sum);
            n3 = n3.next;
        }

        if (carry > 0) {
            n3.next = new Node(carry);
        }

        return head.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 1, 6};
        int[] arr2 = {5, 9, 2};
        int[] arr3 = {4, 5, 9};
        int[] arr4 = {2, 5};
        int[] arr5 = {3, 2, 1, 7};

        LinkedList l1 = new LinkedList(arr1);
        LinkedList l2 = new LinkedList(arr2);
        LinkedList l3 = new LinkedList(arr3);
        LinkedList l4 = new LinkedList(arr4);
        LinkedList l5 = new LinkedList(arr5);

        System.out.println(new LinkedList(sumLists(l1.head, l2.head))); // 2 1 9
        System.out.println(new LinkedList(sumLists(l1.head, l3.head))); // 1 7 5 1
        System.out.println(new LinkedList(sumLists(l1.head, l4.head))); // 9 6 6
        System.out.println(new LinkedList(sumLists(l1.head, l5.head))); // 0 4 7 7
        System.out.println(new LinkedList(sumLists(l5.head, l4.head))); // 5 7 1 7
    }
}
