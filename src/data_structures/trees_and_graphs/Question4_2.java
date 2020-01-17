// package data_structures.trees_and_graphs;

public class Question4_2 {
    public static BinaryTreeNode minimalTree(int[] arr) {
        return arrayToTree(arr, 0, arr.length - 1);
    }

    public static BinaryTreeNode arrayToTree(int[] arr, int start, int end) {
        if (start > end) return null;

        int median = (start + end) / 2;
        BinaryTreeNode b = new BinaryTreeNode(arr[median]);
        b.left = arrayToTree(arr, start, median - 1);
        b.right = arrayToTree(arr, median + 1, end);

        return b;
    }

    public static int height(BinaryTreeNode b) {
        if (b == null) return -1;
        return Math.max(height(b.left), height(b.right)) + 1;
        
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        BinaryTreeNode tree = minimalTree(arr);

        System.out.println(height(tree));

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