package jianzhi;

import java.util.HashMap;
import java.util.Map;

//剑指 Offer 56 - II. 数组中数字出现的次数 II
//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字
//https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
//解题思路：先用set把题目解出来再说
public class Offer56s {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            int key = nums[i];
            if (!map.containsKey(key))
                map.put(key, 1);
            else map.put(key, map.get(key) + 1);

        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
