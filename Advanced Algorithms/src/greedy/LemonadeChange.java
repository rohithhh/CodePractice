package greedy;

//https://leetcode.com/problems/lemonade-change/description/
public class LemonadeChange {
	public static void main(String[] args) {
		int[] bills = {5,5,5,10,20};
		System.out.println(lemonadeChange(bills));
	}
	
    public static boolean lemonadeChange(int[] bills) {
        int i=0;
        int five=0,ten=0;
        while(i<bills.length) {
        	if(bills[i]==5)
        		five++;
        	else if(bills[i]==10) {
        		if(five>0) {
        			ten++;
        			five--;
        		}else
        			return false;
        	}
        	else{
        		if(ten>0 && five>0) {
        			ten--;
        			five--;
        		}
        		else if(five>=3) {
        			five = five-3;
        		}
        		else
        			return false;
        	}
        	i++;
        }
        return true;
    }
}
