package sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapSort {//heap的堆的意思

    //堆排序
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {//把数组的整体位置搞成大根堆
            heapInsert(arr, i);//O(logN)
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //堆化//
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;//左孩子的下标
        while (left < heapSize) {//下方还有孩子的时候
            //两个孩子中，谁的值大，把下标给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            //父和孩子之间，谁的直达，把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    //比较器
    public static class AComp implements Comparator<Integer> {
        //如果返回负数，认为第一个参数放在上面
        //如果返回正数，认为第二个参数放在上面
        //生成大根堆的比较器
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    //Java小根堆的创建
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new AComp());
        heap.add(8);
        heap.add(1);
        heap.add(3);
        heap.add(2);
        heap.add(0);
        heap.add(7);
        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }
}
