package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams {
	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
	}
	
	public static List<Integer> findAnagrams(String s, String p){
		HashMap<Character, Integer> m1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> m2 = new HashMap<Character, Integer>();
		int k = p.length();
		for(int i=0;i<k;i++) {
			m1.put(p.charAt(i), m1.getOrDefault(p.charAt(i), 0)+1);
		}
		List<Integer> list = new ArrayList<Integer>();
		int l=0,r=0;
		while(r<s.length()) {
			m2.put(s.charAt(r), m2.getOrDefault(s.charAt(r), 0)+1);
			if(r-l+1>=k) {
				if(m2.equals(m1))
					list.add(l);
				m2.put(s.charAt(l), m2.getOrDefault(s.charAt(l), 0)-1);
        		if(m2.get(s.charAt(l))==0)
        			m2.remove(s.charAt(l));
        		l++;
			}
			r++;
		}
		return list;
	}
}
