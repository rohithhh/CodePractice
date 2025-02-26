package binaryTree;

public class SearchInBST {
	public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        // Level 1 nodes
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        // Level 2 nodes
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(searchBST(root, 2));
	}
	
    public static TreeNode searchBST(TreeNode root, int val) {
    	while(root!=null) {
    		if(root.data==val)
    			return root;
    		if(root.data<val)
    			root=root.right;
    		else
    			root=root.left;
    	}
        return null;
    }
}
