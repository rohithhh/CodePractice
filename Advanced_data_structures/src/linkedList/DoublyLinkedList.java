package linkedList;

class DoubleNode{
	int data;
	DoubleNode next;
	DoubleNode prev;
	
	DoubleNode(int data1, DoubleNode next1, DoubleNode prev1){
		this.data=data1;
		this.next=next1;
		this.prev=prev1;
	}
	
	DoubleNode(int data1){
		this.data=data1;
		this.next=null;
		this.prev=null;
	}
}

public class DoublyLinkedList {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		DoubleNode head = convertArrToLLAndReturnHeadOptimised(arr);
	}

	private static DoubleNode convertArrToLLAndReturnHeadOptimised(int[] arr) {
		DoubleNode head = new DoubleNode(arr[0]);
		DoubleNode prev = head;
		for(int i=1;i<arr.length;i++) {
			DoubleNode temp = new DoubleNode(arr[i],null,prev);
			prev.next = temp;
			prev = prev.next;
		}
		return head;
	}
	
}
