package heaps;

public class KthLargestEleInArr {
	public static void main(String[] args) {
		int[] nums = {3,2,3,1,2,4,5,5,6};
		int k = 2;
		System.out.println(findKthLargest(nums, k));
	}
	
    public static int findKthLargest(int[] nums, int k) {
        heapSort(nums);
        int n = nums.length;
        return nums[n-k];
    }

    private static void heapSort(int[] arr) {
    	buildMaxHeap(arr);
		int last = arr.length-1;
		while (last > 0) {
		    // Swap the root (maximum element) with the last element
		    int temp = arr[0];
		    arr[0] = arr[last];
		    arr[last] = temp;

		    // Decrease the size of the heap
		    last--;

		    if(last > 0)
		    	heapifyDown(arr, last, 0);
		}

	}

	private static void heapifyDown(int[] arr, int last, int index) {
		// Index of largest element
        int largestIndex = index;
        int leftChild = 2*index+1;
        int rightChild = 2*index+2;
        if(leftChild<=last && arr[leftChild]>arr[largestIndex])
            largestIndex=leftChild;
        if(rightChild<=last && arr[rightChild]>arr[largestIndex])
            largestIndex=rightChild;
        if(largestIndex!=index){
            int temp = arr[largestIndex];
            arr[largestIndex] = arr[index];
            arr[index]=temp;
            heapifyDown(arr,last,largestIndex);
        }
        return ;
    }
    
	private static void buildMaxHeap(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
		    heapifyDown(arr, n-1,i);
		}
	}
}
