package chapter12.implement.greedy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class problem62_체육복 {
    public static void main(String[] args) {
        int answer = solution(5, new int[]{4,5}, new int[]{3,4});
        System.out.println(answer);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        boolean[] isDuplicated = new boolean[n+1];
        int lendCount = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        List<Integer> lostList = Arrays.stream(lost)
                .boxed()
                .collect(Collectors.toList());

        for (Integer i : reserve) {
            if (lostList.contains((Integer) i)) {
                isDuplicated[i] = true;
            }
        }


        for (int i = 0; i < reserve.length; i++) {
            int firstBorrower = reserve[i] - 1;
            int secondBorrower = reserve[i] + 1;

            //여분 옷을 가지고있는 학생이 도난 당한 경우
            if (isDuplicated[reserve[i]]) {
                lostList.remove((Integer)reserve[i]);
                lendCount++;
                continue;
            }

            //왼쪽 친구가 옷을 도난 당한 경우
            if (lostList.contains(firstBorrower)) {
                lostList.remove((Integer)firstBorrower);
                lendCount++;
                continue;
            }

            //왼쪽 친구는 옷이 있고 오른쪽 친구가 옷을 도난 당한 경우
            if (lostList.contains(secondBorrower)) {
                /* 중요 */
                if (isDuplicated[secondBorrower]) continue;
                lostList.remove((Integer) secondBorrower);
                lendCount++;
                continue;
            }
        }

        return n - lost.length + lendCount;
    }
}
