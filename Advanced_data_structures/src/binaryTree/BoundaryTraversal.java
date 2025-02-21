package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
	public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(boundary(root));
	}
	
	public static List<Integer> addLeft(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode current = root.left; // Start from left child of root
        while (current != null) {
            if (!isLeaf(current)) { // Do not add leaf nodes
                list.add(current.data);
            }
            if (current.left != null) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return list;
    }
    
    // Function to traverse right boundary (excluding leaf nodes)
    public static List<Integer> addRight(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode current = root.right; // Start from right child of root
        while (current != null) {
            if (!isLeaf(current)) { // Do not add leaf nodes
                list.add(current.data);
            }
            if (current.right != null) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        // Reverse the list to get the correct order (bottom-up)
        List<Integer> reversedList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;
    }
    
    // Function to add leaf nodes to the result list
    public static void addLeaves(TreeNode root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null) {
            addLeaves(root.left, res);
        }
        if (root.right != null) {
            addLeaves(root.right, res);
        }
    }
    
    // Function to check if a node is a leaf node
    public static boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }
    
    // Main function for boundary traversal
    public static List<Integer> boundary(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        // Add root data if it's not a leaf
        if (!isLeaf(root)) {
            result.add(root.data);
        }
        
        // Add left boundary
        result.addAll(addLeft(root));
        
        // Add leaves
        addLeaves(root, result);
        
        // Add right boundary
        result.addAll(addRight(root));
        
        return result;
    }
}
