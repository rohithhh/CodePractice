package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public static void main(String[] args) {
		int[] nums = {2, 3};
		System.out.println(subsetSums(nums));
	}
	
    public static List<Integer> subsetSums(int[] nums) {
    	List<Integer> result = new ArrayList<Integer>();
    	int sum=0;
    	func(result,0,sum,nums);
    	return result;
    }

	private static void func(List<Integer> result, int i, int sum, int[] nums) {
		if(i==nums.length) {
			result.add(sum);
			return ;
		}
		//Considering element
		func(result, i+1, sum+nums[i], nums);
		//Not considering element
		func(result, i+1, sum, nums);
	}
}
