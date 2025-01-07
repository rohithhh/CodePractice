package linkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenLL {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		Node head = convertArrToLLAndReturnHeadOptimised(arr);
		Node oddEvenList = oddEvenList(head);
		System.out.println(printEleinNode(oddEvenList));
	}
	
	private static List<Integer> printEleinNode(Node temp) {
		List<Integer> list = new ArrayList<Integer>();
		while(temp != null) {
			list.add(temp.data);
			temp = temp.next;
		}
		return list;
	}
	
	public static Node oddEvenList(Node head) {
		Queue<Integer> even = new LinkedList<Integer>();
		Queue<Integer> odd = new LinkedList<Integer>();
		int i=1;
		Node temp=head;
		while(temp!=null) {
			if(i%2==0)
				even.add(temp.data);
			else
				odd.add(temp.data);
			temp=temp.next;
			i++;
		}
		Node returnNode = new Node(odd.poll());
		Node mover = returnNode;
		while(!odd.isEmpty()) {
			mover.next=new Node(odd.poll());
			mover=mover.next;
		}
		while(!even.isEmpty()) {
			mover.next=new Node(even.poll());
			mover=mover.next;
		}
		return returnNode;
	}
	
	public static Node oddEvenListOptimised(Node head) {
		 // Edge case: if the list is empty or has only one element
	    if (head == null || head.next == null)
	        return head;
	    
	    // Pointers for odd and even lists
	    Node oddHead = head;  // Start with the first element as the odd-indexed node
	    Node evenHead = head.next;  // The second element is the even-indexed node
	    
	    // Pointers to build the two lists
	    Node odd = oddHead;
	    Node even = evenHead;
	    
	    // Traverse the list and rearrange the nodes
	    Node current = evenHead.next;
	    int index = 3;  // Start with index 3 since oddHead is 1st and evenHead is 2nd

	    while (current != null) {
	        if (index % 2 == 1) {  // Odd index
	            odd.next = current;
	            odd = odd.next;
	        } else {  // Even index
	            even.next = current;
	            even = even.next;
	        }
	        current = current.next;
	        index++;
	    }
	    
	    // End both odd and even lists correctly
	    odd.next = evenHead;
	    even.next = null;  // Ensure the last node's next is null
	    
	    return oddHead;
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
