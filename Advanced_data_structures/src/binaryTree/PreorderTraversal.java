package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
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
        root.left.left.left = null; // explicitly setting the left child as null
        root.left.left.right = new TreeNode(6);
        
        System.out.println(preorder(root));
	}
	
	 public static List<Integer> preorder(TreeNode root) {
	        List<Integer> list = new ArrayList<>();
	         if (root == null) {
	            return list;
	        }
	        Stack<TreeNode> st = new Stack<>();
	        st.push(root);
	        while(!st.isEmpty()){
	          root = st.pop();
	          list.add(root.data);
	            if (root.right != null) {
	                st.push(root.right);
	            }

	            // Push the left child onto
	            // the stack if exists
	            if (root.left != null) {
	                st.push(root.left);
	            }
	        }
	        return list;
	    }
}
