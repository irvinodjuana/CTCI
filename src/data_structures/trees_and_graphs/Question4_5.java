package data_structures.trees_and_graphs;

import java.util.ArrayList;

public class Question4_5 {
    /**
     * Check if binary tree is a BST
     * assumption: keys of nodes are unique
     */
    public static boolean isBST(BinaryTreeNode root) {
        ArrayList<BinaryTreeNode> list = new ArrayList<>();
        inOrderList(root, list);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).data < list.get(i-1).data)
                return false;
        }
        return true;
    }

    public static void inOrderList(BinaryTreeNode root, ArrayList<BinaryTreeNode> list) {
        if (root != null) {
            inOrderList(root.left, list);
            list.add(root);
            inOrderList(root.right, list);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode[] nodes = new BinaryTreeNode[13];
        for (int i = 0; i < nodes.length; i++)
            nodes[i] = new BinaryTreeNode(i);
        // Non-BST
        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];
        nodes[1].left = nodes[3];
        nodes[2].left = nodes[4];
        nodes[2].right = nodes[5];
        nodes[3].right = nodes[6];
        nodes[4].right = nodes[7];
        nodes[6].left = nodes[8];
        nodes[6].right = nodes[9];
        nodes[7].left = nodes[10];
        nodes[7].right = nodes[11];
        nodes[11].right = nodes[12];

        System.out.println("Non-BST tree is a BST? " + isBST(nodes[0]));

        // BST
        nodes[1].left = null;
        nodes[1].right = null;
        nodes[2].left = nodes[1];
        nodes[2].right = nodes[3];
        nodes[3].left = null;
        nodes[3].right = null;
        nodes[4].left = nodes[2];
        nodes[4].right = nodes[6];
        nodes[5].left = null;
        nodes[5].right = null;
        nodes[6].left = nodes[5];
        nodes[6].right = nodes[7];
        nodes[7].left = null;
        nodes[7].right = null;

        System.out.println("BST tree is a BST? " + isBST(nodes[4]));

        // BST -> edge case Non-BST
        nodes[2].right = nodes[9];

        System.out.println("Edge case non-BST tree is a BST? " + isBST(nodes[4]));
    }
    
}