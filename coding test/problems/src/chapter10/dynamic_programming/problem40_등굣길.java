package chapter10.dynamic_programming;

import java.util.Arrays;

public class problem40_등굣길 {

    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2, 2}}));
    }

    private static boolean[][] isPuddles = new boolean[101][101];
    private static int[][] mem = new int[101][101];

    public static int solution(int m, int n, int[][] puddles) {
        for (int[] puddle : puddles) {
            isPuddles[puddle[0]][puddle[1]] = true;
        }
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }

        return recursion(1, 1, m, n);
    }

    private static int recursion(int x, int y, int m, int n) {
        if (x > m || y > n) return 0;
        if(mem[x][y] != -1) return mem[x][y];
        if(x == m && y == n) return 1;
        if (isPuddles[x][y]) return 0;

        int total = recursion(x + 1, y, m, n) + recursion(x, y + 1, m, n);
        return mem[x][y] = total % 1_000_000_007;
    }
}
