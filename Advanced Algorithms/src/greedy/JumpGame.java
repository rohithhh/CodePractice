package greedy;

public class JumpGame {
	public static void main(String[] args) {
		int[] nums = {3,2,1,0,4};
		System.out.println(canJump(nums));
	}
	
    public static boolean canJump(int[] nums) {
    	int maxReach = 0;  // This will track the farthest index we can reach
        int i = 0;

        while (i < nums.length && i <= maxReach) {
            maxReach = Math.max(maxReach, i + nums[i]);  // Update maxReach
            if (maxReach >= nums.length - 1) {
                return true;  // If we can reach or exceed the last index, return true
            }
            i++;  // Move to the next index
        }

        return false;  // If we exit the loop, we couldn't reach the end
    }
}
