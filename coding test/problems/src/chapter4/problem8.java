package chapter4;

import java.util.ArrayList;
import java.util.List;

public class problem8 {

    class Solution {
        public int solution(String s) {
            int answer = Integer.MAX_VALUE;
            if (s.length() < 2) return 1;

            for (int i = 1; i <= s.length() / 2; i++) {
                List<String> tokens = this.split(s, i);
                int length = getLength(tokens);
                answer = getMin(answer, length);

            }
            return answer;
        }

        private List<String> split(String s, int length) {
            List<String> tokens = new ArrayList<>();
            for (int i = 0; i < s.length(); i += length) {
                int endIndex = i + length;
                if (endIndex > s.length()) endIndex = s.length();
                tokens.add(s.substring(i, endIndex));
            }
            return tokens;
        }

        private int getLength(List<String> tokens) {
            StringBuilder answer = new StringBuilder();
            tokens.add("endToken");

            String last = tokens.get(0);
            int count = 0;
            for (String token : tokens) {
                if (token.equals(last)) count++;
                else {
                    if (count > 1) answer.append(count);
                    answer.append(last);
                    count = 1;
                    last = token;
                }
            }

            return answer.length();
        }

        private int getMin(int answer, int length) {
            return answer > length ? length : answer;
        }
    }
}
