package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceWithSumK {
	public static void main(String[] args) {
		int [] nums = {1, 2, 3, 4, 5};
		int k = 8;
		System.out.println(returnSubsequences(nums, k));
	}
	
	 public static List<List<Integer>> returnSubsequences(int[] nums, int k) {
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 List<Integer> current = new ArrayList<Integer>();
		 findSubsequences(nums, 0, k, current, result);
		 return result;
	 }

	private static void findSubsequences(int[] arr, int index, int k, List<Integer> current, List<List<Integer>> result) {
		if(index == arr.length) {
			 if (sum(current) == k) {
	                result.add(new ArrayList<>(current));
	            }
			 return ;
		}
		current.add(arr[index]);
		findSubsequences(arr, index + 1, k, current, result);
		current.remove(current.size()-1);
        findSubsequences(arr, index + 1, k, current, result);
	}

	private static int sum(List<Integer> current) {
        int total = 0;
        for (int num : current) {
            total += num;
        }
        return total;
	}
}
