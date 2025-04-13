package recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
	public static void main(String[] args) {
		int[] nums = {1, 2, 2};
		System.out.println(powerSet(nums));
	}
	
    public static List<List<Integer>> powerSetIterative(int[] nums) {
    	   List<List<Integer>> result = new ArrayList<>();
           result.add(new ArrayList<>()); // Start with the empty subset
           
           // Iterate through each number in the array
           for (int num : nums) {
               int size = result.size();
               // For each existing subset, create a new subset by adding the current element
               for (int i = 0; i < size; i++) {
                   List<Integer> currentSubset = result.get(i); // Get the existing subset
                   List<Integer> newSubset = new ArrayList<>(currentSubset); // Create a new list by copying
                   newSubset.add(num); // Add the current number to the new subset
                   result.add(newSubset); // Add the new subset to the result
               }
           }
           
           return result;
    }
    public static List<List<Integer>> powerSet(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> current = new ArrayList<Integer>();
    	backtrack(0, nums.length, nums, current, result);
    	return result;
    }

	private static void backtrack(int index, int n, int[] nums, List<Integer> current, List<List<Integer>> result) {
		if(index==n) {
			result.add(new ArrayList<Integer>(current));
			return ;
		}
		current.add(nums[index]);
		backtrack(index+1, n, nums, current, result);
		current.remove(current.size()-1);
		backtrack(index + 1, n, nums, current, result);
	}
}
