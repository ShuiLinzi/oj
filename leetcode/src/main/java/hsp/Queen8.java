package hsp;

public class Queen8 {
    //定义有多少个皇后
    int max = 8;
    //定义数组array，保存皇后存放的位置
    int[] array = new int[max];

    public static void main(String[] args) {

    }
    //放置n个皇后，也是递归的方法
    private void check(int n ){
        if (n==max) return;
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judeg(n)){
                //接着放
                check(n+1);
            }
        }

    }

    //判断当我们存放第n个皇后时，是否符合条件（不同在同一行，同一列，同一斜线）
    private boolean judeg(int n){

        for (int i = 0; i < n; i++) {
            //array[i] == array[n]用来判断前n个皇后和第n个是否在同一列
            //Math.abs(n-i)==Math.abs(array[n]-array[i]) 用来判断前n个皇后和第n个是否在一个斜线上
            if (array[i] == array[n] || Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }

        }
        return true;
    }
    //将皇后摆放的位置输出
    private void print(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();

    }
}
