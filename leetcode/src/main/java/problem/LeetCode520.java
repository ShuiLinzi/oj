package problem;

//力扣每日一题第520题，简单字符串模拟题

/**
 * 思路：
 * 把字符串的每一个字符都遍历一遍，判断是否符合题意
 * 题目的意思是 三个达标 全部为大写，全部为小写，或者第一个字母为大写，其他的后面的字母为小写
 * 解题，遍历每一个字符判断是否为大写，是大写计数遍历++，最终进行判断
 */
public class LeetCode520 {
    public boolean detectCapitalUse(String word) {
        int length = word.length();
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                cnt++;
            }
        }
        return cnt == length || cnt == 0 || (cnt == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
