package programmercarl;

import java.util.ArrayList;
import java.util.List;

public class LeetCode131 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return res;
    }

    void backtrack(String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                String str = s.substring(index, i + 1);
                path.add(str);
            } else continue;
            backtrack(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        while (end > start) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
