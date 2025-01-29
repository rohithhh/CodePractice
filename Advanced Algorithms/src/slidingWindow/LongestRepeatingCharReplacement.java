package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharReplacement {
	public static void main(String[] args) {
		String s = "BAABAABBBAAA" ;
		int k = 2;
		System.out.println(characterReplacement(s, k));
	}
	
    public static int characterReplacement(String s, int k) {
    	int n = s.length();             // Get the length of the string
    	int maxlen = 0;                 // To store the maximum length of valid substring
    	int maxf = 0;                   // To track the highest frequency of a character in the window
    	int l = 0, r = 0;               // Left and right pointers of the sliding window
    	Map<Character, Integer> map = new HashMap<>();  // Map to store frequency of characters

    	// Slide the right pointer `r` over the string
    	while (r < n) {
    	    char ch = s.charAt(r);      // Get the current character
    	    map.put(ch, map.getOrDefault(ch, 0) + 1);  // Increment the frequency of this character
    	    maxf = Math.max(maxf, map.get(ch));        // Update the max frequency of any character in the window

    	    // If the window size minus the frequency of the most frequent character exceeds `k`
    	    while ((r - l + 1) - maxf > k) {
    	        char ch2 = s.charAt(l);         // Get the character at the left pointer
    	        map.put(ch2, map.get(ch2) - 1); // Decrement its frequency
    	        l++;                            // Move the left pointer right to shrink the window
    	    }

    	    // Calculate the length of the current valid window
    	    maxlen = Math.max(maxlen, r - l + 1);

    	    r++;  // Expand the window by moving the right pointer
    	}

    	return maxlen;  // Return the maximum length of the valid substring
    }
    
    public static int characterReplacementOptmised(String s, int k) {
        /* Variable to store the maximum
        length of substring found*/
        int maxLen = 0;
        
        /* Variable to track the maximum frequency
        of any single character in the current window*/
        int maxFreq = 0;
        
        // Pointers to maintain the current window [l, r]
        int l = 0, r = 0;
        
        // Hash array to count frequencies of characters
        int[] hash = new int[26];

        // Iterate through each starting point of substring
        while (r < s.length()) {
            /* Update frequency of current
            character in the hash array*/
            hash[s.charAt(r) - 'A']++;
            
            // Update max frequency encountered
            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);
            
            // Check if current window is invalid
            if ((r - l + 1) - maxFreq > k) {
                /* Slide the left pointer to 
                make the window valid again*/
                hash[s.charAt(l) - 'A']--;
                
                // Move left pointer forward
                l++;
            }
            
            /* Update maxLen with the length 
            of the current valid substring*/
            maxLen = Math.max(maxLen, r - l + 1);
            
            // Move right pointer forward to expand window
            r++;
        }

        /* Return the maximum length of substring
        with at most k characters replaced*/
        return maxLen;
    }   
}
