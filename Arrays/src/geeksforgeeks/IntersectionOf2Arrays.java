package geeksforgeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class IntersectionOf2Arrays {
	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4, 5}, b[] = {1, 2, 3, 6, 7};
		System.out.println(findIntersection(a, b));
	}
	
	 public static ArrayList<Integer> findIntersection(int a[], int b[]) {
		 Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		 Set<Integer> set = new TreeSet<Integer>();
		 for(int i : a)
			 map.put(i, i);
		 for(int i :b) {
			 if(map.getOrDefault(i, 0)>1)
				 set.add(i);
		 }
		 return new ArrayList<Integer>(set);
	 }
}
