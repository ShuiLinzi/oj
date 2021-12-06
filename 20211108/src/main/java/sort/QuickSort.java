package sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
         //   swap(arr, L + (int) (Math.random() * (R - L + 1)), R); //快排3.0
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1); // <区 p[0]是等于区的左边界,然后-1是小于区的右边界
            quickSort(arr, p[1] + 1, R);// >区 p[1]是右边界，+1是大于区的左边界
        }
    }

    private static int[] partition(int[] arr, int L, int R) { //返回的数组表示划分区等于划分指的左右边界[5,5]
        int less = L - 1;//<区右边界
        int more = R; // >区左边界
        while (L < more) {// L表示当前数的位置
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 72, 113, 11, 23, 12, 432, 64, 23, 756,21,23,24,23};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
