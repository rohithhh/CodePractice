package linkedList;
//https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list
public class DeleteAllOccurancesInDLL {
	public static void main(String[] args) {
		int[] arr = {2,2,10,8,4,2,5,2};
		DoubleNode head = DoublyLinkedList.convertArrToLLAndReturnHeadOptimised(arr);
		deleteAllOccurOfX(head,2);
	}
	
	static DoubleNode deleteAllOccurOfX(DoubleNode head, int x) {
	    // Check if the list is empty
	    if (head == null) {
	        return null;
	    }

	    // Handle the case where the head itself contains the value x
	    while (head != null && head.data == x) {
	        head = head.next;  // Move head to the next node
	        if (head != null) {
	            head.prev = null;  // Remove the previous pointer for the new head
	        }
	    }

	    // Traverse the list and remove nodes with the value x
	    DoubleNode temp = head;
	    while (temp != null) {
	        if (temp.data == x) {
	            // Skip the current node by updating the previous and next nodes
	            if (temp.prev != null) {
	                temp.prev.next = temp.next;  // Update previous node's next pointer
	            }
	            if (temp.next != null) {
	                temp.next.prev = temp.prev;  // Update next node's prev pointer
	            }
	        }
	        temp = temp.next;
	    }

	    return head;  // Return the (potentially updated) head
	}

}
