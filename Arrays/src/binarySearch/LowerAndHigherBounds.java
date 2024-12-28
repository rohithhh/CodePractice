package binarySearch;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/ceil-the-floor2802/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=ceil-the-floor
//https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1?track=DSASP-Searching&amp%253BbatchId=154&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=floor-in-a-sorted-array
public class LowerAndHigherBounds {
	public static void main(String[] args) {
		int[] arr = {26, 46, 47, 73, 3, 42, 86, 57, 22, 52};
		System.out.println(Arrays.toString(getFloorAndCeil(59,arr)));
		
	}
	
    static int findFloor(int[] arr, int k) {
    	int low=0,high=arr.length-1,maxMid=-1;
    	while(low<=high) {
    		int mid=(low+high)/2;
    		if(arr[mid]<=k)
    			maxMid=Math.max(maxMid, mid);
    		if(arr[mid]>k)
    			high=mid-1;
    		else
    			low=mid+1;
    	}
    	return maxMid !=-1 ? maxMid :-1;
    }
    
    static int findCeil(int[] arr, int k) {
    	int low=0,high=arr.length-1,maxMid=-1;
    	while(low<=high) {
    		int mid=(low+high)/2;
    		if(arr[mid]>=k)
    			maxMid=Math.max(maxMid, mid);
    		if(arr[mid]>k)
    			high=mid-1;
    		else
    			low=mid+1;
    	}
    	return maxMid !=-1 ? maxMid :-1;
    }
    
    //for unsorted array
    public static int[] getFloorAndCeil(int x, int[] arr) {
    	int low=0,floor=-1,ceil=-1;
    	while(low<arr.length) {
    		if(arr[low]<=x)
    			floor=Math.max(floor, arr[low]);
    		if(arr[low]>=x)
    			ceil= ceil!=-1 ? Math.min(ceil, arr[low]) : arr[low];
    		low++;
    	}
    	return new int[]{floor,ceil};
    }
}
