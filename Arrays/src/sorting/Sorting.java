package sorting;

import java.util.Arrays;

public class Sorting {
	public static void main(String[] args) {
		int [] arr = {2,0,2,1,1,0};
		System.out.println(Arrays.toString(selectionSort(arr,arr.length)));
		System.out.println(Arrays.toString(bubbleSort(arr,arr.length)));
		System.out.println(Arrays.toString(insertionSort(arr, arr.length)));
		System.out.println(Arrays.toString(quickSort(arr,0,arr.length-1)));
	}
	
	private static int[] selectionSort(int[] arr, int n) {
		 for (int i = 0; i < n - 1; i++) {
			 	//Assume min element is at index i
		        int min = i;
		        // Find the index of the smallest element in the remaining unsorted part of the array
		        for (int j = i + 1; j < n; j++) {
		            if (arr[j] < arr[min]) {
		                min = j;
		            }
		        }
		        // Swap the found minimum element with the element at index i
		        swap(arr,min,i);
		    }
		return arr;
	}
	
	private static int[] bubbleSort(int[] arr,int n) {
		for(int i=n-1;i>=0;i--) {
			//swap is to check if elements are swapped or not
			boolean swap=true;
			for(int j=0;j<=i-1;j++){
				//Compare each ele with next ele and then if next ele is greater than current element, if yes then swap
				if(arr[j]>arr[j+1]) {
					swap(arr, j, j+1);
					//if we make a swap that means there are elements that need to be swapped
					swap=false;
				}
			}
			//if swap is true means all elements are sorted since we are comparing each ele with next ele
			if(swap)
				break;
		}
		return arr;
	}
	
	private static int[] insertionSort(int[] arr,int n) {
		for(int i=0;i<n;i++) {
			int j=i;
			//check if left element is greater than current ele, if yes then swap till left element is smaller than current ele
			while(j>0 && arr[j-1]>arr[j]) {
				swap(arr, j, j-1);
				j--;
			}
		}
		return arr;
	}
	
	private static int[] quickSort(int[] arr,int lowIndex, int highIndex) {
		if(lowIndex< highIndex) {
			int partitionIndex = findPartition(arr,lowIndex,highIndex);
			quickSort(arr, lowIndex, partitionIndex-1);
			quickSort(arr, partitionIndex+1, highIndex);
		}
		return arr;
	}

	private static int findPartition(int[] arr, int low, int high) {
		int pivot = arr[low];
		int i = low;
		int j = high;
		while(i<j) {
			//from left. go till you find ele that is greater that pivot
			while(arr[i]<= pivot && i<=high-1)
				i++;
			//from right, go till you find ele that is greater than pivot
			while(arr[j]>pivot && j>=low+1)
				j--;
			//make sure j dont go over i
			if(i<j)
				swap(arr, i, j);
		}
		//when j crosses i , swap pivot with last element of left index i.e j
		swap(arr, low, j);
		return j;
	}

	private static void swap(int[] arr, int index1, int index2) {
	    int temp = arr[index1];
	    arr[index1] = arr[index2];
	    arr[index2] = temp;		
	}
	
}
