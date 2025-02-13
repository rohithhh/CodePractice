package recursion;

public class PowerOfxTon {
	public static void main(String[] args) {
		System.out.println(myPow(2, 4));
	}
	
	public static double myPow(double x, int n) {
		if(n==0)
			return 1.0;
		if(n<0)
			return 1/x*myPow(x,-n);
		return x*myPow(x,n-1);
  }
}
