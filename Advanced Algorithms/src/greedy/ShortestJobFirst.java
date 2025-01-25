package greedy;

import java.util.Arrays;

public class ShortestJobFirst {
	public static void main(String[] args) {
		int[] bt = {4, 1, 3, 7, 2};
		System.out.println(solve(bt));
	}
	
	public static long solve(int[] bt) {
	       Arrays.sort(bt);
	       long sum=0;
	       long t=0;
	       int n = bt.length;
	       for(int i=0;i<n-1;i++){
	        sum+=bt[i];
	        t+=sum;
	       }
	       return t/n;
	}
}
