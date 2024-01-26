package chapter4.String;

public class problem6 {

    class Solution {
        public String solution(String s, int n) {
            StringBuilder answer = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == ' ') answer.append(c);
                else answer.append(push(c, n));
            }
            return answer.toString();
        }

        private char push(char c, int n) {
            int offset = Character.isLowerCase(c) ? 'a' : 'A';
            int position = (c - offset + n) % 26;
            return (char) (offset + position);
        }
    }
}
