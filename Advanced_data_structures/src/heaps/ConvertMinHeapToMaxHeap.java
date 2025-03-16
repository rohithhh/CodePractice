package heaps;

import java.util.Arrays;

public class ConvertMinHeapToMaxHeap {
	public static void main(String[] args) {
		int[] nums = {10, 20, 30, 21, 23};
		System.out.println(Arrays.toString(minToMaxHeap(nums)));
	}
	
    private static void heapifyDown(int[] arr, int ind) {
        int n = arr.length; // Size of the array

        // To store the index of largest element
        int largestInd = ind;

        // Indices of the left and right children
        int leftChildInd = 2*ind + 1;
        int rightChildInd = 2*ind + 2;
        
        // If the left child holds larger value, update the largest index
        //Generally, we check for arr[leftChild] < arr[largestInd], we are modifying this logic for sum
        if(leftChildInd < n && arr[leftChildInd] > arr[largestInd]) {
            largestInd = leftChildInd;
        }

        // If the right child holds larger value, update the largest index
        //Generally, we check for arr[rightChildInd] < arr[largestInd],we are modifying this logic for sum
        if(rightChildInd < n && arr[rightChildInd] > arr[largestInd]) {
            largestInd = rightChildInd;
        }

        // If the largest element index is updated
        if(largestInd != ind) {
            // Swap the largest element with the current index
            int temp = arr[largestInd];
            arr[largestInd] = arr[ind];
            arr[ind] = temp;

            // Recursively heapify the lower subtree
            heapifyDown(arr, largestInd);
        }
    }
	
    public static int[] minToMaxHeap(int[] nums) {
    	 int n = nums.length;
         for(int i = n/2 - 1; i >= 0; i--) {
             heapifyDown(nums, i);
         }
         return nums;
    }
}
