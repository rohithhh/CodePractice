package linkedList;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
public class DeleteMiddleNode {
	public static void main(String[] args) {
		int[] arr = {1,3,4,7,1,2,6};
		Node head = convertArrToLLAndReturnHeadOptimised(arr);
		Node middleRemoved = deleteMiddle(head);
		System.out.println(printEleinNode(middleRemoved));
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
	
    public static Node deleteMiddle(Node head) {
    	if(head== null || head.next == null)
    		return null;
    	Node slow = head;
    	Node fast = head;
    	while(fast!= null && fast.next != null) {
    		slow = slow.next;
    		fast=fast.next.next;
    	}
    	Node temp = head;
    	Node prev = null;
    	while(temp!=null) {
    		if(temp.equals(slow)) {
    			 prev.next = temp.next;
                 break;
    		}
    		prev=temp;
    		temp=temp.next;
    	}
		return head;
    }
    
    public static Node deleteMiddleOptimised(Node head) {
        // Edge case: if the list is empty or has only one node, return null
        if (head == null || head.next == null) {
            return null;
        }

        // Step 1: Use slow and fast pointers to find the middle node
        Node slow = head;
        Node fast = head;
        Node prev = null;  // To keep track of the node before slow

        // Move fast pointer by 2 steps and slow pointer by 1 step
        while (fast != null && fast.next != null) {
            prev = slow;           // prev will be the node before slow
            slow = slow.next;      // slow moves one step
            fast = fast.next.next; // fast moves two steps
        }

        // Step 2: Remove the middle node
        // prev points to the node before slow, so we update prev.next to skip slow
        if (prev != null) {
            prev.next = slow.next;
        }

        return head;
    }
}
