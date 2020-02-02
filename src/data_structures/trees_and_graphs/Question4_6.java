public class Question4_6 {
    // get left most descendant from binary tree node
    public static BinaryTreeNode leftMostChild(BinaryTreeNode root) {
        if (root == null || root.left == null) return root;
        return leftMostChild(root.left)
    }

    // implementation of in order successor
    public static BinaryTreeNode inOrderSuccessor(BinaryTreeNode root) {
        if (root == null) {
            return null;
        } else if (root.right != null) {
            return leftMostChild(root.right);
        } else {
            BinaryTreeNode anc = root;
            while (true) {
                // reach root of BST
                if (anc.parent == null)
                    return null;
                // if ancestor is left child, return ancestor's parent
                if (anc == anc.parent.left)
                    return anc.parent;
                // if ancestor is right child, repeat with ancestor
                anc = anc.parent;
            }
        }
    }
}

class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode parent;

    public BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode addLeftChild(int data) {
        this.left = new BinaryTreeNode(data);
        this.left.parent = this;
        return this.left;
    }

    public BinaryTreeNode addRightChild(int data) {
        this.right = new BinaryTreeNode(data);
        this.right.parent = this;
        return this.right;
    }

    public String toString() {
        return "{" + this.data + ", L: " + this.left + ", R: " + this.right + "}";
    }
}