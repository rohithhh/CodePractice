package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CountAnagrams {
	public static void main(String[] args) {
		String txt = "aabaabaa";
		String	pat = "aaba";
		System.out.println(search(pat, txt));

	}
	static int search(String pat, String txt) {
        int count=0;
        int l=0,r=0;
        int k = pat.length();
        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        for(int i=0;i<k;i++) {
        	map1.put(pat.charAt(i),map1.getOrDefault(pat.charAt(i), 0)+1);
        }
        while(r<txt.length()) {
        	map2.put(txt.charAt(r), map2.getOrDefault(txt.charAt(r), 0)+1);
        	if(r-l+1>=k) {
        		if(map2.equals(map1))
        			count=count+1;
        		map2.put(txt.charAt(l), map2.getOrDefault(txt.charAt(l), 0)-1);
        		if(map2.get(txt.charAt(l))==0)
        			map2.remove(txt.charAt(l));
        		l++;
        	}
        	r++;
        }
        return count;
    }
}
