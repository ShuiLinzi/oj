package programmercarl;

import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {
    List<String> res = new ArrayList<>();
    String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        backtrack(digits, 0);
        return res;
    }

    private void backtrack(String digits, int start) {
        if (start == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String str = mapping[digits.charAt(start) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backtrack(digits, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
