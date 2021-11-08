package sort;

import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.Queue;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }

        }

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //两种数出现奇数次，其他数出现偶数次，得到出现奇数次的两个数的算法
    public static void printOddTimesNum(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i]; //得到eor=a^b
            int rightOne = eor & (~eor + 1);//提取出eor最右边的1
            int onlyOne = 0;//变量 eor'
            for (int cur : arr) {
                if ((cur & rightOne) == 1) {
                    onlyOne ^= cur;
                }
            }
            System.out.println(eor ^ onlyOne);
        }

    }

    //归并排序 时间复杂度O(N*logN)
    //总结

    /**
     * 时间    空间    稳定
     * 选择   O(N²)   O(1)    N
     * 冒泡   O(N²)   O(1)    Y
     * 插入   O(N²)   O(1)    Y
     * 归并   O(N*logN)   O(N)    Y
     * 快排(随机)   O(N*logN)   O(logN)    N
     * 堆排序   O(N*logN)   O(1)    N
     */

    //用队列实现栈结构

    public static class TwoQueuesStack {
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueuesStack() {
            //LinkedList的本质是双向链表
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int pushInt) {
            queue.add(pushInt);
        }

        public int peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("stack is empty!");
            }
            while (queue.size() != 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        public int pop() {
            if (queue.isEmpty()) {
                throw new RuntimeException("stack is empty!");
            }
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = help;
            help = queue;
            queue = tmp;
        }

    }

    //栈实现队列结构
}
