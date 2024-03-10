package chapter11.data_stucture.ecetra.union_find;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class problem54_호텔_방_배정 {
    public static void main(String[] args) {
        solution(10, new long[]{
                1, 3, 4, 1, 3, 1
        });
    }
    public static long[] solution(long k, long[] room_number) {
        List<Long> answer = new ArrayList<>();

        Map<Long, Node> nodes = new HashMap<>();
        for (Long number : room_number) {
            if (nodes.containsKey(number)) {
                number = nodes.get(number).max() + 1;
            }

            Node node = new Node(number);
            nodes.put(number, node);
            if (nodes.containsKey(number - 1)) {
                node.merge(nodes.get(number - 1));
            }
            if (nodes.containsKey(number + 1)) {
                node.merge(nodes.get(number + 1));
            }
            answer.add(number);
        }

        return answer.stream().mapToLong(Long::longValue).toArray();
    }

    private static class Node {
        final long value;
        long max;
        Node parent = null;
        public Node(long value) {
            this.value = value;
            this.max = value;
        }
        private Node root() {
            if(this.parent == null) return this;
            return parent = parent.root();
        }

        public long max() {
            return root().max;
        }

        public boolean isConnected(Node node) {
            return this.root() == node.root();
        }

        public boolean merge(Node node) {
            if(isConnected(node)) return false;

            Node root1 = node.root();
            Node root2 = this.root();

            if (root1.max > root2.max) {
                root2.parent = root1;
                root2.max = root1.max;
                return true;
            }
            if (root1.max < root2.max) {
                root1.parent = root2;
                root1.max = root2.max;
                return true;
            }

            throw new IllegalArgumentException();
        }
    }
}
