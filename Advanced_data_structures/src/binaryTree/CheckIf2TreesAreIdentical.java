package binaryTree;

public class CheckIf2TreesAreIdentical {
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
        
        TreeNode root1 = new TreeNode(5);
        
        // Level 1 nodes
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(2);
        
        // Level 2 nodes
        root1.left.left = new TreeNode(8);
        root1.left.right = null; // explicitly setting the right child as null
        root1.right.left = null; // explicitly setting the left child as null
        root1.right.right = new TreeNode(4);
        
        // Level 3 nodes
        root1.left.left.left = new TreeNode(6); // explicitly setting the left child as null
        root1.left.left.right = null;
        System.out.println(isSameTree(root, root1));
	}
	
    public static boolean isSameTree(TreeNode p, TreeNode q) {
    	  if (p == null && q == null) {
              return true;
          }

          // If one of the nodes is null, the trees are not the same
          if (p == null || q == null) {
              return false;
          }

          // If the values of the nodes are different, the trees are not the same
          if (p.data != q.data) {
              return false;
          }

          // Recursively check the left and right subtrees
          return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
