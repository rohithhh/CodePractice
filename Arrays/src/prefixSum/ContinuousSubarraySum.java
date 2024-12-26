package prefixSum;

import java.util.HashMap;

public class ContinuousSubarraySum {
	public static void main(String[] args) {
		int[] nums = {1,0};
		System.out.println(checkSubarraySum(nums,2));
	}
	
    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;

        // Initialize the HashMap and prefix sum
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;

        // Initialize the map with a base case where a prefix sum of 0 is found at index -1
        map.put(0, -1);  // This handles the case when the subarray starts at index 0

        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            // Update the prefix sum
            prefixSum += nums[i];

            // Get the remainder when divided by k
            int remainder = prefixSum % k;

            // Handle the case of negative remainders (though your array is positive, we do this for correctness)
            if (remainder < 0) {
                remainder += k;
            }

            // If the remainder has been seen before and the subarray has at least two elements
            if (map.containsKey(remainder)) {
            	//i - map.get(remainder) gets the len of subArray that is divisible by k
                if (i - map.get(remainder) > 1) {
                    return true;
                }
            } else {
                // Store the first occurrence of the remainder with its index
                map.put(remainder, i);
            }
        }

        return false; // No valid subarray found
    }
}
