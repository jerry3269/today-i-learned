package chapter6;

public class problem19 {

    public static void main(String[] args) {
        solution(24, 24);

    }

    public static int[] solution(int brown, int yellow) {
        int x = 0;
        int y = 0;
        int plus = (brown + 4) / 2;
        int multiply = yellow + brown;

        for (int i = 1; i < plus; i++) {
            if ((i * (plus - i)) == multiply) {
                y = i;
                x = plus - i;
                break;
            }
        }

        int[] answer = {x, y};
        return answer;
    }
}
