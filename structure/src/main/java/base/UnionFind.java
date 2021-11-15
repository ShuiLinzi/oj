package base;

import java.util.HashMap;
import java.util.List;

public class UnionFind {
    public static class Data {
        //数据类型，填啥都行，你需要什么就填什么样的类型
    }

    public static class UnionFindSet {
        //（key，value）表示，key的父节点，是value，即左边的是子，右边的是父
        public HashMap<Data, Data> fatherMap;
        public HashMap<Data, Integer> sizeMap;

        public UnionFindSet(List<Data> nodes) {
            fatherMap = new HashMap<Data, Data>();
            sizeMap = new HashMap<Data, Integer>();
            makeSets(nodes);
        }

        //想要使用并查集，必须先给我初始化并查集
        //初始化的时候每一个节点都是父节点，自己指向自己，且sizeMap为1
        private void makeSets(List<Data> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Data node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        //find的过程，递归实现，并把沿途的所有结点都指向父节点
        private Data find(Data node) {
            Data father = fatherMap.get(node);
            if (father != node) {
                father = find(father);
            }
            fatherMap.put(node, father);
            return father;
        }

        //判断是否是同一个代表节点
        public boolean isSameSet(Data a, Data b) {
            return find(a) == find(b);
        }

        //联合方法，把小节点接到大节点下面
        public void union(Data a, Data b) {
            if (a == null || b == null) {
                return;
            }
            Data aHead = find(a);
            Data bHead = find(b);
            if (aHead != bHead) {
                Integer aSetSize = sizeMap.get(aHead);
                Integer bSetSize = sizeMap.get(bHead);
                if (aSetSize <= bSetSize) {
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                } else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }
        }
    }
}
