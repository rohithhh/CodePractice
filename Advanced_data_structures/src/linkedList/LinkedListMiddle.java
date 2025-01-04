package linkedList;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/middle-of-the-linked-list/
public class LinkedListMiddle {
	public static void main(String[] args) {
		int[] arr = {1,2};
		Node head = convertArrToLLAndReturnHeadOptimised(arr);
		Node middleNode = middleNode(head);
		System.out.println(printEleinNode(middleNode));
	}
	
	private static List<Integer> printEleinNode(Node middleNode) {
		List<Integer> list = new ArrayList<Integer>();
		while(middleNode != null) {
			list.add(middleNode.data);
			middleNode = middleNode.next;
		}
		return list;
	}

	public static Node middleNode(Node head) {
		if(head == null || head.next == null)
			return head;
		Node slow = head;
		Node fast = head;
		while(fast!= null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
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
}
