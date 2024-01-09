package chapter4;

public class problem7 {

    class Solution {
        public String solution(String s) {
            //state: 단어의 인덱스
            int state = 0;
            StringBuilder answer = new StringBuilder();

            for (char c : s.toCharArray()) {
                if(c == ' ') {
                    answer.append(c);
                    state = 0;
                }
                else {
                    answer.append(push(c, state));
                    state++;
                }
            }

            return answer.toString();
        }

        private char push(char c, int state) {
            return (state % 2 == 0) ? Character.toUpperCase(c) : Character.toLowerCase(c);
        }
    }
}
