package linkedList;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromLL {
	public static void main(String[] args) {
		int[] arr = {1,2};
		Node head = convertArrToLLAndReturnHeadOptimised(arr);
		Node nRemoved = removeNthFromEnd(head, 1);
		System.out.println(printEleinNode(nRemoved));
	}
	
	private static List<Integer> printEleinNode(Node temp) {
		List<Integer> list = new ArrayList<Integer>();
		while(temp != null) {
			list.add(temp.data);
			temp = temp.next;
		}
		return list;
	}
	
	private static Node convertArrToLLAndReturnHeadOptimised(int[] arr) {
		  if (arr == null || arr.length == 0) return null;
		    
		    Node head = new Node(arr[0]);
		    Node mover = head;
		    
		    //update next and data
		    for (int i = 1; i < arr.length; i++) {
		        mover.next = new Node(arr[i]);
		        mover = mover.next;
		    }
		    
		    return head;
	}
	
    public static Node removeNthFromEnd(Node head, int n) {
    	 // Edge case: if the list is empty or has only one element
        if (head == null || head.next == null) {
            return null;  // or return head if you prefer to return empty list
        }
        
        // Step 1: Find the total number of nodes in the list
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        
        // Step 2: Find the position of the node to remove (from the start)
        int removeNode = count - n; // This is the index of the node to remove
        
        // Edge case: If the node to remove is the head node
        if (removeNode == 0) {
            return head.next; // The new head is the next node
        }
        
        // Step 3: Traverse the list and remove the node at removeNode
        temp = head;
        Node prev = null;
        count = 0;
        while (temp != null) {
            if (count == removeNode) {
                // Remove the node by skipping it
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
            count++;
        }
        
        return head; // Return the modified list
    }
}
