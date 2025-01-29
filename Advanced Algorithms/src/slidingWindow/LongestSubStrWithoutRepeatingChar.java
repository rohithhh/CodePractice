package slidingWindow;

import java.util.HashMap;

public class LongestSubStrWithoutRepeatingChar {
	public static void main(String[] args) {
		String S = "aaabbbccc";
		System.out.println(longestNonRepeatingSubstring(S));
	}
	
    public static int longestNonRepeatingSubstring(String s) {
    	Integer l=0,r=0,maxlen=0,n=s.length();
		HashMap<Character, Integer> map = new  HashMap<>();
		while(r<n) {
			if(map.containsKey(s.charAt(r))) {
				if(map.get(s.charAt(r))>=l)
					 l=map.get(s.charAt(r))+1;
			}
			maxlen=Math.max(maxlen, r-l+1);
			map.put(s.charAt(r), r);
			r++;
		}
		return maxlen;
    }
}
