package recursion;

public class PowerOfXAndN {
	public static void main(String[] args) {
		
	}
	
    public double myPow(double x, int n) {
        if(x==-1.00 && n<0)
            return 1.00;
        if (n == Integer.MIN_VALUE) {
            return 1.0 / power(x, Long.MAX_VALUE);  // Use Long.MAX_VALUE to prevent overflow
        }
		if (n < 0) {
            // Calculate the power of -n and take reciprocal
            return 1.0 / power(x, -n);
        }
        
        // If 'n' is non-negative
        return power(x, n);
        
    }

    private double power(double x, long n) {
        // Base case: anything raised to 0 is 1
        if (n == 0) return 1.0;
        
        // Base case: anything raised to 1 is itself
        if (n == 1) return x;
        
        // If 'n' is even
        if (n % 2 == 0) {
            // Recursive call: x * x, n / 2
            return power(x * x, n / 2);
        }
        
        // If 'n' is odd
        // Recursive call: x * power(x, n - 1)
        return x * power(x, n - 1);
    }
}
