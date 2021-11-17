package problem;


/**
 * 题目讲解
 * 首先将字符串转为数组
 * 然后双重for循环找到成绩大的，&运算判断是否有重复的数字
 */
public class LeetCode318 {
    public int maxProduct(String[] words) {
        //首先将字符串转为数组
        int[] bits = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {//把字符串转成等价转成一个二进制数字
                bits[i] |= 1 << (chars[j] - 'a');
            }
        }
        //然后双重for循环找到成绩大的
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        java.lang.String[] a = new java.lang.String[]{"abcf", "baz"};
        LeetCode318 solution = new LeetCode318();
        int i = solution.maxProduct(a);
        System.out.println(i);

    }
}
