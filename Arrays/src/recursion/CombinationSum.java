package recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum {
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		System.out.println(combinationSum(candidates,7));
	}
	
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> currrent = new ArrayList<Integer>();
    	func(0,candidates,candidates.length,target,currrent,result);
		return result;
    }

	private static void func(int index, int[] candidates, int n, int sum, List<Integer> current, List<List<Integer>> result) {
		if(sum==0) {
			result.add(new ArrayList<Integer>(current));
			return ;
		}
		if(sum<0 || index==n)
			return ;
		current.add(candidates[index]);
		//Considering current element
		func(index, candidates, n, sum-candidates[index], current, result);
		current.remove(current.size()-1);
		//Moving to next element along with current element
		func(index+1, candidates, n, sum, current, result);
	}
}
