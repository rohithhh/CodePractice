package prefixSum;

import java.util.Arrays;

public class ProductOfArrExceptSelf {
	public static void main(String[] args) {
		int [] nums = {1,2,3,4};
		System.out.println(Arrays.toString(productExceptSelfOptimised(nums)));
	}
	
    public static int[] productExceptSelf(int[] nums) {
        int mul=1,i,zeroIndex=-1;
        int[] arr = new int[nums.length];
        for(i=0;i<nums.length;i++) {
        	if(nums[i]==0 && zeroIndex ==-1) {
        		zeroIndex=i;
        		continue;
        	}
        	mul*=nums[i];
        }
        if(mul==0)
        	return arr;
        if(zeroIndex>=0) {
        	arr[zeroIndex]=mul;
        	return arr;
        }
        for(i=0;i<nums.length;i++) {
        	arr[i]=mul/nums[i];
        }
        return arr;
    }
    
    public static int[] productExceptSelfOptimised(int[] nums) {
    	int n = nums.length;
        int[] prefix = new int[n];
        int[] postfix = new int[n];
        int[] result = new int[n];
        
        // Step 1: Initialize prefix and postfix arrays
        prefix[0] = 1;
        postfix[n - 1] = 1;
        
        // Step 2: Fill the prefix array(this contains elements multiplication before i)
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        
        // Step 3: Fill the postfix array(this contains elements multiplication after i)
        for (int i = n - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i + 1];
        }
        
        // Step 4: Calculate result by multiplying corresponding prefix and postfix
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * postfix[i];
        }
        
        return result;
    }
}
