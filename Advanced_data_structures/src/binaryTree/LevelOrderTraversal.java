package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
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
        
        System.out.println(levelOrder(root));
	}
	
    public static List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> parent = new ArrayList<List<Integer>>();
    	 // Create a queue to store nodes for level-order traversal
        Queue<TreeNode> q = new LinkedList<>();
        // Add the root node to the queue
        q.add(root);
        while (!q.isEmpty()) {
        	int size = q.size();
        	List<Integer> child = new ArrayList<Integer>();
        	for(int i=0;i<size;i++) {
        		TreeNode node = q.poll();
        		child.add(node.data);
        		if(node.left!=null)
        			q.add(node.left);
        		if(node.right!=null)
        			q.add(node.right);
        	}
        	parent.add(child);
        }
        return parent;
    }
}
