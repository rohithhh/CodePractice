package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {
	public static void main(String[] args) {
		int[] candidates = {2, 1, 2, 7, 6, 1, 5};
		System.out.println(combinationSum2Better(candidates, 8));
	}
	
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	Set<List<Integer>> set = new HashSet<List<Integer>>();
    	List<Integer> current = new ArrayList<Integer>();
    	func(set,current,0,candidates,candidates.length,target);
    	List<List<Integer>> result = new ArrayList<List<Integer>>(set);
    	return result;
    }

	private static void func(Set<List<Integer>> set, List<Integer> current, int index, int[] candidates, int length, int sum) {
		if(sum==0) {
			set.add(new ArrayList<Integer>(current));
			return;
		}
		if(sum<0 || index ==length) {
			return ;
		}
		current.add(candidates[index]);
		func(set, current, index+1, candidates, length, sum-candidates[index]);
		current.remove(current.size()-1);
		func(set, current, index+1, candidates, length, sum);
	}
	
    public static List<List<Integer>> combinationSum2Better(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();

        // Sort candidates to handle duplicates
        Arrays.sort(candidates);

        // Start the recursive process
        func1(0, target, nums, candidates, ans);
        return ans;
    }
    
    
    private static void func1(int index, int sum, List<Integer> nums, int[] candidates, List<List<Integer>> ans) {
        // If the sum is zero, add the current combination to the result
        if (sum == 0) {
            ans.add(new ArrayList<>(nums));
            return;
        }

        // If the sum is negative or we have exhausted the candidates, return
        if (sum < 0 || index == candidates.length) return; 

        // Include the current candidate
        nums.add(candidates[index]);

        // Recursively call with updated sum and next index
        func1(index + 1, sum - candidates[index], nums, candidates, ans);

        // Backtrack by removing the last added candidate
        nums.remove(nums.size() - 1);

        // Skip duplicates: if not picking the current candidate, 
        // ensure the next candidate is different
        for(int i = index + 1; i < candidates.length; i++) {
            if(candidates[i] != candidates[index]) {
                func1(i, sum, nums, candidates, ans);
                break;
            }
        }
	}

	public static List<List<Integer>> combinationSum2Optimised(int[] candidates, int target) {
        Arrays.sort(candidates); // Sort to handle duplicates easily
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Found a valid combination
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            // Skip if coming element is same as currrent element
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break; // No point in continuing if the number exceeds the target

            current.add(candidates[i]);
            // Recur with updated target and the next starting index (i + 1)
            backtrack(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}
