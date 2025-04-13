package dynamicProgramming;

import java.util.Arrays;

public class MinNoOfCoins {
	public static void main(String[] args) {
		int[] coins = {1,2,5}; 
		int amount = 11;
		System.out.println(coinChangeOptimised(coins, amount));
	}
	
	public static int coinChangeOptimised(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // Base case: 0 amount requires 0 coins
        dp[0] = 0;

        // Iterate through each coin and update the dp array
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still Integer.MAX_VALUE, it means it's not possible to form the amount
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}
	 
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] res = new int[amount+1];
        Arrays.fill(res, -1);
        res[0] = 0;
        for(int i=1;i<=amount;i++) {
        	if(checkIfIExistsInCoins(i,coins)) {
        		res[i]=1;
        	}
        	else {
        		int currentMin =Integer.MAX_VALUE;
        		for(int j=i-1;j>i/2;j--) {
        			int num = j-i;
        			int currentRequired = res[j]+res[num];
        			currentMin = Math.min(currentMin, currentRequired);
        		}
        		res[i]=currentMin;
        	}
        }
        return res[amount];
    }

	private static boolean checkIfIExistsInCoins(int i, int[] coins) {
		int low=0,high=coins.length-1;
		while(low<=high) {
			 int mid=(low+high)/2;
			 if(coins[mid]==i)
				 return true;
			 else if(coins[mid]<i)
				 low=mid+1;
			 else
				 high=mid-1;
		}
		return false;
	}
}
