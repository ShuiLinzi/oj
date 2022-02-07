package programmercarl;

import java.util.HashMap;
import java.util.Map;

public class LeetCode454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        int temp;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int m : nums2) {
                temp = i + m;
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }

        for (int i : nums3) {
            for (int m : nums4) {
                temp = i + m;
                if (map.containsKey(0 - temp)) {
                    res += map.get(0 - temp);
                }
            }
        }
        return res;
    }

}
