package data_structures.trees_and_graphs;

import java.util.ArrayList;

public class TreeNode {
    public String data;
    public ArrayList<TreeNode> children;

    public TreeNode(String data) {
        this.data = data;
    }
}

class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }
}
