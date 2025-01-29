package slidingWindow;

public class NoOfSubStrContainingAll3Char {
	public static void main(String[] args) {
		String s = "ccabcc";
		System.out.println(numberOfSubstrings(s));
	}
	
    public static int numberOfSubstrings(String s) {
    	 int[] lastSeen = {-1, -1, -1};
         
         int count = 0;
         
         // Iterate through each character in string s
         for (int i = 0; i < s.length(); ++i) {
             
             // Update lastSeen index 
             lastSeen[s.charAt(i) - 'a'] = i;
             
             /* Check if all characters 'a',
             'b', 'c' have been seen*/
             if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                 
                 /* Count valid substrings
                 ending at current index*/
                 count += 1 + Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]);
             }
         }
         
         // Return the total count of substrings
         return count;
    	
    }
}
