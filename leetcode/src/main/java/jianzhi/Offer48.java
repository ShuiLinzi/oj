package jianzhi;
//剑指 Offer 48. 最长不含重复字符的子字符串
//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
//https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
//解题思路，动态规格＋哈希表判断
//时间复杂度 On n为字符串的长度
//空间复杂度 O1 哈希表操控 英语字符串

import java.util.HashMap;
import java.util.Map;

public class Offer48 {
    //方法一：动态规格+哈希表
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();//左边是字母，右边是下标
        int res = 0;//最长的不包含重复数字的子字符串
        int tmp = 0;//当前不包含重复数字的子字符串
        for (int j = 0; j < s.length(); j++) {
            //getOrDefault() api 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
            int i = dic.getOrDefault(s.charAt(j), -1);
            dic.put(s.charAt(j), j);
            tmp = tmp < j - i ? tmp + 1 : j - i;
            res = Math.max(res, tmp);
        }
        return res;
    }

    //方法二：滑动窗口,就是滑动窗口的最简单的模型，很简单啊 我为啥花费那么时间进行思考呢，0.0.0.0
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, left = -1;//滑动窗口的边界，边界其实要为-1，不然后面会出大问题
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {//有重复数字，开始滑动窗口
                left = Math.max(left, map.get(s.charAt(i)));
            }
            //没有重复数字（没有走上面的if判断）
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left);

        }
        return max;
    }
}
