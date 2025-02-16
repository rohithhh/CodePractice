package binaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
	
    private static boolean isBalanced(TreeNode root) {
    	// If the tree is empty, it's balanced
        if (root == null) {
            return true;
        }

        // Calculate the height of left and right subtrees
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // Check if the absolute difference in heights
        // of left and right subtrees is <= 1
        if (Math.abs(leftHeight - rightHeight) <= 1 &&
            isBalanced(root.left) &&
            isBalanced(root.right)) {
            return true;
        }

        // If any condition fails, the tree is unbalanced
        return false;
	}
    
	public static boolean isBalancedOptmised(TreeNode root) {
    	return dfsHeight(root) != -1;
	}
	
	public static boolean isBalancedIterative(TreeNode root) {
		    if (root == null) return true;

		    // Stack to store nodes with their calculated subtree heights
		    Stack<TreeNode> stack = new Stack<>();
		    Map<TreeNode, Integer> heightMap = new HashMap<>(); // To store calculated heights
		    
		    // Traverse the tree using post-order traversal
		    TreeNode curr = root;
		    TreeNode prev = null;

		    while (!stack.isEmpty() || curr != null) {
		        // Reach the leftmost node
		        if (curr != null) {
		            stack.push(curr);
		            curr = curr.left;
		        } else {
		            // Peek the node from the stack
		            curr = stack.peek();

		            // If right child is not processed yet, move to the right child
		            if (curr.right != null && prev != curr.right) {
		                curr = curr.right;
		            } else {
		                // Process the node
		                stack.pop();

		                // Get the heights of the left and right subtrees
		                int leftHeight = heightMap.getOrDefault(curr.left, 0);
		                int rightHeight = heightMap.getOrDefault(curr.right, 0);

		                // If the tree is unbalanced at this node, return false
		                if (Math.abs(leftHeight - rightHeight) > 1) {
		                    return false;
		                }

		                // Compute the height of the current node's subtree
		                heightMap.put(curr, Math.max(leftHeight, rightHeight) + 1);

		                prev = curr;
		                curr = null;
		            }
		        }
		    }

		    return true;
		}

    
    public static int getHeight(TreeNode root) {
        // Base case: if the current node is NULL,
        // return 0 (height of an empty tree)
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height
        // of left and right subtrees
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // Return the maximum height of left and right subtrees
        // plus 1 (to account for the current node)
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    private static int dfsHeight(TreeNode root) {
        // Base case: If the current node is null, the height of an empty tree is 0.
        if (root == null) return 0;

        // Recursively calculate the height of the left subtree.
        int leftHeight = dfsHeight(root.left);
        // If the left subtree is unbalanced, return -1
        if (leftHeight == -1) return -1;

        // Recursively calculate the height of the right subtree.
        int rightHeight = dfsHeight(root.right);
        // If the right subtree is unbalanced, return -1
        if (rightHeight == -1) return -1;

        // Check if the difference in height between the left and right subtrees is greater than 1.
        // If the difference is greater, the tree is unbalanced, return -1
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        // Return the height of the tree rooted at the current node.
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
