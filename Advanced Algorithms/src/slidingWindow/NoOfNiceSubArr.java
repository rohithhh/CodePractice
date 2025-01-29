package slidingWindow;

import java.util.HashMap;

public class NoOfNiceSubArr {
	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 1, 1};
		System.out.println(numberOfOddSubarrays(nums, 3));
	}
	
    public static int numberOfOddSubarrays(int[] nums, int k) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int l=0,r=0;
    	int oddCount=0,count=0;
    	while(r<nums.length) {
    		int ele = nums[r];
    		map.put(ele, map.getOrDefault(ele, 0)+1);
    		if(ele%2!=0)
    			oddCount++;
    		while(oddCount==k) {
    			count++;
    			int leftEle = nums[l];
    			map.put(leftEle, map.get(leftEle)-1);
    			if(map.get(leftEle)==0)
    				map.remove(leftEle);
    			if(leftEle%2!=0)
    				oddCount--;
    			l++;
    		}
    		r++;
    	}
    	return count;
    }
}
