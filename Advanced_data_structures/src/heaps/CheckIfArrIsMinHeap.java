package heaps;

public class CheckIfArrIsMinHeap {
	public static void main(String[] args) {
		int[] nums = {10, 20, 30, 21, 23};
		System.out.println(isHeap(nums));
	}
	
    public static boolean isHeap(int[] nums) {
    	int n = nums.length;
    	for(int i = (n/2)-1;i>=0;i--) {
    		int leftChild=2*i+1;
    		int rightChild=2*i+2;
            if(leftChild < n && nums[leftChild] < nums[i])
                return false;
            if(rightChild < n && nums[rightChild] < nums[i])
                return false;
    	}
    	return true;
    }
}
