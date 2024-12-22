package geeksforgeeks;

public class SecondLargest {
	public static void main(String[] args) {
		int arr[] = {12, 35, 1, 10, 34, 1};
		System.out.println(getSecondLargest(arr));
	}
	public static int getSecondLargest(int[] arr) {
		int large = -1;
		int second_large = -1;
		int i=0;
        while(i<arr.length){
        	large = large>=arr[i]?large:arr[i];
        	i++;
        }
        i=0;
        while(i<arr.length) {
        	if(arr[i]>second_large && arr[i]!=large)
        		second_large=arr[i];
        	i++;
        }
        return second_large;
    }
}
