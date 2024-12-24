package leetcode;

public class MissingNumber {
	public static void main(String[] args) {
		int[] nums = {3,0,1};
		System.out.println(missingNumberOptmised(nums));
	}
	
	public static int missingNumber(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i: nums) {
        	if(i>max)
        		max=i;
        }
        int[] arr = new int[max+2];
        for(int i : nums)
        	arr[i]++;
        for(int i =0;i<=max+1;i++) {
        	if(arr[i]==0)
        		return i;
        }
        return 0;
    }
	
	//this doesn't work in case of [0,1] expected is 2 but we get 0
	//here missing number has be from nums[0]->nums[n-1]
	public static int missingNumberOptmised(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i: nums) {
        	if(i>max)
        		max=i;
        }
        //arithmetic progression of 1+2+3+..+n is n*(n+1)/2
        int sum=max*(max+1)/2;
        //0+1+2+3=6
        for(int i : nums)
    	   sum-=i;
        //6-3=3,3-0=3,3-1=2
        return sum;
        // return 2
    }
}
