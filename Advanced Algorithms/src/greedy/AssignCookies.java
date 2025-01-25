package greedy;

import java.util.Arrays;
//https://leetcode.com/problems/assign-cookies/description/
public class AssignCookies {
	public static void main(String[] args) {
		int[] g = {1,2,3};
		int[] s = {1,1};
		System.out.println(findMaximumCookieStudents(g, s));
	}
	
    public static int findMaximumCookieStudents(int[] Student, int[] Cookie) {
    	Arrays.sort(Student);
    	Arrays.sort(Cookie);
    	int l=0,r=0;
    	while(l<Student.length && r<Cookie.length) {
    		 if (Cookie[r] >= Student[l]) {
                 l++;
             }
             // Move to next cookie
             r++;
    	}
		return l;
    }
}
