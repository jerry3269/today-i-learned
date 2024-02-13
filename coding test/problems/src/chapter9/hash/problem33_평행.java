package chapter9.hash;

public class problem33_평행 {
    public int solution(int[][] dots) {
        if (기울기_구하기(dots[0], dots[1]) == 기울기_구하기(dots[2], dots[3])) {
            return 1;
        }
        if (기울기_구하기(dots[0], dots[2]) == 기울기_구하기(dots[1], dots[3])) {
            return 1;
        }
        if (기울기_구하기(dots[0], dots[3]) == 기울기_구하기(dots[1], dots[2])) {
            return 1;
        }

        return 0;
    }

    private double 기울기_구하기(int[] dot1, int[] dot2) {
        return (double) (dot1[1] - dot2[1]) / (dot1[0] - dot2[0]);
    }
}
