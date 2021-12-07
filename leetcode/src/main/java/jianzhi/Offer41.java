package jianzhi;

import java.util.PriorityQueue;
import java.util.Queue;

//剑指 Offer 41. 数据流中的中位数
//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
// 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
//https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
//解题思路:其他的都好理解，主要就是借助大小根堆排序，需要研究一下
public class Offer41 {
}

class MedianFinder {
    Queue<Integer> A, B;

    public MedianFinder() {
        A = new PriorityQueue<>();//小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x));//大顶堆，保存较小的一半
    }
    //当 m = nm=n（即 NN 为 偶数）：需向 AA 添加一个元素。实现方法：将新元素 numnum 插入至 BB ，再将 BB 堆顶元素插入至 AA ；
    //当 m \ne nm
    // =n（即 NN 为 奇数）：需向 BB 添加一个元素。实现方法：将新元素 numnum 插入至 AA ，再将 AA 堆顶元素插入至 BB ；
    public void addNum(int num) {//保持排序的顺序，判断大小
        if (A.size()!=B.size()){
            A.add(num);
            B.add(A.poll());
        }else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
