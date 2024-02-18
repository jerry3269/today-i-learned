package chapter10.dynamic_programming;

import java.util.Arrays;

public class problem39_정수_삼각형 {
    private static final int[][] mem = new int[501][501];

    public int solution(int[][] triangle) {
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }
        return recursion(0,0, triangle);
    }

    private int recursion(int x, int y, int[][] triangle) {
        if(y == triangle.length) return 0;
        if(mem[x][y] != -1) return mem[x][y];

        return mem[x][y] = triangle[y][x] + Math.max(
                            recursion(x, y + 1, triangle),
                            recursion(x + 1, y + 1, triangle)
        );
    }
}
