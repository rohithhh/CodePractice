package slidingWindow;

public class MaxConsecutiveOnes {
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
		int k = 2;
		System.out.println(longestOnes(nums, k));
	}
	
    public static int longestOnes(int[] nums, int k) {
    	int max=0,n=k;
    	int r=0,l=0;
    	while(r<nums.length) {
    		if(nums[r]==0)
    			n--;
    		while(n<0) {
    			if(nums[l]==0)
    				n++;
    			l++;
    		}
    		max=Math.max(max, r-l+1);
    		r++;
    	}
    	return max;
    }
}
