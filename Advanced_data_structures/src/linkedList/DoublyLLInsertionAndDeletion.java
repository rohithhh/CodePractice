package linkedList;

public class DoublyLLInsertionAndDeletion {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		DoubleNode head = convertArrToLLAndReturnHeadOptimised(arr);
		DoubleNode insertAtEnd = appendEleAtEndOfDLL(head,5);
		DoubleNode deleteAtEnd = deleteEleAtEndOfDLL(insertAtEnd);
		DoubleNode insertAtStart = apendEleAtStartOfDLL(deleteAtEnd,0);
		DoubleNode deleteAtStart = deleteEleAtStartOfLL(insertAtStart);
		DoubleNode insertAtK = insertAtKInLL(deleteAtStart,5,2);
		DoubleNode deleteAtK = deleteAtKInLL(insertAtK,2);
	}
	
	private static DoubleNode deleteAtKInLL(DoubleNode head, int i) {
		if(i==1) {
			DoubleNode temp = head;
			temp = temp.next;
			temp.prev = null;
			return temp;
		}
		int count = 0;
		DoubleNode temp = head;
		while(temp!=null) {
			count++;
			if(count==i-1) {
				temp.next=temp.next.next;
				temp.next.prev=temp;
			}
			temp=temp.next;
		}
		return head;
	}

	private static DoubleNode insertAtKInLL(DoubleNode head, int ele, int i) {
		int count = 0;
		DoubleNode temp = head;
		if (i == 0) {
		    // Insert at the head
		    DoubleNode newNode = new DoubleNode(ele);
		    newNode.next = head;
		    if (head != null) {
		        head.prev = newNode;
		    }
		    head = newNode; // Update head to the new node
		    return head;
		}
		while(temp != null) {
			count++;
			if(count ==i-1) {
				DoubleNode newNode = new DoubleNode(ele);
				newNode.prev= temp;
				newNode.next =temp.next;
				 if (temp.next != null) {
			            temp.next.prev = newNode;
			        }
				temp.next=newNode;
				break;
			}
			temp=temp.next;
		}
		return head;
	}

	private static DoubleNode deleteEleAtStartOfLL(DoubleNode head) {
		DoubleNode temp = head;
		temp = temp.next;
		temp.prev = null;
		return temp;
	}

	private static DoubleNode apendEleAtStartOfDLL(DoubleNode head, int i) {
		DoubleNode newNode = new DoubleNode(i); // Create the new node
		if (head != null) {
		    // If the list is not empty, link the current head node to the new node
		    newNode.next = head;
		    head.prev = newNode;
		}

		// Set the head of the list to the new node
		head = newNode; 

		return head; 
	}

	private static DoubleNode deleteEleAtEndOfDLL(DoubleNode head) {
		if(head == null)
			return head;
		DoubleNode temp = head;
		while(temp.next.next!=null) {
			temp = temp.next;
		}
		temp.next = null;
		return head;
	}
	
	private static DoubleNode appendEleAtEndOfDLL(DoubleNode head, int k) {
		if(head == null)
			return new DoubleNode(k);
		DoubleNode temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		DoubleNode newNode = new DoubleNode(k,null,temp);
		temp.next=newNode;
		return head;
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
