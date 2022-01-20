package jianzhi;

//剑指 Offer 17. 打印从1到最大的n位数
//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
public class Offer17 {
    StringBuilder res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public String printNumbers(int n) {
        this.n = n;
        res = new StringBuilder();
        num = new char[n];
        start = n - 1;
        dfs(0);
        res.deleteCharAt(res.length() - 1);
        return res.toString();

    }

    private void dfs(int x) {
        if (x==n){
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) res.append(s+",");
            if (n - start==nine) start--;
            return;
        }
        for (char i : loop){
            if (i=='9') nine++;
            num[x] = i;
            dfs(x+1);
        }
        nine--;

    }
}
