package chapter7.sorting;

import java.util.HashSet;
import java.util.Set;

public class problem24 {

    public int[] solution(int[] numbers) {
        Set<Integer> answer = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                answer.add(numbers[i] + numbers[j]);
            }
        }

        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
