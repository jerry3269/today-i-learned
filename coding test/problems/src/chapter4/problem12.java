package chapter4;

import java.util.List;

public class problem12 {

    class Solution {
        private static final List<String> number = List.of(
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine"
        );
        public int solution(String s) {

            for (int num = 0; num < 10; num++) {
                s = s.replace(number.get(num), Integer.toString(num));
            }

            return Integer.parseInt(s);
        }
    }
}
