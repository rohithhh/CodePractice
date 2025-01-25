package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerEle {
	public static void main(String[] args) {
		int[]  A = {3, 2, 1};
		System.out.println(Arrays.toString(prevSmaller(A)));
	}
	
    public static int[] prevSmaller(int[] A) {
    	Stack<Integer> stack = new Stack<Integer>();
    	int n = A.length;
    	int[] ans = new int[n];
    	stack.push(-1);
    	for(int i=0;i<n;i++) {
    		while(!stack.isEmpty() && A[i]<stack.peek())
    			stack.pop();
    		if(stack.isEmpty())
    			ans[i]=-1;
    		else
    			ans[i]=stack.peek();
    		stack.push(A[i]);
    	}
    	return ans;
    }
}
