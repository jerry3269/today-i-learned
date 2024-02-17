package chapter8.binarysearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 바위를 제거한 뒤 각 지점 사이의 거리의 최소 값중 가장 큰 값
public class problem32 {

    public static void main(String[] args) {
        System.out.println(solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }

    public static int solution(int distance, int[] rocks, int n) {

        List<Integer> asList = Arrays.stream(rocks)
                .boxed()
                .collect(Collectors.toList());

        asList.add(distance);

        List<Integer> sortedRocks = asList.stream()
                .sorted()
                .collect(Collectors.toList());

        int start = 1;
        int end = distance + 1;

        while ((end - start) > 1) {
            int mid = (start + end) / 2;

            if (isValid(mid, sortedRocks, n)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return start;
    }


    private static boolean isValid(int mid, List<Integer> rocks, int n) {
        int removeCount = 0;
        int lastRock = 0;

        for (int rock : rocks) {
            if (rock - lastRock < mid) {
                removeCount++;
                continue;
            }

            lastRock = rock;
        }
        System.out.println(removeCount);


        return removeCount <= n;
    }
}
