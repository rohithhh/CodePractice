package prefixSum;
//https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=problem-list-v2&envId=prefix-sum
public class MinSubArrayLen {
	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7,nums));
	}
	
    public static int minSubArrayLen(int k, int[] nums) {
    	int minLen=0,l=0,r=0,preSum=0,len=0;;
    	while(r<nums.length) {
    		preSum+=nums[r];
    		while(preSum>=k) {
    			preSum-=nums[l];
    			len=r-l+1;
    			minLen = minLen != 0? Math.min(len, minLen):len;
    			l++;
    		}
    		r++;
    	}
        return minLen;
    }
}
