package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthInBT {
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
        
        System.out.println(maxDepth(root));
	}
	
    public static int maxDepth(TreeNode root) {
    	int level=0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
    	   int size = q.size();
    	   for(int i=0;i<size;i++) {
    		   TreeNode node = q.poll();
    		   if(node.right!=null)
    			   q.add(node.right);
    		   if(node.left!=null)
    			   q.add(node.left);
    	   }
    	   level++;
        }
        return level;
    }
    
    public static int maxDepthOptimised(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
