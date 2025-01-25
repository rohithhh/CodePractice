package stack;

import java.util.Arrays;
import java.util.Stack;

///https://leetcode.com/problems/daily-temperatures/
public class DailyTemperatures {
	public static void main(String[] args) {
		int[] temperatures = {73,74,75,71,69,72,76,73};
		System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
	}
	
    public static int[] dailyTemperatures(int[] temperatures) {
    	Stack<Integer> stack = new Stack<Integer>();
    	int n = temperatures.length;
    	int[] res = new int[n]; 
        for (int i = 0; i < n; i++) {
            // Check if the current temperature is greater than the temperature at the stack's top
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;  // Calculate the number of days to wait for a warmer temperature
            }
            // Push the current index onto the stack
            stack.push(i);
        }
    	return res;
    }
}
