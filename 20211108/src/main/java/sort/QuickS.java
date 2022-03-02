package sort;

import java.util.Arrays;

/**
 * 快排最终版本
 * @author 陈国庆
 */
public class QuickS {

    public static void quickSort(int[] arr, int L, int R) {//一轮下去大于中心元素的都在右边，小于的都在左边
        if (L < R) {
           // swap(arr, L + (int) (Math.random() * (R - L + 1)), R); //快排3.0,不加这句话时间复杂度为On*n,加了为O(nlogn)
            int p = partition(arr, L, R);//返回的是下标值
            quickSort(arr, L, p - 1);
            quickSort(arr, p + 1, R);
        }

    }

    private static int partition(int[] arr, int L, int R) { //返回的数组表示划分区等于划分指的左右边界[5,5]
        // 取最后一个元素作为中心元素(取最后一个元素作为基准)
        int pivot = arr[R];
        int pointer = L; //初始化指针，指向第一个元素
        for (int i = L; i < R; i++) {
            if (arr[i] <= pivot) {
                // 将比中心元素小的元素和指针指向的元素交换位置
                // 如果第一个元素比中心元素小，这里就是自己和自己交换位置，指针和索引都向下一位移动
                // 如果元素比中心元素大，索引向下移动，指针指向这个较大的元素，直到找到比中心元素小的元素，并交换位置，指针向下移动
                swap(arr, i, pointer);
                pointer++;
            }
        }
        swap(arr, pointer, R);//此方法操作的是下标
        return pointer;//返回的是中心元素的下标
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 72, 113, 11, 23, 12, 432, 64, 23, 756, 21, 23, 24, 23, 21, 3, 4, 51, 2, 63};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
