package leetcode;

import java.util.HashMap;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class RemoveDuplicates {
	public static void main(String[] args) {
		int[] arr= {1,1,2};
		System.out.println(removeDuplicates(arr));
		}

	 public static int removeDuplicates(int[] arr) {
		 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		 int i=0,count=0;
		 while(i<arr.length) {
			 map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			 if(map.get(arr[i])==1) {
				 count=count+1;
			 }
			 else {
				 i++;
				 continue;
			 }
			 i++;
		 }
		return count;
	    }
}
