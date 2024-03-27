package chapter13;

import java.util.Arrays;

public class problem68_양궁_대회 {

    public static void main(String[] args) {
        int[] answer = solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
        System.out.println(Arrays.toString(answer));
    }

    private static int maxGap = 0;
    private static int[] result = null;

    public static int[] solution(int n, int[] info) {
        int[] answer = recursion(n, 0, info, new int[11]);
        if (answer == null) {
            return new int[]{-1};
        }
        return answer;
    }

    private static int[] recursion(int n, int idx, int[] apeach, int[] lion) {
        if (idx == lion.length) {
            if(n > 0) return null;
            if(getPointGap(apeach, lion) <=0) return null;
            return Arrays.copyOf(lion, lion.length);
        }

        for (int i = 0; i <= n; i++) {
            lion[idx] = i;
            int[] recursion = recursion(n - i, idx + 1, apeach, lion);
            if(recursion == null) continue;

            int pointGap = getPointGap(apeach, lion);

            if(pointGap > maxGap || (pointGap == maxGap && isPrior(result, lion))) {
                maxGap = pointGap;
                /**
                 * 배열은 객체다!
                 * 자바는 call by value
                 * 1. 기본 자료형일 경우 값을 복사
                 * 2. 객체일 경우 참조(주소) 값을 복사
                 * 따라서, result = lion을 하게 되면 lion이 변할 때 마다 result도 변함.
                 */
                result = lion.clone();
            }
        }

        return result;
    }

    private static int getPointGap(int[] apeach, int[] lion) {
        int diff = 0;

        for (int i = 0; i < lion.length; i++) {
            if (apeach[i] == 0 && lion[i] == 0) continue;
            if (apeach[i] >= lion[i]) {
                diff -= 10 - i;
            } else {
                diff += 10 - i;
            }
        }
        return diff;
    }

    private static boolean isPrior(int[] base, int[] comp) {
        for (int i = 10; i >= 0; i--) {
            if(comp[i] == base[i]) continue;
            return comp[i] > base[i];
        }
        return false;
    }
}
