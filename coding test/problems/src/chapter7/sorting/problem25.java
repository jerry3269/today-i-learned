package chapter7.sorting;

import java.util.Arrays;

public class problem25 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,5,6}));
    }

    public static int solution(int[] citations) {
        int count;

        Arrays.sort(citations);

        for (int index = 0; index < citations.length; index++) {
            count = citations.length - index;
            if (citations[index] >= count) {
                return count;
            }
        }

        return 0;
    }
}
