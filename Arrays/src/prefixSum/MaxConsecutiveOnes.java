package prefixSum;

import java.util.HashMap;
//https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=problem-list-v2&envId=prefix-sum
public class MaxConsecutiveOnes {
	public static void main(String[] args) {
		int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
		System.out.println(longestOnes(nums, 2));
	}
	//for more optimised version go with int array of 0 and 1 instead of map
	 public static int longestOnes(int[] nums, int k) {
		 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		 int l=0,r=0,len=0,maxLen=0;;
		 while(r<nums.length) {
			 map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
			 while(map.getOrDefault(0, 0)>k) {
				 map.put(nums[l], map.get(nums[l])-1);
				 if(map.get(nums[l])==0)
					 map.remove(nums[l]);
				 l++;
			 }
			 len=r-l+1;
			 maxLen=Math.max(len, maxLen);
			 r++;
		 }
		return maxLen;
	 }
}
