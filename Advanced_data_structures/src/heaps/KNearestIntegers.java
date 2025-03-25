package heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KNearestIntegers {
	public static void main(String[] args) {
		int[] arr = {4, 1, 3, 2, 5};
		int k = 3, x = 3;
		System.out.println(kNearestIntegers(arr,k,x));
	}
	
	 public static List<Integer> kNearestIntegers(int[] arr, int k, int x) {
	       PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
	            int diffA = Math.abs(a - x);
	            int diffB = Math.abs(b - x);
	            if (diffA == diffB) {
	                return Integer.compare(b, a);  // If diffs are same, prioritize smaller number.
	            }
	            return Integer.compare(diffB, diffA);  // Max-heap: remove the element with largest difference.
	        });

	        // Traverse through the array and maintain a heap of size k
	        for (int num : arr) {
	            maxHeap.offer(num);
	            if (maxHeap.size() > k) {
	                maxHeap.poll();  // Remove the element with the largest difference from the heap
	            }
	        }

	        // Convert heap to a list
	        List<Integer> result = new ArrayList<>(maxHeap);
	        
	        // Sort the result in ascending order
	        Collections.sort(result);
	        
	        return result;
	    }
}
