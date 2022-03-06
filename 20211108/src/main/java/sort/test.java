package sort;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat.format(date1);
        System.out.println(format1);

        int[] arr = new int[40000000];
        for (int i = 0; i < 40000000; i++) {
            arr[i] = (int) (Math.random() * 10000000);
        }
        //  BubbleSort.bubbleSort(arr);
        //SelectionSort.selectionSort1(arr);
        //InsertionSort.insertionSort(arr);
        // ShellSort.shellSort(arr);
        //ShellSort.shellSort2(arr);
        // QuickS.quickSort(arr,0,arr.length-1);
        //MergeSort.mergeSort(arr);
        // RadixSort.radixSort(arr);
        // Date date2 = new Date();
        // String format = simpleDateFormat.format(date2);
        //   System.out.println(format);
//        for (int i = 0; i < 10; i++) {
//            System.out.print(arr[i] + " ");
//        }
    }

}
