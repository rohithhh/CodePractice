package stack;

import java.util.Stack;

public class RemoveKDigits {
	public static void main(String[] args) {
		System.out.println(removeKdigits("1002991", 3));
	}
	
    public static String removeKdigits(String nums, int k) {
        Stack<Character> st = new Stack<Character>();
        for(int i =0;i<nums.length();i++) {
        	 char digit = nums.charAt(i);
        	 while(!st.isEmpty() && st.peek()>digit && k>0) {
        		 st.pop();
        		 k--;
        	 }
        	 st.push(digit);
        }
        while(!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }
        if(st.isEmpty()) 
        	return "0";
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()) {
            res.append(st.pop());
        }
        // Trimming the zeroes at the back
        while(res.length() > 0 && 
              res.charAt(res.length() - 1) == '0') {

            res.deleteCharAt(res.length() - 1);
        }
        res.reverse();
        if(res.length() == 0) return "0";
        return res.toString();
    }
    
    public String removeKdigitsOptimised(String num, int k) {
        if (k == num.length()) {
             return "0";
         }

         char[] digits = num.toCharArray();
         char[] stack = new char[digits.length];
         int stackTop = -1;
         int removalCount = k;

         for (int i = 0; i < digits.length; i++) {
             while (removalCount > 0 && stackTop >= 0 && stack[stackTop] > digits[i]) {
                 stackTop--;
                 removalCount--;
             }
             stackTop++;
             stack[stackTop] = digits[i];
         }

         int nonZeroStart = 0;

         while (stack[nonZeroStart] == '0' && nonZeroStart < digits.length - k - 1) {
             nonZeroStart++;
         }

         return String.valueOf(stack, nonZeroStart, digits.length - k - nonZeroStart);

     }
}
