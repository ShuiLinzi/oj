package jianzhi;

public class Offer58 {
    //方法一，字符串切片
    public String reverseLeftWords(String s, int n) {
//        String a = s.substring(n,s.length());
//        String b = s.substring(0,n);
//        return a+b;
        return s.substring(n, s.length()) + s.substring(0, n);

    }

    //方法二，stringbuilder方法实现
    public static String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }

    //方法三，不允许使用stringbuilder函数
    public String reverseLeftWords3(String s, int n) {
        String res = "";
        for (int i = n; i < n + s.length(); i++) {
            res += s.charAt(i % s.length());
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "abcdefg";
        int n = 2;
        String s = reverseLeftWords2(a, n);
        System.out.println(s);

    }

    //剑指 Offer 58 - I. 翻转单词顺序
    //输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
    //https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
    public String reverseWords(String s) {
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;//搜索首个空格
            res.append(s.substring(i + 1, j + 1) + ' ');//添加单词，i+1是因为此时i在空格上，j+1是因为substring不包括结束索引 beginIndex -- 起始索引（包括）, 索引从 0 开始。endIndex -- 结束索引（不包括）。
            while (i >= 0 && s.charAt(i) == ' ') i--; //跳过单词之间的空格
            j = i;//j指向下一个单词，重新开始循环
        }
        return res.toString().trim();//转化为字符串并且返回
    }
}
