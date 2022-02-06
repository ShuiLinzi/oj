package programmercarl;

import java.util.HashSet;
import java.util.Set;

public class LeetCode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        //用来遍历数组
        Set<Integer> set1 = new HashSet<>();
        //也是遍历数组，但是会进行一个循环
        Set<Integer> resSet = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
        int[] res = new int[resSet.size()];
        int index = 0;
        for (int i : resSet) {
            res[index++] = i;
        }
        return res;
    }
}
