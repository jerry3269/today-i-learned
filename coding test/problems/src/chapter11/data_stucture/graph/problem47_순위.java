package chapter11.data_stucture.graph;

public class problem47_순위 {
    public static void main(String[] args) {
        System.out.println(solution(
                5,
                new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}
        ));
    }
    private static boolean[][] graph;

    public static int solution(int n, int[][] results) {
        graph = new boolean[n][n];
        int result = 0;

        for (int i = 0; i < results.length; i++) {
            graph[results[i][0]-1][results[i][1]-1] = true;
        }

        for (int i = 0; i < n; i++) {
            int win = winCount(i, new boolean[n]);
            int lose = loseCount(i, new boolean[n]);
            if(win + lose + 1 == n) result++;
        }
        return result;
    }

    public static int winCount(int n, boolean[] isVisited) {
        int count = 0;
        for (int i = 0; i < graph[n].length; i++) {
            if(i==n) continue;
            if(isVisited[i]) continue;
            if(graph[n][i]) {
                isVisited[i] = true;
                count += winCount(i, isVisited) + 1;
            }
        }
        return count;
    }

    public static int loseCount(int n, boolean[] isVisited) {
        int count = 0;
        for (int i = 0; i < graph[n].length; i++) {
            if(i==n) continue;
            if(isVisited[i]) continue;
            if(graph[i][n]) {
                isVisited[i] = true;
                count += loseCount(i, isVisited) + 1;
            }
        }

        return count;
    }
}
