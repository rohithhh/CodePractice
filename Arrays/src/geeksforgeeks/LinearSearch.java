package geeksforgeeks;

public class LinearSearch {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 6}, k = 6;
		System.out.println(searchLinear(arr, k));
	}
	static boolean searchLinear(int arr[], int k) {
		for(int i : arr) {
			if(i==k)
				return true;
		}
		return false;
	}
}