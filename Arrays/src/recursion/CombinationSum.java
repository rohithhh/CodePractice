package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum {
	public static void main(String[] args) {
		
	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	Map<Integer,Integer> map = new HashMap<Integer, Integer>();
    	int n = candidates.length;
    	for(int i=0;i<n;i++) {
    		map.put(candidates[i], i);
    	}
    	//List<Integer> list = new ArrayList<Integer>();
    	for(int i=0;i<n;i++) {
    		List<Integer> list = new ArrayList<Integer>();
    		int num = candidates[i];
    		while(num<=target) {
    			list.add(candidates[i]);
    			int diff = target - num;
    			if(map.containsKey(diff)) {
    				list.add(map.get(diff));
    			}
    		}
    		
    	}
		return null;
    }
}
