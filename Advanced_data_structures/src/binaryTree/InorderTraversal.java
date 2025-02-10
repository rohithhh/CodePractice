package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
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
        
        System.out.println(inorder(root));
	}
	
	 public static List<Integer> inorder(TreeNode root) {
		    List<Integer> list = new ArrayList<>();
		    if (root == null) {
		        return list;
		    }
		    
		    Stack<TreeNode> st = new Stack<>();
		    
		    while (root != null || !st.isEmpty()) {
		        // Reach the leftmost node of the current node
		        while (root != null) {
		            st.push(root);
		            root = root.left;
		        }
		        
		        // Pop the top item from the stack and process it
		        root = st.pop();
		        list.add(root.data);
		        
		        // Now visit the right child
		        root = root.right;
		    }
		    
		    return list;
	}
	 
	 public static List<Integer> inorderNew(TreeNode root) {
	        // Initialize a stack to track nodes
	        Stack<TreeNode> st = new Stack<>();
	        // Start from the root node
	        TreeNode node = root;
	        // Initialize a list to store
	        // inorder traversal result
	        List<Integer> inorder = new ArrayList<>();

	        // Start an infinite
	        // loop for traversal
	        while (true) {
	            // If the current node is not NULL
	            if (node != null) {
	                // Push the current
	                // node to the stack
	                st.push(node);
	                // Move to the left child
	                // of the current node
	                node = node.left;
	            } else {
	                // If the stack is empty,
	                // break the loop
	                if (st.isEmpty()) {
	                    break;
	                }
	                // Retrieve a node from the stack
	                node = st.pop();
	                // Add the node's value to
	                // the inorder traversal list
	                inorder.add(node.data);
	                // Move to the right child
	                // of the current node
	                node = node.right;
	            }
	        }
	        // Return the inorder
	        // traversal result
	        return inorder;		 
	 }
}
