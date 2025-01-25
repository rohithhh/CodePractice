package greedy;

import java.util.Arrays;
import java.util.HashMap;

public class JobSequencing {
	public static void main(String[] args) {
		 int[][] Jobs = {
		            {1, 2, 100},
		            {2, 1, 19},
		            {3, 2, 27},
		            {4, 1, 25},
		            {5, 1, 15}
		        };
		System.out.println(Arrays.toString(JobScheduling(Jobs)));
	}
	
    public static int[] JobScheduling(int[][] jobs) {
    	 Arrays.sort(jobs, (a, b) -> Integer.compare(b[2], a[2]));
    	 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	 int count = 0;
         int sum = 0;
    	 for(int i=0;i<jobs.length;i++) {
    		 int[] job = jobs[i];
    		 boolean b = true;
    		 if(!map.containsKey(job[1])) {
    			 count++;
    			 sum+=job[2];
    			 map.put(job[1], job[0]);
    			 b = false;
    		 }
    		 int deadline = job[1]-1;
    		 while(deadline >0 && b) {
    			 if(!map.containsKey(deadline)) {
        			 count++;
        			 sum+=job[2];
        			 map.put(deadline, job[2]);
        			 break;
        		 }
    			 deadline--;
    		 }
    	 }
    	 return new int[] {count,sum};
    }
    
    public static int[] JobSchedulingOptmised(int[][] jobs) {
    	 // Sorting jobs based on their profit (third element) in descending order
        Arrays.sort(jobs, (a, b) -> Integer.compare(b[2], a[2]));

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;

        // Iterate through the sorted jobs
        for (int i = 0; i < jobs.length; i++) {
            int jobId = jobs[i][0];
            int deadline = jobs[i][1];
            int profit = jobs[i][2];

            // Try to schedule the job at the latest available slot
            while (deadline > 0 && map.containsKey(deadline)) {
                deadline--;  // Check previous slot
            }

            // If a free slot is found
            if (deadline > 0) {
                // Schedule the job at this slot
                map.put(deadline, jobId);
                count++;   // Increment count for successful job scheduling
                sum += profit;  // Add the profit for this job
            }
        }

        // Return the result as an array containing the count and sum
        return new int[]{count, sum};
   }
}
