package sort;

public class InsertionSort {
    /**
     * 1.从1开始循环，是因为插入排序的特点导致的，默认第一个元素为有序的，从第二个开始比较
     * 2.由于是从1开始循环，因此为i < arr.length，不需要多减 1
     * 3.current为要插入的数据
     * 4.arr[preIndex + 1] = current; preIndex
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < arr.length; i++) {
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;

        }
    }
}
