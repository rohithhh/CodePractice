package binarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class FirstAndLastPositionOFEle {
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		System.out.println(Arrays.toString(searchRange(nums, 8)));
	}
	
    public static int[] searchRange(int[] nums, int target) {
    	 int low = 0, high = nums.length - 1;
    	    
    	    // First binary search to find the left bound (first occurrence)
    	    int start = -1;
    	    while (low <= high) {
    	        int mid = low + (high - low) / 2;
    	        if (nums[mid] == target) {
    	            start = mid;
    	            high = mid - 1;  // Continue searching in the left half for the first occurrence
    	        } else if (nums[mid] < target) {
    	            low = mid + 1;
    	        } else {
    	            high = mid - 1;
    	        }
    	    }
    	    
    	    // If the target is not found, return [-1, -1]
    	    if (start == -1) {
    	        return new int[]{-1, -1};
    	    }
    	    
    	    // Now perform binary search to find the right bound (last occurrence)
    	    int end = -1;
    	    low = start;  // Start searching from the 'start' index
    	    high = nums.length - 1;
    	    
    	    while (low <= high) {
    	        int mid = low + (high - low) / 2;
    	        if (nums[mid] == target) {
    	            end = mid;
    	            low = mid + 1;  // Continue searching in the right half for the last occurrence
    	        } else if (nums[mid] < target) {
    	            low = mid + 1;
    	        } else {
    	            high = mid - 1;
    	        }
    	    }
    	    
    	    return new int[]{start, end};
    }
}
