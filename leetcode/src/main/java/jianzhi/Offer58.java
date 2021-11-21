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
}
