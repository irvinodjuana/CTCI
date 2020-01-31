package data_structures.trees_and_graphs;

import java.util.ArrayList;

public class MyTreeNode {
    public String data;
    public ArrayList<MyTreeNode> children;

    public MyTreeNode(String data) {
        this.data = data;
    }
}

class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public String toString() {
        return "{" + this.data + ", L: " + this.left + ", R: " + this.right + "}";
    }
}
