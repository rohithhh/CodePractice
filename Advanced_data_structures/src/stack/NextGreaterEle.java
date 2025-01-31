package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterEle {
	public static void main(String[] args) {
		int[] arr = {6, 8, 0, 1, 3};
		System.out.println(Arrays.toString(nextLargerElement(arr)));
	}
	
    public static int[] nextLargerElementBruteforce(int[] arr) {
    	int n = arr.length;
		int[] result = new int[n];
		for(int i=0;i<n;i++) {
			int num = -1;
			for(int j=i+1;j<n;j++) {
				if(arr[j]>arr[i]) {
					num=arr[j];
					break;
				}
			}
			result[i]=num;
		}
		return result;
    }
    
    public static int[] nextLargerElement(int[] arr) {
    	Stack<Integer> stack = new Stack<Integer>();
    	int n = arr.length;
    	int[] result = new int[n];
    	stack.push(-1);
    	for(int i = n-1;i>=0;i--) {
    		while(!stack.isEmpty() && arr[i]>=stack.peek())
    			stack.pop();
    		result[i]=stack.isEmpty()?-1:stack.peek();
    		stack.push(arr[i]);
    	}
    	return result;
    }
    
}
