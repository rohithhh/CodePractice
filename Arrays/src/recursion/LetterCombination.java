package recursion;

import java.util.*;

public class LetterCombination {
    public static void main(String[] args) {
        String digits = "34";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), map, result);
        return result;
    }

    private static void backtrack(String digits, int index, StringBuilder current,
                                  Map<Character, String> map, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));
        if (letters != null) {
            for (char c : letters.toCharArray()) {
                current.append(c);
                backtrack(digits, index + 1, current, map, result);
                current.deleteCharAt(current.length() - 1); // backtrack
            }
        }
    }
}
