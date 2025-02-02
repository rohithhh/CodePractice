package stack;

import java.util.Stack;

public class SumOfSubArrMin {
	public static void main(String[] args) {
		int[] arr = {3, 1, 2, 5};
		System.out.println(sumSubarrayMins(arr));
	}
	
	//Here we find out individual contributions and multiply them to i
	//To understand better consider example {1,4,6,7,3,7,8,1} and find nse(right) and psee(left) of 3
    public static int sumSubarrayMins(int[] arr) {
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);
        // Size of array
        int n = arr.length;
        
        int mod = (int)1e9 + 7; // Mod value
        
        // To store the sum
        int sum = 0;
        
        // Traverse on the array
        for (int i = 0; i < n; i++) {
        	//left is calculated by finding the index previous smaller ele of i 
        	int left = i-psee[i];
        	//right calculated by finding the index previous greater ele of i 
        	int right = nse[i]-i;
            /* Count of subarrays where 
            current element is minimum */
            long freq = left * right * 1L;
            
            // Contribution due to current element 
            int val = (int)((freq * arr[i]) % mod);
            
            // Updating the sum
            sum = (sum + val) % mod;
        	
        }
        return sum;
    }
	
    /* Function to find the indices of 
    next smaller elements */
    private static int[] findNSE(int[] arr) {
        
        // Size of array
        int n = arr.length;
        
        // To store the answer
        int[] ans = new int[n];
        
        // Stack 
        Stack<Integer> st = new Stack<>();
        
        // Start traversing from the back
        for (int i = n - 1; i >= 0; i--) {
            
            /* Pop the elements in the stack until 
            the stack is not empty and the top 
            element is not the smaller element */
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            
            // Update the answer
            ans[i] = !st.isEmpty() ? st.peek() : n;
            
            /* Push the index of current 
            element in the stack */
            st.push(i);
        }
        
        // Return the answer
        return ans;
    }
    
    /* Function to find the indices of 
    previous smaller or equal elements */
    private static int[] findPSEE(int[] arr) {
        
        // Size of array
        int n = arr.length;
        
        // To store the answer
        int[] ans = new int[n];
        
        // Stack 
        Stack<Integer> st = new Stack<>();
        
        // Traverse on the array
        for (int i = 0; i < n; i++) {
            
            /* Pop the elements in the stack until 
            the stack is not empty and the top 
            elements are greater than the current element */
        	//considering only > since = ele are already being taken care of in findNSE
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            
            // Update the answer
            ans[i] = !st.isEmpty() ? st.peek() : -1;
            
            /* Push the index of current 
            element in the stack */
            st.push(i);
        }
        
        // Return the answer
        return ans;
    }
	
}
