package sort;

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
                if ((cur&rightOne)==1){
                    onlyOne^=cur;
                }
            }
            System.out.println(eor^onlyOne);
        }

    }

    //归并排序 时间复杂度O(N*logN)
}
