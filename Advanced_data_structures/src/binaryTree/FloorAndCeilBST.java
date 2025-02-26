package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class FloorAndCeilBST {
	public static void main(String[] args) {
        TreeNode root = new TreeNode(8);

        // Level 1 nodes
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);

        // Level 2 nodes
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        System.out.println(floorCeilOfBST(root, 11));
	}
	
    public static List<Integer> floorCeilOfBST(TreeNode root, int key) {
    	List<Integer> list = new ArrayList<Integer>();
    	int floor = -1, ceil = -1;
    	while(root!=null) {
    		 if (root.data == key) {
                 floor = root.data;
                 ceil = root.data;
                 break;
             }
    		if(root.data<key) {
    			floor=root.data;
    			root=root.right;
    		}else {
    			ceil=root.data;
    			root=root.left;
    		}
    	}
        list.add(floor);
        list.add(ceil);
    	return list;
    }
}
