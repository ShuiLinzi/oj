package jianzhi;

import java.util.HashMap;

//剑指 Offer 50. 第一个只出现一次的字符
//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
//https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
public class Offer50 {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            dic.put(c, !dic.containsKey(c));//用布尔值判断是否存在
        }
        for (Character c : chars) {
            if (dic.get(c) == true)//==true可以不写，因为默认就是==true
                return c;
        }
        return ' ';

    }

}
