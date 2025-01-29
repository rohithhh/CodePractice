package slidingWindow;

public class MaxPointObtainedFromCards {
	public static void main(String[] args) {
		int[] cardScore = {5, 4, 1, 8, 7, 1, 3}; 
		System.out.println(maxScore(cardScore, 5));
	}
	
    public static int maxScore(int[] cardScore, int k) {
    	int n = cardScore.length;
    	int lsum = 0,rsum=0;
    	int i=0,maxSum=0;
    	for(i=0;i<k;i++) {
    		lsum+=cardScore[i];
    	}
    	maxSum = lsum;
    	int r = n-1;
    	for(i=k-1;i>=0;i--) {
    		lsum-=cardScore[i];
    		rsum+=cardScore[r];
    		r--;
    		maxSum=Math.max(maxSum, lsum+rsum);
    	}
		return maxSum;
    }
}
