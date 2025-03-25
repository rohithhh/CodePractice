package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
	public static void main(String[] args) {
		System.out.println(generateParenthesis(2));
	}
	
	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		generate(0, 0, n, "", result);
		return result;
    }

	private static void generate(int open, int close, int n, String current, List<String> result) {
		if(open == close && open+close == 2*n) {
			result.add(current);
			return;
		}
		
        if (open < n) {
            generate(open + 1, close, n, current + '(', result);
        }

        if (close < open) {
            generate(open, close + 1, n, current + ')', result);
        }
	}
}
