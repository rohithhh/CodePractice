package binaryTree;

public class DiameterOfBT {
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
	        System.out.println(diameterOfBinaryTree(root));
	}
	static int diameter =0;
    public static int diameterOfBinaryTree(TreeNode root) {
    	diameter =0;
    	calculateHeight(root);
        return diameter;
    }

	private static int calculateHeight(TreeNode root) {
		int diameter = 0;
		if(root== null)
			return 0;
		int leftHeight = calculateHeight(root.left);
		int rightHeight = calculateHeight(root.right);
		diameter = Math.max(diameter, rightHeight+ leftHeight);
		return 1 +  Math.max(leftHeight, rightHeight);
	}
}
