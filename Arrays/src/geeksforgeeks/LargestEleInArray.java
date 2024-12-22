package geeksforgeeks;
//https://www.geeksforgeeks.org/problems/largest-element-in-array4009/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=largest-element-in-array
public class LargestEleInArray {
	public static void main(String[] args) {
		int[] arr = {1, 8, 7, 56, 90};
		System.out.println(largest(arr));
	}
	
    public static int largest(int[] arr) {
        int max=0,i=0;
        while(i<arr.length){
            max=max>=arr[i]?max:arr[i];
            i++;
        }
        return max;
     }
}
