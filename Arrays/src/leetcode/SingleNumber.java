package leetcode;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/single-number/description/
public class SingleNumber {
	public static void main(String[] args) {
		int[] arr = {4,1,2,1,2};
		System.out.println(singleNumber(arr));
	}
	
    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==1)
                return entry.getKey();
        }
        return 0;
    }
}
