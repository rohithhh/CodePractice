package prefixSum;

public class SubArrProductLessThanK {
	public static void main(String[] args) {
		int[] nums = {1,1,1};
		System.out.println(numSubarrayProductLessThanK(nums, 1));
	}
	
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
    	int l=0,r=0,product=1,count=0;
    	while(r<nums.length) {
    		product = product*nums[r];
    		while(product>=k && l <= r) {
    			product = product/nums[l++];
    		}
    		count+=r-l+1;
    		r++;
    	}
		return count;
    }
}
