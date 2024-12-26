package prefixSum;

import java.util.HashMap;
//https://leetcode.com/problems/contiguous-array/description/?envType=problem-list-v2&envId=prefix-sum
public class ContiguousArray {
	public static void main(String[] args) {
		int[] nums = {0,0,1,0,0,0,1,1};
		System.out.println(findMaxLength(nums));
	}
	
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum = 0, maxlen = 0;
        
        // Initialize map with the prefix sum of 0 at index -1 to handle the case when subarray starts from index 0
        map.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            // Convert 0 to -1 for the purpose of calculating the balance of 0s and 1s
            if (nums[i] == 0) {
                nums[i] = -1;
            }
            
            // Update the prefix sum
            preSum += nums[i];
            
            // If the same prefix sum has been encountered before, calculate the length of the subarray
            if (map.containsKey(preSum)) {
                // The length of the subarray is the difference between current index and the first occurrence of the same prefix sum
                int length = i - map.get(preSum);
                maxlen = Math.max(maxlen, length); // Update maxlen with the maximum length found
            } else {
                // Store the first occurrence of this prefix sum
                map.put(preSum, i);
            }
        }
        
        return maxlen;
    }
}
