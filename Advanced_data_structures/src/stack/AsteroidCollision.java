package stack;

import java.util.Arrays;
import java.util.Stack;
//https://leetcode.com/problems/asteroid-collision/
public class AsteroidCollision {
	public static void main(String[] args) {
		int[] asteroids = {2, -2};
		System.out.println(Arrays.toString(asteroidCollision(asteroids)));
	}
	
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < asteroids.length; i++) {
        	if(asteroids[i] > 0) {
        		stack.push(asteroids[i]);
            }
        	else {
        		while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroids[i])>stack.peek())
        			stack.pop();
        		if (!stack.isEmpty() && stack.peek() == Math.abs(asteroids[i]))
        			stack.pop();
        		else if (stack.isEmpty() || stack.peek() < 0) 
                       stack.push(asteroids[i]);
        	}
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.pop();  // Note: `stack.get(i)` is available in List, not in Stack
        }
        
        return result;
    }
}
