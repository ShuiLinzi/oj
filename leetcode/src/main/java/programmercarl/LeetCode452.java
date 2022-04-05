package programmercarl;

import java.util.Arrays;


/**
 * @author lin
 */
public class LeetCode452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int count = 1;
        for (int i = 1; i < points.length; i++) {
            //完全错开
            if (points[i][0] > points[i - 1][1]) {
                count++;
            }
            //上一个气球的右边界和下一个气球的左边界没有错开,就用小的右边界和后面的比较
            else {
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }

        }
        return count;
    }
}