package binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SymmetricBT {
	public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
	}
	
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) 
            return true;
        return findLefttree(root.left).equals(findRightTree(root.right));
    }
    
    public static boolean isSymmetricOptimised(TreeNode root) {
    	 if (root == null) {
             return true; // An empty tree is symmetric
         }
         return symmetry(root.left, root.right);
    }
    
    private static boolean symmetry(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true; // Both nodes are null, so symmetric
        }

        if (left == null || right == null) {
            return false; // One of the nodes is null, so not symmetric
        }

        if (left.data != right.data) {
            return false; // The values of the nodes do not match, so not symmetric
        }

        // Recursively check the children of the nodes
        return symmetry(left.left, right.right) && symmetry(left.right, right.left);
    }
    
    private static List<Integer> findLefttree(TreeNode root){
    	List<Integer> list = new LinkedList<Integer>();
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	TreeNode prev = null;
    	while(root != null ||!st.isEmpty()) {
    		while(root!=null) {
    			st.push(root);
    			list.add(root.data);
    			root=root.left;
    		}
    		root = st.peek();
    		 if(root.right == null || root.right==prev) {
				 st.pop();
				 prev=root;
				 root = null; // Set root to null to prevent re-exploring this node
			 }
			 else {
				 root=root.right;
				 list.add(root.data);
			 }
    			
    	}
    	return list;
    }
    
    private static List<Integer> findRightTree(TreeNode root){
    	List<Integer> list = new LinkedList<Integer>();
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	TreeNode prev = null;
    	while(root != null || !st.isEmpty()) {
    		while(root!=null) {
    			st.push(root);
    			list.add(root.data);
    			root=root.right;
    		}
    		root = st.peek();
    		 if(root.left == null || root.left==prev) {
				 st.pop();
				 prev=root;
				 root = null; // Set root to null to prevent re-exploring this node
			 }
			 else {
				 root=root.left;
				 list.add(root.data);
			 }
    	}
    	return list;
    }
}
