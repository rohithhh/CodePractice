package linkedList;

import java.util.Stack;
//https://leetcode.com/problems/palindrome-linked-list/
public class CheckLLPalindrome {
	public static void main(String[] args) {
		int[] arr = {1,2,2,1};
		Node head = convertArrToLLAndReturnHeadOptimised(arr);
		System.out.println(isPalindrome(head));
	}
	
	 public static boolean isPalindrome(Node head) {
		 Stack<Integer> stack = new Stack<Integer>();
		 Node temp = head;
		 while(temp!=null) {
			 stack.push(temp.data);
			 temp=temp.next;
		 }
		 temp=head;
		 while(temp!=null) {
			 if(temp.data!=stack.getLast())
				 return false;
			 temp=temp.next;
			 stack.pop();
		 }
		 return true;
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
