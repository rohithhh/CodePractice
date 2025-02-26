package binaryTree;

public class InsertIntoBST {
	public static void main(String[] args) {
		
	}
	
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode current = root;
    	while(true) {
            if (val < current.data) {
                // Move to the left subtree
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    break;
                } else {
                    current = current.left;
                }
            } else {
                // Move to the right subtree
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    break;
                } else {
                    current = current.right;
                }
            }
    	}
    	return root;
    }
}
