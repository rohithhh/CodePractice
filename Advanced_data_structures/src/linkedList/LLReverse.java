package linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/reverse-linked-list/description/
public class LLReverse {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		Node head = convertArrToLLAndReturnHeadOptimised(arr);
		Node reverse = reverseLLOptimised(head);
		System.out.println(printEleinNode(reverse));
	}
	
	//TC=O(2N) SC=O(N)
	private static Node reverseLL(Node head) {
		//Use stack to put data inside the node
		Stack<Integer> stack = new Stack<Integer>();
		Node temp = head;
		while(temp != null) {
			stack.push(temp.data);
			temp = temp.next;
		}
		//Now again point temp to head
		temp = head;
		while(temp!=null) {
			temp.data=stack.getLast();
			stack.pop();
			temp=temp.next;
		}
		return head;
	}
	/*
	 * 1,2,3,4
	 * 1= temp, 2 = front, temp.next = null, prev = 1, 2 = temp
	 * 2=temp , 3 = front. temp.next = 1, prev =2, 3 = temp
	 * 3=temp, 4 = front, temp.next = 2, prev = 3, 4 = temp;
	 * 4=temp, null = front, temp.next = 3, prev =4, null=temp
	 */
	private static Node reverseLLOptimised(Node head) {
		Node temp = head;
		Node prev = null;
		while(temp!=null) {
			Node front = temp.next;
			temp.next=prev;
			prev=temp;
			temp=front;
		}
		return prev;
	}


	private static List<Integer> printEleinNode(Node middleNode) {
		List<Integer> list = new ArrayList<Integer>();
		while(middleNode != null) {
			list.add(middleNode.data);
			middleNode = middleNode.next;
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
}
