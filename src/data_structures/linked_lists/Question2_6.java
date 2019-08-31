package data_structures.linked_lists;

public class Question2_6 {
    public static boolean isPalindrome(LinkedList lst) {
        Node n1 = lst.head;
        Node n2 = null; // reverse of n1

        while (n1 != null) {
            Node temp = new Node(n1.data);
            temp.next = n2;
            n2 = temp;
            n1 = n1.next;
        }

        LinkedList reversedLst = new LinkedList(n2);

        return equals(lst, reversedLst);
    }

    public static boolean equals(LinkedList l1, LinkedList l2) {
        Node n1 = l1.head, n2 = l2.head;

        while (n1 != null && n2 != null) {
            if (n1.data != n2.data) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        return (n1 == null && n2 == null);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 7, 5, 3, 1};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {2, 0, 2};
        LinkedList l1 = new LinkedList(arr1);
        LinkedList l2 = new LinkedList(arr2);
        LinkedList l3 = new LinkedList(arr3);

        System.out.println(isPalindrome(l1)); // true
        System.out.println(isPalindrome(l2)); // false
        System.out.println(isPalindrome(l3)); // true

    }

}
