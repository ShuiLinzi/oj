package base;

import sun.text.normalizer.Trie;

//前缀树的模板代码
public class TrieNode {
    public int pass;
    public int end;
    public TrieNode[] nexts;

    public TrieNode() {
        pass = 0;
        end = 0;
        nexts = new TrieNode[26];//已经提前new了二十六条路了，0位置表示走向a的路，1位置表示走向b的路，以此类推
    }


    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';//判断走的是哪条路
                if (node.nexts[index] == null) {//判断节点这条路是否为空，为空就创一个
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];//经历上方判断后，无论有没有，node节点都会指向下一个，进行更新操作
                node.pass++;//node pass++，
            }
            node.end++;
        }


        public int search(String word){
            if (word==null){
                return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i]-'a';
                if (node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }
    }
}