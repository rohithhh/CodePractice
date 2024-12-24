package leetcode;

public class MaxConsecutiveOnes {
	public static void main(String[] args) {
		int[] nums = {1,0,1,1,0,1};
		System.out.println(findMaxConsecutiveOnes(nums));
	}
    public static int findMaxConsecutiveOnes(int[] nums) {
    	int[] arr = new int[2];
    	int max = 0;
		//increment 1 count till you find 0 at 0 reset it to 0
    	for(int i : nums) {
    		if(i==0)
    			arr[1]=0;
    		else
    			arr[i]++;
    		max=Math.max(max, arr[1]);
    	}
        return max;
    }
    
    public static int findMaxConsecutiveOnesOptimised(int[] nums) {
        int max=0;
        int count=0;
    	//using count to keep track of 1 count and if you find 0 update the max value of 1 and reset to 0
        for(int i : nums) {
        	if(i==1)
        		count++;
        	else {
        		 max=Math.max(max,count);
                 count=0;
        	}
        }
        return Math.max(max,count);
    }
}
