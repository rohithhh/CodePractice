package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs {
	public static void main(String[] args) {
		int[] nums1 = {1,7,11};
		int[] nums2 = {2,4,6};
		int k = 3 ;
		System.out.println(kSmallestPairs(nums1, nums2, k));
	}
	
	 public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	        List<List<Integer>> result = new ArrayList<>();
	        
	        // Edge case: If any array is empty or k is zero, return empty result
	        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
	            return result;
	        }
	        
	        // Min-heap (priority queue) to store pairs of (sum, index1, index2)
	        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
	            (a, b) -> (a[0] - b[0]) // Compare by sum of the pairs
	        );
	        
	        // Initialize the heap with pairs from nums1[i] and nums2[0]
	        for (int i = 0; i < Math.min(k, nums1.length); i++) {
	            minHeap.add(new int[] { nums1[i] + nums2[0], i, 0 });
	        }
	        
	        // Process the heap and extract k smallest pairs
	        while (k-- > 0 && !minHeap.isEmpty()) {
	            int[] current = minHeap.poll();
	            int i = current[1];
	            int j = current[2];
	            
	            // Add the pair (nums1[i], nums2[j]) to the result
	            result.add(Arrays.asList(nums1[i], nums2[j]));
	            
	            // If there is a next element in nums2 for the current element in nums1
	            if (j + 1 < nums2.length) {
	                minHeap.add(new int[] { nums1[i] + nums2[j + 1], i, j + 1 });
	            }
	        }
	        
	        return result;
	    }
}
