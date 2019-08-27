package data_structures.linked_lists;

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
        StringBuilder str = new StringBuilder();
        str.append("[");
        str.append(this.data);
        Node n = this.next;

        while (n != null) {
            str.append(", ");
            str.append(n.data);
            n = n.next;
        }
        str.append("]");
        return str.toString();
    }


}