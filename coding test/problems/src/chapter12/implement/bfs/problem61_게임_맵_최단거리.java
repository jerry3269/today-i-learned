package chapter12.implement.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class problem61_게임_맵_최단거리 {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};

    public int solution(int[][] maps) {
        int column = maps.length;
        int row = maps[0].length;
        boolean[][] isVisited = new boolean[column][row];

        Queue<Bot> queue = new LinkedList<>();
        queue.add(new Bot(1, 0, 0));
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            Bot poll = queue.poll();

            if (poll.x == row - 1 && poll.y == column - 1) {
                return poll.step;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx < 0 || nx >= row || ny < 0 || ny >= column) {
                    continue;
                }

                if (maps[ny][nx] == 0) {
                    continue;
                }

                if (isVisited[ny][nx]) {
                    continue;
                }

                isVisited[ny][nx] = true;
                queue.add(new Bot(poll.step + 1, nx, ny));
            }
        }

        return -1;
    }

    private class Bot {
        int step;
        int x;
        int y;

        public Bot(final int step, final int x, final int y) {
            this.step = step;
            this.x = x;
            this.y = y;
        }
    }
}
