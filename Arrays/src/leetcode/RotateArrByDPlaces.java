package leetcode;

import java.util.Arrays;
//https://leetcode.com/problems/rotate-array/description/
public class RotateArrByDPlaces {
	public static void main(String[] args) {
		int[] arr = {4,5,6,7,0,1,2};
		rotateLeftOptimised(arr,4);
		System.out.println(Arrays.toString(arr));
	}
	
    public static void rotateLeft(int[] arr, int d) {
        int[] temp=new int[d];
        int i=0;
        int n = arr.length;
        //First copy elements that are not to be rotated in a temp arr 
        while(i<d) {
        	temp[i]=arr[i];
        	i++;
        }
        //Now move elements from d to first
        for(i=d;i<n;i++) { 
        	//i-d holds the dth ele, move it to ith(0,1,2,..) index
        	arr[i-d]=arr[i];
        }
        //now move temp elements to our arr by inserting them at n-d index(7-3=4) 
        for(i=n-d;i<n;i++) {
        	// n-d =4 and i=4 =>i-(n-d)=0, so temp[0]
        	arr[i]=temp[i-(n-d)];
        }
    }
    
    public static void rotateRight(int[] arr, int d) {
        int[] temp=new int[d];
        int i=0;
        int n = arr.length;
        d = d % n;
        //First copy elements that are not to be rotated in a temp arr 
        for(i=n-d;i<n;i++) {
        	temp[i-(n-d)]=arr[i];
        	//temp=5,6,7
        }
        for (i = n - d - 1; i >= 0; i--) {
        	//3-6=>(4-7),(2-5)=>(3-6),(1-4)=>(2-5),(0-3)=>(1-4)
        	arr[i+d]=arr[i];
        }
        //arr=1,2,3,1,2,3,4
        for(i=0;i<d;i++) {
        	arr[i]=temp[i];
        }
        //arr=5,6,7,1,2,3,4
    }
    
    public static void rotateLeftOptimised(int[] arr, int d) {
        int n = arr.length;
        // Normalize d to avoid unnecessary rotations
        d = d % n;
        //reverse from 0 to d
    	reverse(arr,0,d);
    	//3.2.1.4.5.6.7
    	//reverse from d to n
    	reverse(arr,d+1,n-1);
    	//3,2,1,7,6,5,4
    	//reverse from 0 to n
    	reverse(arr,0,n-1);
    	//4,5,6,7,1,2,3
    }
    
    public static void rotateRightOptimised(int[] arr, int d) {
        int n = arr.length;
        // Normalize d to avoid unnecessary rotations
        d = d % n;
        //reverse till 0 to n-1
    	reverse(arr,0,n-1);
    	//7,6,5,4,3,2,1
    	//reverse from 0 to d
    	reverse(arr,0,d);
    	//5,6,7,4,3,2,1
    	//reverse from d+1 to n=1
    	reverse(arr,d+1,n-1);
    	//5,6,7,1,2,3,4
    }

	private static void reverse(int[] arr, int startIndex, int lastIndex) {
		while(startIndex<lastIndex) {
			int temp =arr[startIndex];
			arr[startIndex]= arr[lastIndex];
			arr[lastIndex]=temp;
			startIndex++;
			lastIndex--;
		}
	}
}
