package greedy;

import java.util.Arrays;

public class MinNoOfPlatformsRequired {
	public static void main(String[] args) {
		int[] Arrival = {900, 940, 950, 1100, 1500, 1800};
		int[] Departure = {910, 1200, 1120, 1130, 1900, 2000};
		System.out.println(findPlatform(Arrival, Departure));
	}
	
    public static int findPlatform(int[] arrival, int[] departure) {
        // Sort arrival and departure arrays
        Arrays.sort(arrival);
        Arrays.sort(departure);
        
        int n = arrival.length;
        int platforms = 1;  // At least one platform is needed for the first train
        int result = 1;     // Keep track of the maximum number of platforms needed
        
        int i = 1;  // Pointer for arrival
        int j = 0;  // Pointer for departure
        
        while (i < n && j < n) {
            // If the next train arrives after the previous one departs, no new platform needed
            if (arrival[i] > departure[j]) {
            	platforms--; // Platform is freed up
                j++;  // Train departs, free one platform
            } else {
                platforms++;  // A new platform is needed
                i++;  // New train arrives
            }
            
            // Track the maximum platforms used at any time
            result = Math.max(result, platforms);
        }
        
        return result;
    }
}
