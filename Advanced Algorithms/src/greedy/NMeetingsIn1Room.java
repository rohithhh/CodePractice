package greedy;

import java.util.ArrayList;
import java.util.List;

public class NMeetingsIn1Room {
	public static void main(String[] args) {
		int[]  Start = {1, 3, 0, 5, 8, 5};
		int[] End = {2, 4, 6, 7, 9, 9};
		System.out.println(maxMeetings(Start, End));
	}
	
    public static int maxMeetings(int[] start, int[] end) {
    	int n = start.length;
    	List<int[]> meetings = new ArrayList<>();
    	for (int i = 0; i < n; i++) {
            meetings.add(new int[]{start[i], end[i]});
        }
    	//sort via end time
    	meetings.sort((a,b)->Integer.compare(a[1], b[1]));
    	//get first(0th) meeting end time
    	int endTime = meetings.get(0)[1];
    	//count=1 since we are starting from 1
    	int count=1;
    	for(int i=1;i<n;i++) {
    		//check if start time is more than current end time(if more than we can proceed to next meeting)
    		if(meetings.get(i)[0] > endTime) {
    			endTime = meetings.get(i)[1];
    			count++;
    		}
    	}
    	return count;
     }
}
