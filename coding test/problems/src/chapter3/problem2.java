package chapter3;

import java.util.Arrays;

public class problem2 {
    public int[] solution(int n) {
        int num = 1;

        int[][] arr = new int[n][n];
        Arrays.stream(arr).forEach(ints -> Arrays.fill(ints, 0));

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) Point.downWay();
                else if (i % 3 == 1) Point.rightWay();
                else if (i % 3 == 2) Point.upWay();
                arr[Point.y][Point.x] = num;
                num++;
            }
        }

        int index = 0;
        int size = (n * (n + 1)) / 2;
        int[] answer = new int[size];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                answer[index++] = arr[i][j];
            }
        }

        return answer;
    }

    private static class Point {
        public static int x = 0;
        public static int y = -1;

        static void downWay() {
            y += 1;
        }

        static void upWay() {
            x -= 1;
            y -= 1;
        }

        static void rightWay() {
            x += 1;
        }
    }
}
