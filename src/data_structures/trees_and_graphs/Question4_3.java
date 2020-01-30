import java.util.ArrayList;
import java.lang.Math;

public class Question4_3 {
    public static int height(BinaryTreeNode root) {
        if (root != null)
            return Math.max(height(root.left), height(root.right)) + 1;
        return -1;
    }
    public static ListNode[] listOfDepths(BinaryTreeNode root) {
        int ht = height(root);
        ListNode[] heads = new ListNode[ht + 1];
        ListNode[] tails = new ListNode[ht + 1];

        DFS(root, 0, heads, tails);
        return heads;
    }

    // DFS on binary tree, updates heads/tails linkedlists of nodes at each depth
    public static void DFS(BinaryTreeNode root, int depth, ListNode[] heads, ListNode[] tails) {
        if (root == null) return;

        if (heads[depth] == null) {
            heads[depth] = new ListNode(root);
            tails[depth] = heads[depth];
        } else {
            tails[depth].next = new ListNode(root);
            tails[depth] = tails[depth].next;
        }
        DFS(root.left, depth+1, heads, tails);
        DFS(root.right, depth+1, heads, tails);
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
        
        ListNode[] result = listOfDepths(nodes[0]);

        for (ListNode l : result) {
            String s = "";
            while (l != null) {
                s += l.bnode.data + " -> ";
                l = l.next;
            }
            System.out.println(s);
        }
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


class ListNode {
    BinaryTreeNode bnode;
    ListNode next;
    
    public ListNode(BinaryTreeNode b) {
        this.bnode = b;
        this.next = null;
    }
}