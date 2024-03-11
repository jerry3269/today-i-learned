package chapter12.implement.greedy;

import java.util.Arrays;

public class problem64_단속_카메라 {
    public static void main(String[] args) {
        int count = solution(new int[][]{
                {-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}
        });

        System.out.println(count);
    }

    public static int solution(int[][] routes) {
        int count = 1;
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]); //진출 지점을 오름차순 정렬

        int max = routes[0][1]; //진출 지점이 제일 작은 수

        for (int[] route : routes) {
            if (route[0] <= max && route[1] >= max) continue;
            max = route[1];
            count++;
        }

        return count;
    }
}
