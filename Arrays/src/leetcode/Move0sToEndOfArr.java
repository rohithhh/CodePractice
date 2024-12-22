package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/move-zeroes/description/
public class Move0sToEndOfArr {
	public static void main(String[] args) {
		int[] nums = {1};
		moveZeroesOptimised(nums);
		System.out.println(Arrays.toString(nums));
	}
	
    public static void moveZeroes(int[] arr) {
        List<Integer> temp = new ArrayList<Integer>();
        int i;
        for(i=0;i<arr.length;i++) {
        	if(arr[i]!=0)
        		temp.add(arr[i]);
        }
        for(i=0;i<temp.size();i++) {
        	arr[i]=temp.get(i);
        }
        for(i=temp.size();i<arr.length;i++) {
        	arr[i]=0;
        }
    }
    public static void moveZeroesOptimised(int[] arr) {
    	int l=0,r=0,j=-1;
    	int n = arr.length;
    	//find element that is 0
    	while(r<n) {
    		if(arr[r]==0) {
    			//element found, move j to that index
    			j=r;
    			break;
    		}
    		r++;
    	}
    	//if j>=0 means that we have 0s to move
    	if(j>=0) {
    		//start l index after j so that we can swap arr[l] with arr[j]
    		for(l=j+1;l<n;l++) {
    			//find a non zero index and swap that index with 0th index
    			if(arr[l]!=0) {
    			swap(arr,l,j);
    			//increment j so that we can check for other 0s
    			j++;
    			}
    		}
    	}
    }

	private static void swap(int[] arr, int l, int j) {
		int temp = arr[l];
		arr[l]=arr[j];
		arr[j]=temp;
	}
}
