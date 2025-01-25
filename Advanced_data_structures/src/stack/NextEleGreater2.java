package stack;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-ii/description/
public class NextEleGreater2 {
	public static void main(String[] args) {
		int[] nums = {1,2,1};
		System.out.println(Arrays.toString(nextGreaterElements(nums)));
	}
	
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = nums.length;
        int[] res = new int[n];
        //going with 2n since we have a circular array
        for(int i=2*n-1;i>=0;i--) {
        	while(!stack.isEmpty() && stack.peek()<=nums[i%n])
        		stack.pop();
        	if(i<n) {
        		res[i]=stack.isEmpty()?-1:stack.peek();
        	}
        	stack.push(nums[i%n]);
        }
        return res;
    }
}
