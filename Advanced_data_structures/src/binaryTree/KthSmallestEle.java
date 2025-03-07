package binaryTree;

public class KthSmallestEle {
	public static void main(String[] args) {
		
	}
	static int currCount = 0;
    public static int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        currCount = 0;
        return inorderTraversal(root, k);
    }

	private static int inorderTraversal(TreeNode root, int k) {
        if(root == null) return -1;

        int left = inorderTraversal(root.left, k);
        
        if(left != -1) return left;

        currCount++;

        if(currCount == k) return root.data;

        return inorderTraversal(root.right, k);
	}
}
