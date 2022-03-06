package programmercarl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                temp.add(poll.val);
                List<Node> children = poll.children;
                for (Node node : children) {
                    queue.offer(node);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
