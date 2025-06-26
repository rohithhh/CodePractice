package leetcode;

import java.util.Arrays;

public class FindMissingAndRepeatingNo {
    public static int[] findMissingRepeatingNumbers(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        int[] count = new int[n + 1]; // 1-based indexing

        for (int num : nums) {
            count[num]++;
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) {
                res[1] = i; // missing
            } else if (count[i] == 2) {
                res[0] = i; // repeating
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[]nums = {3, 5, 4, 1, 1};
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(nums)));
    }

}
