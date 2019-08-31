package data_structures.linked_lists;

class LinkedList {
    // Datatype representing a simple singly-linked list
    Node head;

    public LinkedList() {
        this.head = new Node(0);
    }

    public LinkedList(Node n) {
        this.head = n;
    }

    public LinkedList(int[] arr) {
        this.head = new Node(arr[0]);
        Node n = this.head;
        for (int i = 1; i < arr.length; i++) {
            n.next = new Node(arr[i]);
            n = n.next;
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.head.data);
        Node n = this.head.next;

        while (n != null) {
            str.append(" -> ");
            str.append(n.data);
            n = n.next;
        }

        return str.toString();
    }

}

class Node {
    // Datatype representing a single node in a singly-linked list
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