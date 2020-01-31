package data_structures.trees_and_graphs;

import java.util.HashMap;
import java.lang.Math;

public class Question4_4 {
    // Memoized computation of binary tree node height
    public static int height(BinaryTreeNode root, HashMap<BinaryTreeNode, Integer> heightMap) {
        if (root == null) {
            return -1;
        } else if (heightMap.containsKey(root)) {
            return heightMap.get(root);
        } else {
            int ht = Math.max(height(root.left, heightMap), 
                              height(root.right, heightMap)) + 1;
            heightMap.put(root, ht);
            return ht;
        }
    }

    // check if binary tree is balanced
    // O(n) to compute all heights and store in hashmap
    // O(n) computation to check if balanced at each node: O(1) x n nodes
    // O(n) total runtime
    public static boolean checkBalanced(BinaryTreeNode root) {
        HashMap<BinaryTreeNode, Integer> heightMap = new HashMap<>();
        return balancedHelper(root, heightMap);
    } 

    // Recursive function checking if tree is balanced at nodes and balanced at children
    // Uses hashmap to make checking height more efficient
    public static boolean balancedHelper(BinaryTreeNode root, HashMap<BinaryTreeNode, Integer> heightMap) {
        if (root == null) return true;

        int heightL = height(root.left, heightMap);
        int heightR = height(root.right, heightMap);
        if (Math.abs(heightL - heightR) > 1)
            return false;
        
        return balancedHelper(root.left, heightMap) && balancedHelper(root.right, heightMap);
    } 

    public static void main(String[] args) {
        BinaryTreeNode[] nodes = new BinaryTreeNode[13];
        for (int i = 0; i < nodes.length; i++)
            nodes[i] = new BinaryTreeNode(i);
        
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

        System.out.println("Balanced tree is balanced? " + checkBalanced(nodes[7]));
        System.out.println("Unbalanced tree is balanced? " + checkBalanced(nodes[0]));
        System.out.println("Minimally Unbalanced tree is balanced? " + checkBalanced(nodes[3]));
        System.out.println("Null tree is balanced? " + checkBalanced(null));
        System.out.println("Leaf node is balanced? " + checkBalanced(nodes[8]));
    }
}