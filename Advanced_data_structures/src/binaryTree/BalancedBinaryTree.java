package binaryTree;

public class BalancedBinaryTree {
	public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        
        // Level 1 nodes
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        
        // Level 2 nodes
        root.left.left = new TreeNode(8);
        root.left.right = null; // explicitly setting the right child as null
        root.right.left = null; // explicitly setting the left child as null
        root.right.right = new TreeNode(4);
        
        // Level 3 nodes
        root.left.left.left = new TreeNode(6); // explicitly setting the left child as null
        root.left.left.right = null;
        System.out.println(isBalanced(root));
	}
	
    public static boolean isBalanced(TreeNode root) {
    	return dfsHeight(root) != -1;
	}
    
    private static int dfsHeight(TreeNode root) {
        // Base case: If the current node is null, the height of an empty tree is 0.
        if (root == null) return 0;

        // Recursively calculate the height of the left subtree.
        int leftHeight = dfsHeight(root.left);
        // If the left subtree is unbalanced, propagate the unbalance status.
        if (leftHeight == -1) return -1;

        // Recursively calculate the height of the right subtree.
        int rightHeight = dfsHeight(root.right);
        // If the right subtree is unbalanced, propagate the unbalance status.
        if (rightHeight == -1) return -1;

        // Check if the difference in height between the left and right subtrees is greater than 1.
        // If the difference is greater, the tree is unbalanced.
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        // Return the height of the tree rooted at the current node.
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
