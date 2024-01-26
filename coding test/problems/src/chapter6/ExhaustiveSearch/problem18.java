package chapter6.ExhaustiveSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem18 {

    public static void main(String[] args) {
        solution(new int[]{1, 3, 2, 4, 2});
    }

    static final int[] supo1 = {1, 2, 3, 4, 5};
    static final int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
    static final int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    static final int[] count = {0, 0, 0};

    public static int[] solution(int[] answers) {

        int length1 = supo1.length;
        int length2 = supo2.length;
        int length3 = supo3.length;

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == supo1[i%length1]) count[0]++;
            if(answers[i] == supo2[i%length2]) count[1]++;
            if(answers[i] == supo2[i%length3]) count[2]++;
        }

        List<Integer> answer = new ArrayList<>();
        int max = Arrays.stream(count).max().getAsInt();

        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
