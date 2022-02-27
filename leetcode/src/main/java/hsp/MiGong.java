package hsp;

import java.util.concurrent.RecursiveAction;

public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        int[][] map = new int[8][7];
        //使用1代表墙，上下全部置为一
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //把左右也全部置为一
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置地图的挡板
        map[3][1] = 1;
        map[3][2] = 1;
        setWay(map,1,1);
        //把迷宫地图打印出来
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //使用递归回溯给小球找走出迷宫的路线
    //递归三步走
    //1,先确定递归方法的各种参数

    /**
     * 递归方法
     *
     * @param map 二维迷宫
     * @param i   小球的初始位置
     * @param j   小球的初始位置
     * @return 是否能走
     * 如果小球能到map[6][5],说明通路可以找到
     * 约定 map[i][j]为0代表该点没有走过，为1代表墙，为2代表通路，3表示走过，但是走不通
     * 走迷宫策略，下->右->上->左,如果走不通，就进行回溯
     */
    public static boolean setWay(int[][] map, int i, int j) {
        //2.确认递归终止条件
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                }
            }
        }
        return false;
    }
}
