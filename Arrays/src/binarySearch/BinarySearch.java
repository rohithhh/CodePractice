package binarySearch;
//https://leetcode.com/problems/binary-search/description/
public class BinarySearch {
	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12};
		System.out.println(search(nums, 2));
	}
	
    public static int search(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while(low<high) {
        	 int mid=(low+high)/2;
        	 if(nums[mid]== target) 
        		 return mid;
        	 else if(nums[mid]<target)
        		 low=mid+1;
        	 else
        		 high=mid-1;
        }
        return -1;
    }
}
