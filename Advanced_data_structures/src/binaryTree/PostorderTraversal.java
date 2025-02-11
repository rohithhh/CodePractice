package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
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
        
        System.out.println(postOrder(root));
	}
	
	 public static List<Integer> postOrder(TreeNode root) {
		 List<Integer> list = new ArrayList<>();
		 if(root==null)
			 return list;
		 Stack<TreeNode> st = new Stack<TreeNode>();
		 TreeNode lastVisited = null;
		 while(root != null || !st.isEmpty()) {
			 while(root!=null) {
				 st.push(root);
				 root=root.left;
			 }
			 root=st.peek();
			 //If the current node is null, peek at the right child of the top node in the stack. 
			 //This indicates that the left subtree is done, and we need to either explore the right subtree or backtrack.
			 //If the right child is null or already processed, pop nodes from the stack and add their values to the postorder array. 
			 //This signifies we have finished exploring both children and are now processing the current node.
			 if(root.right == null || root.right==lastVisited) {
				 list.add(root.data);
				 st.pop();
				 lastVisited=root;
				 root = null; // Set root to null to prevent re-exploring this node
			 }
			 else
				 root=root.right;
		 }
		 return list;
	 }
	 
	 public static List<Integer> postOrderNew(TreeNode root) {
		 List<Integer> result = new ArrayList<>();  
	        if (root == null) return result;

	        // Stack to manage nodes
	        Stack<TreeNode> stack = new Stack<>();  
	        TreeNode current = root;
	        TreeNode prev = null;

	        while (current != null || !stack.isEmpty()) {
	            while (current != null) {
	                // Push current node to stack
	                stack.push(current);  
	                // Move to left child
	                current = current.left;  
	            }

	            // Peek the top of the stack
	            current = stack.peek();  
	            if (current.right == null || current.right == prev) {
	                // Add node data to result
	                result.add(current.data); 
	                // Remove node from stack 
	                stack.pop();  
	                // Update previous node
	                prev = current;  
	                // Move to next node
	                current = null;  
	            } else {
	                // Move to right child
	                current = current.right; 
	            }
	        }

	        return result;
	 }
}
