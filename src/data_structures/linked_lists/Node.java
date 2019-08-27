package data_structures.linked_lists;

class LinkedList {
    Node head;

    public LinkedList(int[] arr) {
        this.head = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            head.appendToTail(arr[i]);
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        str.append(this.head.data);
        Node n = this.head.next;

        while (n != null) {
            str.append(", ");
            str.append(n.data);
            n = n.next;
        }
        str.append("]");
        return str.toString();
    }

}

class Node {
    Node next = null;
    int data;

    public Node(int d) {
        this.data = d;
    }



    void appendToTail(int d) {
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = new Node(d);
    }

    public String toString() {
        return "[" + this.data + "]";
    }


}