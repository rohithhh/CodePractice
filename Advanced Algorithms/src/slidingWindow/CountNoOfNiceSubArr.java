package slidingWindow;

public class CountNoOfNiceSubArr {
	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 1, 1};
		System.out.println(numberOfOddSubarrays(nums, 3));
	}
	
    public static int numberOfOddSubarrays(int[] nums, int k) {
    	return helper(nums, k)-helper(nums, k-1);
    }
    
    private static int helper(int[] nums, int k) {
    	int l=0,r=0;
    	int count=0,sum=0;
    	while(r<nums.length) {
    		sum+=(nums[r]%2);
    		while(sum>k) {
    			sum-=(nums[l]%2);
    			l++;
    		}
    		count+=r-l+1;
    		r++;
    	}
    	return count;
    }
}
