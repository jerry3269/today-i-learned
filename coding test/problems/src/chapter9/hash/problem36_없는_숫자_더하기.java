package chapter9.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class problem36_없는_숫자_더하기 {
    public int solution(int[] numbers) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Set<Integer> set = new HashSet<>(list);

        List<Integer> numberList = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());

        numberList.forEach(set::remove);

        int sum = 0;
        for (Integer i : set) {
            sum += i;
        }
        return sum;
    }
}
