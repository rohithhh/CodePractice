package heaps;

import java.util.Arrays;

public class HeapifyAlogirthm {
	public static void main(String[] args) {
		 int[] nums = {1, 4, 5, 5, 7, 6};
	     int ind = 5, val = 2;
	     heapify(nums, ind, val);
	     System.out.println("Modified array after heapifying: " + Arrays.toString(nums));
	}
	
    public static void heapify(int[] nums, int index, int val) {
    		if(nums[index]>val) {
    			nums[index]=val;
    			heapifyUp(nums, index);
    		}else {
    			nums[index]=val;
    			heapifyDown(nums, index);
    		}
    		return ;
    }
    
    private static void heapifyDown(int[] arr, int index) {
    	int n =arr.length;
    	int smallestIndex = index;
    	int leftChild = (index*2)+1;
    	int rightChild = (index*2)+2;
    	/*
    	 * leftChild < n ensures that the left child index does not exceed the size of the heap. 
    	 * If the left child index is beyond the heap size n, 
    	 * it means the node has no left child, and checking it would result in an error or accessing invalid memory.
    	 */
    	if(leftChild < n && arr[leftChild] < arr[smallestIndex])
    	    smallestIndex = leftChild;
    	/*
    	 * rightChild < n checks the same thing for the right child. 
    	 * If the right child index is beyond the heap size, the node does not have a right child, so there's no need to perform the comparison.
    	 */
    	if(rightChild < n && arr[rightChild] < arr[smallestIndex])
    	    smallestIndex = rightChild;
    	// If the largest element index is updated
        if (smallestIndex != index) {
        	int temp = arr[smallestIndex];
        	arr[smallestIndex] = arr[index];
        	arr[index] = temp;
        	
        	heapifyDown(arr, smallestIndex);
        }
        return ;
    }
    
    private static void heapifyUp(int[] arr, int index) {
    	int parentIndex = (index-1)/2;
    	/*
    	 * index > 0 checks whether the current node has a parent. 
    	 * In the heap, the parent of any node at index i is located at (i-1)/2. When index = 0, it refers to the root node, which has no parent.
    	 */
    	if(index> 0 && arr[index]<arr[parentIndex]) {
    		int temp = arr[index];
    		arr[index] = arr[parentIndex];
    		arr[parentIndex] = temp;
    		heapifyUp(arr, parentIndex);
    	}
    	return ;
    }
}
