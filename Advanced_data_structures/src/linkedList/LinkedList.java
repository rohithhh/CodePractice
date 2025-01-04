package linkedList;

class Node{
	int data;
	Node next;
	
	Node(int data1, Node next1){
		this.data=data1;
		this.next=next1;
	}
	
	Node(int data1){
		this.data=data1;
		this.next=null;
	}
}

public class LinkedList {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		Node head = convertArrToLLAndReturnHeadOptimised(arr);
		System.out.println(lengthOfLL(head));
		System.out.println(findEleinLL(head, 2));
	}
	
	private static Node convertArrToLLAndReturnHead(int[] arr) {
		//Store fist ele of the attay into node and point the pointer(next) to null
		Node head = new Node(arr[0]);
		//Create a mover and point it to the 1st ele(head
		Node mover = head;
		//Now gradually update the pointer to the upcoming ele till the end of arr
		for(int i=1;i<arr.length;i++) {
			//Create a temp node that takes 1st ele and points to null
			Node temp = new Node(arr[i]);
			//Update the mover pointer to the new ele
			mover.next=temp;
			//move the temp into mover
			mover=temp;
		}
		return head;
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
	
	private static int lengthOfLL(Node head) {
		int count=0;
		Node temp = head;
		while(temp!=null) {
			temp=temp.next;
			count++;
		}
		return count;
	}
	
	private static boolean findEleinLL(Node head , int key) {
		Node temp = head;
		while(temp!=null) {
			if(temp.data == key)
				return true;
			temp=temp.next;
		}
		return false;
	}
}
