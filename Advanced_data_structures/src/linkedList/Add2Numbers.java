package linkedList;
///https://leetcode.com/problems/add-two-numbers/
public class Add2Numbers {
	public static void main(String[] args) {
		int[] arr = {9,9,9,9,9,9,9};
		int[] arr1 = {9,9,9,9};
		Node l1 = convertArrToLLAndReturnHeadOptimised(arr);
		Node l2 = convertArrToLLAndReturnHeadOptimised(arr1);
		Node res = addTwoNumbers(l1,l2);
	}
	
	public static Node addTwoNumbers(Node l1, Node l2) {
		Node dummyHead = new Node(0);
		Node current = dummyHead;
        
        int carry = 0;
        
        // Traverse both linked lists until both are null
        while (l1 != null || l2 != null) {
            int sum = carry;
            
            // Add the value from l1 if present
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            
            // Add the value from l2 if present
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            
            // Calculate carry and the digit for the current place
            carry = sum / 10;
            current.next = new Node(sum % 10);
            
            // Move the current pointer to the next node
            current = current.next;
        }
        
        // If there's any remaining carry, add it as a new node
        if (carry > 0) {
            current.next = new Node(carry);
        }
        
        // The result is in dummyHead.next (skip the dummy node)
        return dummyHead.next;
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
