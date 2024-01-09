package chapter3;

public class problem4 {
    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int column = arr1.length;
            int row = arr2[0].length;
            int num = arr2.length;

            int[][] answer = new int[column][row];

            for (int i = 0; i < column; i++) {
                for (int j = 0; j < row; j++) {
                    answer[i][j] = 0;

                    for (int k = 0; k < num; k++) {
                        answer[i][j] += arr1[i][k] * arr2[k][j];
                    }
                }
            }
            return answer;
        }
    }
}
