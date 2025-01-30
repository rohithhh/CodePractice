package slidingWindow;

public class BinaryArraysWithSum {
	public static void main(String[] args) {
		int [] nums = {1, 1, 0, 1, 0, 0, 1};
		System.out.println(numSubarraysWithSum(nums, 3));
	}
	
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal)- helper(nums, goal-1);
    }
    
    //Gives out, no of sub arr where sum<=goal 
    private static int helper(int[] nums, int goal) {
    	if(goal<0)
    		return 0;
    	int l=0,r=0,sum=0,count=0;
    	while(r<nums.length) {
    		sum+=nums[r];
    		while(sum>goal) {
    			sum-=nums[l];
    			l++;
    		}
    		count=count+(r-l+1);
    		r++;
    	}
    	return count;
    }
}
