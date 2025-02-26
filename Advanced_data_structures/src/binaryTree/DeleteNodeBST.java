package binaryTree;

public class DeleteNodeBST {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);

		// Level 1 nodes
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);

		// Level 2 nodes
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		TreeNode node =deleteNodeIterative(root, 2);
		System.out.println(node);
	}

	public static TreeNode deleteNode(TreeNode root, int key) {
		  if (root == null) return null; // If the tree is empty

	        // Find the node to be removed
	        if (key < root.data) {
	            root.left = deleteNode(root.left, key); // Go to the left subtree
	        } else if (key > root.data) {
	            root.right = deleteNode(root.right, key); // Go to the right subtree
	        } else {
	            // Node found, now handle the 3 cases

	            // Case 1: Node has no children (leaf node)
	            if (root.left == null && root.right == null) {
	                root = null;
	            }
	            // Case 2: Node has one child
	            else if (root.left == null) {
	                root = root.right; // Replace node with right child
	            } else if (root.right == null) {
	                root = root.left; // Replace node with left child
	            }
	            // Case 3: Node has two children
	            else {
	                // Find the in-order successor (the smallest node in the right subtree)
	                TreeNode successor = findMin(root.right);
	                root.data = successor.data; // Copy the successor's value to this node
	                root.right = deleteNode(root.right, successor.data); // Remove the successor
	            }
	        }

	        return root;
	    }

	    // Helper method to find the minimum value node (in-order successor)
	    private static TreeNode findMin(TreeNode root) {
	        while (root.left != null) {
	            root = root.left;
	        }
	        return root;
	    }
	
	public static TreeNode deleteNodeIterative(TreeNode root, int key) {
        TreeNode parent = null;
        TreeNode current = root;

        // Find the node and its parent
        while (current != null && current.data != key) {
            parent = current;
            if (key < current.data) {
                current = current.left; // Move to the left subtree
            } else {
                current = current.right; // Move to the right subtree
            }
        }

        // If the node is not found, return the root
        if (current == null) {
            return root;
        }

        // Case 1: Node has no children (leaf node)
        if (current.left == null && current.right == null) {
            if (current == root) {
                return null; // If the node to remove is the root itself
            } else if (parent.left == current) {
                parent.left = null; // Disconnect the left child
            } else {
                parent.right = null; // Disconnect the right child
            }
        }
        // Case 2 & 3: Node has one or two children
        else {
            TreeNode child;

            // If the node has one child or two children
            if (current.left == null) {
                child = current.right; // Only right child
            } else if (current.right == null) {
                child = current.left; // Only left child
            } else {
                // Node has two children, find the in-order successor
                TreeNode successorParent = current;
                TreeNode successor = current.right;

                // Find the leftmost node in the right subtree (in-order successor)
                while (successor.left != null) {
                    successorParent = successor;
                    successor = successor.left;
                }

                // Replace the current node's data with the successor's data
                current.data = successor.data;

                // Remove the successor node
                if (successorParent.left == successor) {
                    successorParent.left = successor.right; // Remove successor
                } else {
                    successorParent.right = successor.right; // Remove successor
                }

                return root; // Return root after successor replacement
            }

            // If the node to be removed is the root, return its child
            if (current == root) {
                return child;
            }

            // Otherwise, connect the parent to the child
            if (parent.left == current) {
                parent.left = child; // Attach the child to the parent
            } else {
                parent.right = child; // Attach the child to the parent
            }
        }

        return root; // Return the modified tree
	}
}
