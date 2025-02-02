package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-i/description/
public class NextEleGreater1 {
	public static void main(String[] args) {
		int[] nums1 = {4,1,2};
		int[] nums2 = {1,3,4,2};
		System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
	}
    
	//Using similar logic in next greater ele, but we use map to store the stack.peek so that we can use that to write to our array accordingly
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	Stack<Integer> stack = new Stack<Integer>();
    	int[] result = new int[nums1.length];
    	stack.push(-1);
    	for(int i=nums2.length-1;i>=0;i--) {
    		while(!stack.isEmpty() && nums2[i]>=stack.peek())
    			stack.pop();
    		if(stack.isEmpty())
    			map.put(nums2[i], -1);
    		else
    			map.put(nums2[i], stack.peek());
    		stack.push(nums2[i]);
    	}
    	
        for (int i = 0; i < nums1.length; i++) {
        	result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
