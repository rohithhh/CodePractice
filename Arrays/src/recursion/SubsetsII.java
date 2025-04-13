package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	public static void main(String[] args) {
		int[] nums = {1, 2, 2};
		Arrays.sort(nums);
		System.out.println(subsetsWithDup(nums));
	}
	
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> result = new ArrayList<>();
    	List<Integer> current = new ArrayList<Integer>();
    	funcOptimised(0,nums,current,result);
    	return result;
    }

	private static void func(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
		if(index==nums.length) {
			result.add(new ArrayList<Integer>(current));
			return ;
		}
		current.add(nums[index]);
		func(index+1, nums, current, result);
		current.remove(current.size()-1);
		for(int j=index+1;j<nums.length;j++) {
			 // Skip if coming element is same as currrent element
			if(nums[j] != nums[index]) {
				func(j, nums, current, result);
				return ;
			}
		}
		//in case if I dont find any repeating ele for ex 1 2 2 2
		func(nums.length, nums, current, result);
	}
	
    private static void funcOptimised(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Add the current subset to the result (empty subset will be added first)
        result.add(new ArrayList<>(current));

        // Iterate through the rest of the elements, starting from the current index
        for (int i = index; i < nums.length; i++) {
            // Skip duplicates: If the current element is the same as the previous one, continue
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // Include the current element and move forward
            current.add(nums[i]);
            // Recurse with the next index
            func(i + 1, nums, current, result);
            // Backtrack: remove the last element to explore the next possibility
            current.remove(current.size() - 1);
        }
    }
}
