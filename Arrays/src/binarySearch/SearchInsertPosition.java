package binarySearch;
//https://leetcode.com/problems/search-insert-position/description/
public class SearchInsertPosition {
	public static void main(String[] args) {
		int[] nums = {1,2,4,5,7,8,9,10,11};
		System.out.println(searchInsert(nums, 3));
	}
	
    public static int searchInsert(int[] nums, int target) {
    	int low=0,high=nums.length-1;
    	while(low<=high) {
    		int mid = (low+high)/2;
    		if(target == nums[mid])
    			return mid;
    		if(nums[mid] < target)
    			low=mid+1;
    		else
    			high=mid-1;
    			
    	}
		return low;
    }
}
