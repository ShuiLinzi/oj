package sort;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0~0有序的
        //0~i想要有序，因为0-0已经有序了，所以i从1开始循坏
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                //swap();
            }

        }
    }
}
