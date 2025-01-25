package greedy;

import java.util.ArrayList;
//https://leetcode.com/problems/insert-interval/
public class InsertInterval {
	public static void main(String[] args) {
		 int[][] intervals = {{1, 2}, {3, 4}, {6, 7}, {8, 10}, {12, 16}};
	     int[] newInterval = {5, 8};
	     insertNewInterval(intervals, newInterval);
	}
	
    public static int[][] insertNewInterval(int[][] intervals, int[] newInterval) {
    	ArrayList<int []> list = new ArrayList<int[]>();
    	int i=0;
    	int n = intervals.length;
    	while (i < n && intervals[i][1] < newInterval[0]) {
             /* Add intervals to the result list
             until their end time is before
             the start time of newInterval */
             
    		list.add(intervals[i]);
             // Move to next interval
             i++;
        }
    	 // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            /* Update the start time of newInterval to the
            minimum of its current start time and the
            start time of the current interval */
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            
            /* Update the end time of newInterval to the
            maximum of its current end time and the
            end time of the current interval */
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            
            // Move to the next interval
            i++;
        }
        list.add(newInterval);
        /* Insert remaining 
        intervals after 
        newInterval */
        while (i < n) {
            /* Add the remaining intervals
            after newInterval to the result
            list */
            list.add(intervals[i]);
            
            // Move to next interval
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }
}
