package jianzhi;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Offer38 {
    //    char[] c;
//    List<String> res = new LinkedList<>();
//    public String[] permutation(String s) {
//        c = s.toCharArray();
//        dfs(0);
//        return res.toArray(new String[res.size()]);
//    }
//    void dfs(int x){
//    }
    Set<String> res = new HashSet<>();

    public String[] permutation(String s) {
        backtrack(s.toCharArray(), new StringBuilder(), new boolean[s.length()]);
        return res.toArray(new String[0]);
    }

    private void backtrack(char[] ch, StringBuilder stringBuilder, boolean[] visited) {
        //终止条件
        if (stringBuilder.length() == ch.length) {
            res.add(stringBuilder.toString());
            return;
        }
        //选择列表
        for (int i = 0; i < ch.length; i++) {
            //剪枝，如果当前位置的元素已经使用过，则跳过进入下一个位置
            if (visited[i]) continue;
            //做出选择
            stringBuilder.append(ch[i]);
            //更新标记
            visited[i] = true;
            //进入下层回溯
            backtrack(ch, stringBuilder, visited);
            //撤销选择
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Offer38 test = new Offer38();
        String[] abcs = test.permutation("abc");
        System.out.println(abcs);

    }
}
