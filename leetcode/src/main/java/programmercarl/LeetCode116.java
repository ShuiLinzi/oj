package programmercarl;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode116 {
    public Node1 connect(Node1 root) {
        Queue<Node1> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node1 node = queue.poll();
                if (i < size - 1) {//node节点next默认就为null，只需要把存在的nect复制即可
                    node.next = queue.peek();//为啥是peek，因为node已经弹出，2->3 此时3就在队列的第一个
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }

        }
        return root;
    }
}
