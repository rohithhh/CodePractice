package binaryTree;

public class CheckIsBSTOrNot {
	public static void main(String[] args) {
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(3);
		node.right = new TreeNode(6);
		node.left.left= new TreeNode(2);
		node.left.right = new TreeNode(4);
		node.right.right = new TreeNode(7);
		System.out.println(isBST(node));
	}
	
	public static boolean isBST(TreeNode root) {
	    return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBSTUtil(TreeNode node, int min, int max) {
	    if (node == null) {
	        return true; // An empty node (null) is trivially a BST
	    }

	    // Check if the current node's value is within the allowed range
	    if (node.data <= min || node.data >= max) {
	        return false;
	    }

	    // Recursively check the left and right subtrees
	    return isBSTUtil(node.left, min, node.data) && isBSTUtil(node.right, node.data, max);
	}

	
	//This doesn't work in case root = 10 5 15 null null 6 20
    public static boolean isBSTMyway(TreeNode root) {
        if (root == null) {
            return true; // An empty tree is trivially a BST
        }

        // Check the left and right children recursively
        if (root.left != null) {
            // The left node must be smaller than the current node
            if (root.data <= root.left.data) {
                return false;
            }
        }

        if (root.right != null) {
            // The right node must be greater than the current node
            if (root.data >= root.right.data) {
                return false;
            }
        }

        // Recursively check the left and right subtrees
        return isBST(root.left) && isBST(root.right);
    }
}
