package programmercarl;

//左旋转字符串，思路：旋转左半部分，旋转右半部分，最后整体旋转
public class LeetCode58 {
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        StringBuilder stringBuilder = new StringBuilder(s);
        reverse(stringBuilder, 0, n - 1);
        reverse(stringBuilder, n, length - 1);
        return stringBuilder.reverse().toString();
    }

    private void reverse(StringBuilder stringBuilder, int m, int n) {
        while (m < n) {
            char left = stringBuilder.charAt(m);
            char right = stringBuilder.charAt(n);
            stringBuilder.setCharAt(m, right);
            stringBuilder.setCharAt(n, left);
            m++;
            n--;
        }

    }
}
