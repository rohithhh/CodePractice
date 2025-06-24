package leetcode;

public class KadaneAlgo {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i:nums){
            sum+=i;
            max=Math.max(max,sum);
            if(sum<0)
                sum=0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -3, -7, -2, -10, -4};
        System.out.println(new KadaneAlgo().maxSubArray(nums));
    }
}
