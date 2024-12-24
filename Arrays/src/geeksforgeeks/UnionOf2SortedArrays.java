package geeksforgeeks;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
//https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=union-of-two-sorted-arrays
public class UnionOf2SortedArrays {
	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4, 5}, b[] = {1, 2, 3, 6, 7};
		System.out.println(findUnion(a, b));
	}
	
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
    	Set<Integer> set = new TreeSet<Integer>();
    	for(int i : a)
    		set.add(i);
    	for(int i : b )
    		set.add(i);
		return new ArrayList<Integer>(set);
    }
}
