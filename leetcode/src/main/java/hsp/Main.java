package hsp;// 输出一个n，输出1~n的全排列

import java.util.*;

public class Main {
    static int N = 7;
    static int path[] = new int[N];
    static boolean[] isUse = new boolean[N];

    static void dfs(int u, int n) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!isUse[i]) {
                path[u] = i;
                isUse[i] = true;
                dfs(u + 1, n);
                isUse[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dfs(0, n);
    }
}
