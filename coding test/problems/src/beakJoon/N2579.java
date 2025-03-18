package beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[301];
        int[] point = new int[301];

        for(int i = 0; i < n; i++){
            stair[i + 1] = Integer.parseInt(br.readLine());
        }

        point[1] = stair[1];
        point[2] = stair[1] + stair[2];
        point[3] = Math.max(stair[1], stair[2]) + stair[3];

        for (int i = 4; i <= n; i++) {
            point[i] = Math.max(stair[i - 1] + point[i - 3], point[i - 2]) + stair[i];
        }

        System.out.println(point[n]);
    }
}
