package beakJoon;

import java.io.IOException;
import java.util.Scanner;

class N4920 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[][][] blocks = {
                {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
                {{0, 0}, {1, 0}, {2, 0}, {3, 0}},

                {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
                {{0, 0}, {1, 0}, {1, -1}, {2, -1}},

                {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
                {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
                {{0, 0}, {1, 0}, {1, 1}, {1, 2}},
                {{0, 0}, {0, 1}, {1, 0}, {2, 0}},

                {{0, 0}, {0, 1}, {1, 1}, {0, 2}},
                {{0, 0}, {1, 0}, {1, -1}, {2, 0}},
                {{0, 0}, {1, -1}, {1, 0}, {1, 1}},
                {{0, 0}, {1, 0}, {1, 1}, {2, 0}},

                {{0, 0}, {0, 1}, {1, 0}, {1, 1}}
        };
        int num = 0;

        while(true){
            int n = sc.nextInt();

            if (n == 0) {
                break;
            }

            int[][] arr = new int[n][n];

            for(int i = 0; i < n; i++){

                for(int j = 0; j < n; j++){
                    int cell = sc.nextInt();
                    arr[i][j] = cell;
                }
            }

            int max = Integer.MIN_VALUE;

            for(int i = 0; i <= n; i++){
                for(int j = 0; j <= n; j++){
                    for (int[][] block : blocks){
                        boolean valid = true;
                        int sum = 0;

                        for (int[] cell : block){
                            int x = i + cell[0];
                            int y = j + cell[1];

                            if(x < 0 || x >= n || y < 0 || y >= n){
                                valid = false;
                                break;
                            }

                            sum += arr[x][y];
                        }

                        if (valid) {
                            max = Math.max(max, sum);
                        }
                    }
                }
            }
            System.out.println(++num + ". " + max);
        }
    }
}
