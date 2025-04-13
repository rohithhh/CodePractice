package recursion;

public class SubsequenceWithSumk {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		System.out.println(checkSubsequenceSum(nums, 8));
	}
	
	public static boolean checkSubsequenceSum(int[] nums, int k) {
        int n = nums.length;
        return solve(0, n, nums, k);
    }

	private static boolean solve(int i, int n, int[] nums, int k) {
		if(k==0)
			return true;
		if(k<0 || i==n)
			return false;
		return solve(i+1,n, nums, k-nums[i]) || solve(i + 1, n, nums, k);
	}
}
