package sort;

//递归 但是没有实现排序，只是把最大值给取出来了
//归并排序
public class RecursionSort {
    public static int recursionSort(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);//LR之间的中点
        int leftMax = recursionSort(arr, L, mid);
        int rightMax = recursionSort(arr, mid, R);
        return Math.max(leftMax, rightMax);

    }

    //归并排序

}
