package geeksforgeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
	 
	 public int[] intersectionBetter(int[] a, int[] b) {
	        Set<Integer> s1 = new HashSet<>();
	        Set<Integer> s2 = new HashSet<>();
	        for(int i: a){
	            s1.add(i);
	        }
	        for(int j:b){
	            if(s1.contains(j)){
	                s2.add(j);
	            }
	        }
	        int[] result = new int[s2.size()];
	        int j=0;
	        for(int i: s2){
	            result[j]=i;
	            j++;
	        }
	        return result;
		}
	 
	 public int[] intersection(int[] nums1, int[] nums2) {
	        int[] map = new int[1001];
	        for (int num1: nums1) {
	            if (map[num1] == 0) {
	                map[num1]++;
	            }
	        }
	        int[] result = new int[nums1.length];
	        int index = 0;
	        for (int num2: nums2) {
	            if (map[num2] == 1) {
	                map[num2]--;
	                result[index++] = num2;
	            }
	        }
	        int[] res = new int[index];
	        System.arraycopy(result, 0, res, 0, index);
	        return res;
	    }
}
