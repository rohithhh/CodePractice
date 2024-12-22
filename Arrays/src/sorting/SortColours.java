package sorting;
//https://leetcode.com/problems/sort-colors/description/
public class SortColours {
	public static void main(String[] args) {
		int[] arr = {2,0,2,1,1,0};
		sortColors(arr);
	}
	
    public static void sortColors(int[] arr) {
      quicksort(arr,0,arr.length-1);
    }

	private static void quicksort(int[] arr, int low, int high) {
		if(low<high) {
			int partitionIndex = findPartition(arr,low,high);
			quicksort(arr, low, partitionIndex-1);
			quicksort(arr, partitionIndex+1, high);
		}
	}

	private static int findPartition(int[] arr, int low, int high) {
		int pivot = arr[low];
		int i=low;
		int j=high;
		while(i<j) {
			while(arr[i]<=pivot && i<=high-1)
				i++;
			while(arr[j]>pivot && j>=low+1)
				j--;
			if(i<j)
				swap(arr, i, j);
		}
		swap(arr, low, j);
		return j;
	}
	
	private static void swap(int[] arr, int index1, int index2) {
	    int temp = arr[index1];
	    arr[index1] = arr[index2];
	    arr[index2] = temp;		
	}
}
