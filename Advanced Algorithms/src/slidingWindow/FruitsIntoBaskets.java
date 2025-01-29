package slidingWindow;

import java.util.HashMap;

public class FruitsIntoBaskets {
	public static void main(String[] args) {
		int[] fruits = {23,27,27,23,23,27,27,27,23,23,27,27,27,23,23,23,23,23,27,23,23,27,23,23,27,23,27,23,23,23,27,27,23,23,27,23,23,19,7,35,33,5,14,37,20,40,30,16,17,22,49,19,42};
		System.out.println(totalFruits(fruits));
	}
	
    public static int totalFruits(int[] fruits) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int max=0,l=0,r=0;
    	while(r<fruits.length) {
    		map.put(fruits[r], map.getOrDefault(fruits[r],0)+1);
    		if(map.size()>2) {
    			map.put(fruits[l], map.get(fruits[l])-1);
    			if(map.get(fruits[l])==0)
    				map.remove(fruits[l]);
    			l++;
    		}
    		if(map.size()<=2)
    			max = Math.max(max, r-l+1);
    		r++;
    	}
		return max;
    }
}
