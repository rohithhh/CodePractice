package slidingWindow;

import java.util.HashMap;

public class MinWindowSubStr {
	public static void main(String[] args) {
		String s = "DDDAAABBCA" , t = "ABC";
		System.out.println(minWindowOptmised(s, t));
	}
	
    public static String minWindow(String s, String t) {
    	 // Variable to store the minimum length of substring found
        int minLen = Integer.MAX_VALUE;
        
        // Variable to store the starting index of the minimum length substring
        int sIndex = -1;
        
        // HashMap to count frequencies of characters in string t
        HashMap<Character, Integer> hash = new HashMap<>();
        
        // Count the frequencies of characters in t
        for (char c : t.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }
        
        int count = 0; // To count how many characters from t are in the current window
        int l = 0, r = 0;
        
        // Iterate through the current window
        while (r < s.length()) {
            char rightChar = s.charAt(r);
            
            // If the current character is part of t
            if (hash.containsKey(rightChar)) {
            	 if (hash.get(rightChar) >= 0) {
                     count++;
                 }
                hash.put(rightChar, hash.get(rightChar) - 1);
            }
            
            // If all characters from t are found in the current window
            while (count == t.length()) {
                // Update minLen and sIndex if the current window is smaller
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }
                
                // Remove leftmost character from window
                char leftChar = s.charAt(l);
                if (hash.containsKey(leftChar)) {
                    hash.put(leftChar, hash.get(leftChar) + 1);
                    if (hash.get(leftChar) > 0) {
                        count--;
                    }
                }
                l++; // Shrink the window from the left
            }
            r++; // Expand the window from the right
        }
        
        // Return minimum length substring from s
        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minLen);
    }
    
    public static String minWindowOptmised(String s, String t) {
        
        /* Variable to store the minimum 
        length of substring found */
        int minLen = Integer.MAX_VALUE;
        
        /* Variable to store the starting index
        of the minimum length substring */
        int sIndex = -1;
        
        /* Array to count frequencies
        of characters in string t*/
        int[] hash = new int[256];
        
        // Count the frequencies of characters in t
        for (char c : t.toCharArray()) {
            hash[c]++;
        }
            
        int count = 0;
        int l = 0, r = 0;
        
        // Iterate through current window 
        while (r < s.length()) {
            // Include the current character in the window
            if (hash[s.charAt(r)] > 0) {
                count++;
            }
            hash[s.charAt(r)]--;
                
            /* If all characters from t 
            are found in current window */
            while (count == t.length()) {
                    
                /* Update minLen and sIndex
                if current window is smaller */
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }
                
                // Remove leftmost character from window
                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }
        
        // Return minimum length substring from s
        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minLen);
    }    
}
