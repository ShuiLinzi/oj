package sort;

import java.util.*;

public class Sort {
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

    public static void shellSort(int[] arr) {
        int len = arr.length;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = arr[j];
                while (j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = current;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] temp = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        //  bubbleSort2(arr);
//        selectSort2(arr);
//        shellSort2(arr);
//        insertSort(arr);
        // quickSort(arr, 0, arr.length - 1);
//        shellSort3(arr);
//        mergeSort(arr, 0, arr.length - 1, temp);
       // radixSort(arr);
        mergeSort2(arr,0,arr.length-1,temp);



        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubbleSort2(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectSort2(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;

        }
    }

    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;//要插入下标
                int current = arr[j];
                while (j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = current;
            }
        }
    }

    public static void shellSort3(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int current = arr[j];
                while (j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = current;
            }
        }
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }

    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int pointer = l;
        for (int i = l; i < r; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pointer);
                pointer++;
            }
        }
        swap(arr, pointer, r);
        return pointer;
    }

    private static void swap(int[] arr, int i, int pointer) {
        int temp = arr[i];
        arr[i] = arr[pointer];
        arr[pointer] = temp;
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }


    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }

        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    //基数排序，桶排序的升级
    private static void radixSort(int[] arr) {
        //1. 数组中的最大值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        //2. 得到最大值的位数
        int maxLength = (max + "").length();
        //3.定义桶和表示桶中元素的个数
        int[][] bucket = new int[10][arr.length];
        int[] bucketCounts = new int[bucket.length];
        //一共需要进行位数次，maxLength 次
        for (int k = 1, n = 1; k <= maxLength; k++, n *= 10) {
            //进行桶排序
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = arr[i] / n % 10;
                //放入桶中
                bucket[bucketIndex][bucketCounts[bucketIndex]] = arr[i];
                bucketCounts[bucketIndex]++;
            }
            //将桶中元素取出来，跳过不获取
            int index = 0;
            for (int i = 0; i < bucket.length; i++) {
                if (bucketCounts[i] != 0) {
                    for (int j = 0; j < bucketCounts[i]; j++) {
                        arr[index++] = bucket[i][j];
                    }
                    bucketCounts[i] = 0;
                }
            }
        }
    }

    public static void mergeSort2(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort2(arr, left, mid, temp);
            mergeSort2(arr, mid + 1, right, temp);
            merge2(arr, left, mid, right, temp);
        }

    }

    private static void merge2(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
