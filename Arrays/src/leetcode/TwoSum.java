package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/two-sum/description/
public class TwoSum {
	public static void main(String[] args) {
		int[] nums= {1,3,4,2};
		System.out.println(Arrays.toString(twoSum(nums,6)));
	}
	
    public static int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i=0;i<nums.length;i++) 
    		map.put(nums[i], i);
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for(int i=0;i<nums.length;i++) {
    		int diff = target-nums[i];
    		int check = map.getOrDefault(diff,0);
    		if(check!=0 && check>i) {
    			list.add(i);
    			list.add(check);
    		}
    	}
    	//int[] arr = returnList.stream().mapToInt(i->i).toArray();-> for all possible scenarios
    	int[] arr = list.stream()
                .limit(2)  // Take only the first 2 elements
                .mapToInt(i -> i)
                .toArray();

		return arr;
    }
    
    public static int[] twoSumOptmised(int[] nums, int target) {
        int n = nums.length;
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++){
            int complimentary = target - nums[i];
            if(map.containsKey(complimentary)){
                return new int[]{map.get(complimentary),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution found");
    }
}
