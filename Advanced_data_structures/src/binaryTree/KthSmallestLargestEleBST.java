package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestLargestEleBST {
	public static void main(String[] args) {
		
	}
	
	//Perform a full inorder traversal and store values in an array. The k-th smallest is at index k-1, and the k-th largest is at index n-k.
    public List<Integer> kLargesSmall(TreeNode root, int k) {
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
	    List<Integer> returnList = new ArrayList<>();
        returnList.add(list.get(k-1));
        returnList.add(list.get(list.size()-k));
	    return returnList;
    }
}
