package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class TopViewOfBT {
	public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(topView(root));
	}
	
    public static List<Integer> topView(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(root.data);
    	addLeftEle(root,list);
    	addRightEle(root,list);
    	return list;
    }

	private static void addRightEle(TreeNode root, List<Integer> list) {
		root=root.right;
		while(root!=null) {
			list.add(root.data);
		}
	}

	private static void addLeftEle(TreeNode root, List<Integer> list) {
		root=root.left;
		while(root!=null)
			list.add(root.data);
	}  
}
