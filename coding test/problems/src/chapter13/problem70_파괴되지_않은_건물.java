package chapter13;

public class problem70_파괴되지_않은_건물 {

    public int solution(int[][] board, int[][] skill) {
        int[][] change = new int[board.length + 1][board[0].length + 1];

        for (int[] ints : skill) {
            int type = ints[0];
            int r1 = ints[1];
            int c1 = ints[2];
            int r2 = ints[3] +1;
            int c2 = ints[4] +1;
            int degree = ints[5];
            if(type == 1) degree = -degree;

            change[r1][c1] += degree;
            change[r2][c1] -= degree;
            change[r1][c2] -= degree;
            change[r2][c2] += degree;
        }

        for (int y = 0; y < change.length; y++) {
            for (int x = 0; x < change[y].length; x++) {
                int left = x > 0 ? change[y][x - 1] : 0;
                int up = y > 0 ? change[y - 1][x] : 0;
                int dup = x > 0 && y > 0 ? change[y - 1][x - 1] : 0;

                change[y][x] += left + up - dup;
            }
        }

        int answer = 0;

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if(board[y][x] + change[y][x] > 0) answer++;
            }
        }

        return answer;
    }
}
