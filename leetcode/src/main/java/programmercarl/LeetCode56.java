package programmercarl;

import java.util.Arrays;

public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for (int[] interval : intervals) {
            //判断区间
            if (index == -1 || interval[0] > res[index][1]) {
                res[++index] = interval;
                //合并区间
            } else {
                res[index][1] = Math.max(interval[1], res[index][1]);
            }
        }
        return Arrays.copyOf(res, index + 1);
    }
}