package chapter11.data_stucture.ecetra.union_find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class problem53_섬_연결하기 {

    public static void main(String[] args) {
        int answer = solution(6,
                new int[][]{
                        {0, 1, 5},
                        {0, 3, 2},
                        {0, 4, 3},
                        {1, 4, 1},
                        {3, 4, 10},
                        {1, 2, 2},
                        {2, 5, 3},
                        {4, 5, 4}
                });
        System.out.println(answer);
    }
    public static int solution(int n, int[][] costs) {
        int cost = 0;
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Node(i));
        }

        List<int[]> sortedList = Arrays.stream(costs)
                .sorted(Comparator.comparingInt(o -> o[2]))
                .collect(Collectors.toList());

        for (int[] edge : sortedList) {
            Node node1 = list.get(edge[0]);
            Node node2 = list.get(edge[1]);
            if(node1.merge(node2)) cost += edge[2];
        }

        return cost;
    }

    private static class Node {
        Node parent = null;
        final int value;
        public Node(int value) {
            this.value = value;
        }
        public boolean isConnected(Node o) {
            return this.root() == o.root();
        }
        private Node root() {
            if (parent == null) return this;
            return parent = parent.root();
        }
        public boolean merge(Node o) {
            if(isConnected(o)) return false;
            Node oRoot = o.root();
            Node thisRoot = this.root();
            oRoot.parent = thisRoot;
            return true;
        }
    }
}
