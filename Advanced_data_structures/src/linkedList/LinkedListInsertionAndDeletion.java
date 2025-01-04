package linkedList;
/*
 * In Java, objects (like nodes in a linked list) are passed by reference, not by value. This means when you pass a reference to an object (like temp), you're not passing a copy of that object.
 *  Instead, you're passing a reference (a pointer) to the original object in memory.
 *  So when you assign temp = head, you are not creating a new temp object. 
 *  Instead, temp is now pointing to the same node as head. Both temp and head are now references to the same linked list node.
 */
public class LinkedListInsertionAndDeletion {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		Node head = convertArrToLLAndReturnHeadOptimised(arr);
		Node deleteHead = deleteHead(head);
		Node insertHead = insertAtHead(deleteHead,1);
		Node deleteTail = deleteTail(insertHead);
		Node insertTail = insertAtTail(deleteTail,4);
		Node deleteAtIndexK = deleteAtIndexK(insertTail,2);
		Node insertAtK = insertAtK(deleteAtIndexK,2,2);
	}
	
	private static Node insertAtK(Node head, int ele, int i) {
		if(head ==null) {
			if(i==1)
				return new Node(ele);
			else
				return null;
		}
		if(i==1)
			return new Node(ele,head);
		Node temp = head;
		int count=0;
		//iterate till i-1(in case of 1 2 4, we will stop at 2
		while(temp!=null) {
			count++;
			/*
			 * once at i-1, create a new node with the ele you want to insert i.e 3
			 * Now point the new node to the next ele, point 3 to next ele i.e 4 beforing breaking connection between 2 and 4
			 * Now point current ele to new Node
			 */
			if(count==i-1) {
				Node newNode = new Node(ele);
				newNode.next=temp.next;
				temp.next=newNode;
				break;
			}
			temp=temp.next;
		}
		return head;
	}

	private static Node insertAtTail(Node head, int i) {
		if(head == null)
			return new Node(i);
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		//iterate till last, now create a new node with tail ele pointing to null
		Node newNode = new Node(i);
		//now point last ele in our node(temp.next) to this new node
		temp.next = newNode;
		return head;
	}

	private static Node insertAtHead(Node head, int i) {
		Node temp = new Node(i);
		temp.next = head;
		return temp;// or return new Node(i,head);
	}

	private static Node deleteAtIndexK(Node head, int k) {
		//if k=1 means delete first ele and if list is empty return head
		if(k==1) {
			head= head.next;
			return head;
		}
		Node temp = head;
		Node prev = null;
		int count=0;
		while(temp.next!= null) {
			count++;
			/*
			 * count ==k means we have to delete ele at k
			 * to delete at k we will pointing ele before k to ele after k
			 * 1-2-3-4, k==2=> 1-2-/3-/4 => 1-2-4
			 */
			if(count==k) {
				prev.next=prev.next.next;
				break;
			}
			prev=temp;
			temp=temp.next;
		}
		return head;
	}
	
	private static Node deleteValueK(Node head, int k) {
		//if k=1 means delete first ele and if list is empty return head
		if(head.data==k) {
			head= head.next;
			return head;
		}
		Node temp = head;
		Node prev = null;
		while(temp.next!= null) {
			/*
			 * search till you find that ele k
			 * to delete k we will pointing ele before k to ele after k
			 * 1-2-3-4, k==2=> 1-2-/3-/4 => 1-2-4
			 */
			if(temp.data==k) {
				prev.next=prev.next.next;
				break;
			}
			prev=temp;
			temp=temp.next;
		}
		return head;
	}

	private static Node deleteHead(Node head) {
		if(head == null)
			return head;
		head = head.next;
		return head;
	}
	
	private static Node deleteTail(Node head) {
		//checking if LL is empty or has only one ele
		if(head == null || head.next==null)
			return null;
		Node temp = head;
		// Stopping before 2nd last ele for ex 1 2 3 4, we are stopping at 3
		while(temp.next.next!= null) {
			temp=temp.next;
		}
		//now standing at 3, point next to null so, we will not be pointing to 4 anymore
		temp.next=null;
		//return the head
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
}
