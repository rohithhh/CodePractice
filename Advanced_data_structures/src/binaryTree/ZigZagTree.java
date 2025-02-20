package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTree {
	public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        
        // Level 1 nodes
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        
        // Level 2 nodes
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(6); // explicitly setting the right child as null
        root.right.left = null; // explicitly setting the left child as null
        root.right.right = new TreeNode(4);
        
        // Level 3 nodes
        root.left.left.left = new TreeNode(6); // explicitly setting the left child as null
        root.left.left.right = null;
        
        System.out.println(zigzagLevelOrder(root));
	}
	
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> parent = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int n=0;
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
        	n++;
        	size = q.size();
        	if(n%2==0)
        		parent.add(child.reversed());
        	else
        		parent.add(child);
        }
        return parent;
    }
}
