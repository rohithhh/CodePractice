package recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
	public static void main(String[] args) {
		int[] nums = {1, 2};
		System.out.println(powerSet(nums));
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
