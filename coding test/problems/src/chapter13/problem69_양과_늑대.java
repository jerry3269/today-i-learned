package chapter13;

import java.util.HashSet;
import java.util.Set;

//greedy
public class problem69_양과_늑대 {

    public static void main(String[] args) {
        int maxSheep = solution(
                new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}}
        );

        System.out.println(maxSheep);
    }

    public static int solution(int[] info, int[][] edges) {
        boolean[][] tree = new boolean[info.length][info.length];
        for (int[] edge : edges) {
            tree[edge[0]][edge[1]] = true;
        }

        Set<Integer> set = new HashSet<>();
        set.add(0);
        return getMaxSheep(set,0,0,tree, info);
    }

    private static int getMaxSheep(final Set<Integer> nodes,
                                   final int sheep,
                                   final int wolf,
                                   final boolean[][] tree,
                                   final int[] info) {

        int maxSheep = sheep;

        for (Integer node : nodes) {
            int nextSheep = sheep;
            int nextWolf = wolf;

            if (info[node] == 0) {
                nextSheep += 1;
            } else{
                nextWolf += 1;
            }

            if(nextWolf >= nextSheep) continue;

            Set<Integer> nextNodes = getNextNode(node, nodes, tree);
            int s = getMaxSheep(nextNodes, nextSheep, nextWolf, tree, info);
            if (s > maxSheep) {
                maxSheep = s;
            }

        }
        return maxSheep;
    }

    private static Set<Integer> getNextNode(
            final int node,
            final Set<Integer> nodes,
            final boolean[][] tree) {

        HashSet<Integer> set = new HashSet<>(nodes);
        set.remove(node);

        for (int i = 0; i < tree[0].length; i++) {
            if(tree[node][i]) set.add(i);
        }
        return set;
    }
}
