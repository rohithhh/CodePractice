package leetcode;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/majority-element/
public class MajorityElement {
	public static void main(String[] args) {
		int[] arr = {1000000000,1000000000,-1000000000,-1000000000,-1000000000};
		System.out.println(majorityElement(arr));
	}
	
    public static int majorityElement(int[] arr) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i : arr) 
    		map.put(i, map.getOrDefault(i, 0)+1);
    	int max =Integer.MIN_VALUE;
    	int n = arr.length;
    	for(int i : arr) {
    		if(max<=i && map.get(i)>(n/2))
    			max =i;
 
    	}
		return max;
    }
}
