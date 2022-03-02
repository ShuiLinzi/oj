package sort;

//基数排序
public class RadixSort {


    public static void radixSort(int[] arr) {
        //1.得到数组中最大的位数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //2.得到最大值的位数
        int maxLength = (max + "").length();
        //3.定义桶和表示桶中元素个数
        int[][] bucket = new int[10][arr.length];
        int[] bucketCounts = new int[bucket.length];
        //一共需要进行 maxlength轮
        for (int k = 1, n = 1; k <= maxLength; k++, n *= 10) {
            //进行桶排序
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = arr[i] / n % 10;
                // 放入该桶中
                bucket[bucketIndex][bucketCounts[bucketIndex]] = arr[i];
                // 标识该桶元素多了一个
                bucketCounts[bucketIndex]++;
            }
            // 将桶中元素获取出来，放到原数组中
            int index = 0;
            for (int i = 0; i < bucket.length; i++) {
                if (bucketCounts[i] == 0) {
                    // 该桶无有效元素，跳过不获取
                    continue;
                }
                // 获取桶中有效的个数
                for (int j = 0; j < bucketCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
                // 取完后，重置该桶的元素个数为 0 ，下一次才不会错乱数据
                bucketCounts[i] = 0;
            }
        }
    }


    private static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        //有多少准备多少个辅助空间
        int[] bucket = new int[R - L + 1];
        for (int d = 1; d < digit; d++) {//有多少位就进出几次
            //10个空间
            //count[0]当前位(d位)是0的数字有多少个
            //count[1]当前位(d位)是0和1的数字有多少个
            //count[2]当前位(d位)是(0,1,2)的数字有多少个
            //count[i]当前位(d位)是0的数字有多少个
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    private static int getDigit(int i, int d) {

        return 0;
    }


    private static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;

        }
        return res;
    }
}
