package sort;

public class ShellSort {
    /**
     * 1.第一个for循环，希尔排序的步长
     * 2.后面两个for循环相当于一个简单版的插入排序，左边元素有序，右边比较大小，找到合适的位置进行插入
     * 3.第三个for循环，从数组的第一个元素开始，把按步长分开的数组进行排序
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                for (int j = i - step; j >= 0; j -= step) {//进行了简单插入排序，因为每次arr[j]之前的元素已经有序，然后比较大小，进行插入
                    if (arr[j] > arr[j + step]) {
                        //判断大小，进行简单插入排序
                        int temp = arr[j];
                        arr[j] = arr[j + step];
                        arr[j + step] = temp;
                    }
                }

            }
        }
    }
//移位法，里面是真正的简单插入排序
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;//要插入的值的下标
                int current = arr[j];
                while (j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = current;
            }
        }
    }
}