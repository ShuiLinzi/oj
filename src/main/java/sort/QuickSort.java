package sort;

public class QuickSort {
    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1); // <区
            quickSort(arr, p[1] + 1, R);// >区
        }
    }

    private static int[] partition(int[] arr, int L, int R) {
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
}
