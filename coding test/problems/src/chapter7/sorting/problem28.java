package chapter7.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class problem28 {

    public String solution(int[] numbers) {

        Stream<String> sorted = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> {
                    int original = Integer.parseInt(s1 + s2);
                    int reversed = Integer.parseInt(s2 + s1);
                    return reversed - original;
                });



        String string = sorted.collect(Collectors.joining(""));

        if (string.charAt(0) == '0') {
            return "0";
        }

        return string;
    }
}
