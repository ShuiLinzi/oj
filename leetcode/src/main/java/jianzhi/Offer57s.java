package jianzhi;

import java.util.ArrayList;

//剑指 Offer 57 - II. 和为s的连续正数序列
//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
//https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
public class Offer57s {
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, s = 3;
        ArrayList<int[]> list = new ArrayList<>();
        if (s == target) {
            int[] ans = new int[j - i + 1];
            for (int k = i; k < j; k++) {
                ans[k - i] = k;  //ans[k-i]妙啊，这个循环写的太妙了吧，66666666~
            }
            list.add(ans);
        }
        if (s > target) {
            s = s - i;
            i++;
        } else {
            j++;
            s = s + j;
        }
        return list.toArray(new int[0][]);
    }
}
