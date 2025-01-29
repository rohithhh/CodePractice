package slidingWindow;

import java.util.HashMap;

public class LongestSubArrWithKDistinctChar {
	public static void main(String[] args) {
		String s = "aababbcaacc" ;
		int k = 2;
		System.out.println(kDistinctChar(s, k));
	}
	
    public static int kDistinctChar(String s, int k) {
    	int l=0,r=0,max=0;
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	while(r<s.length()) {
    		map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
    		while(map.size()>k) {
    			map.put(s.charAt(l), map.get(s.charAt(l))-1);
    			if(map.get(s.charAt(l))==0)
    				map.remove(s.charAt(l));
    			l++;
    		}
    		if(map.size()<=k)
    			max = Math.max(max, r-l+1);
    		r++;
    	}
    	return max;
    }
}
