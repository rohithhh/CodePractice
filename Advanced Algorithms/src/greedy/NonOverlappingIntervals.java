package greedy;

import java.util.Arrays;

public class NonOverlappingIntervals {
	public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {1, 4},
                {3, 5},
                {3, 4},
                {4, 5}
            };
        System.out.println(MaximumNonOverlappingIntervals(intervals));
	}
	
    public static int MaximumNonOverlappingIntervals(int[][] intervals) {
    	Arrays.sort(intervals,(a,b)->Integer.compare(a[1], b[1]));
    	int end = intervals[0][1];
    	int count=1;
    	int n = intervals.length;
    	for(int i=1;i<n;i++) {
    		 /* Check if the starting time of the current 
            interval is greater than or equal to 
            the ending time of the last 
            selected interval */
    		if(intervals[i][0]>=end) {
    			count++;
    			end = intervals[i][1];
    		}
    	}
		return n - count;
    }
}
