package chapter4.String;

public class problem5 {

    class Solution {
        public int[] solution(long n) {
            String string = new StringBuilder(Long.toString(n))
                    .reverse()
                    .toString();
            char[] charArray = string.toCharArray();

            int[] answer = new int[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                answer[i] = charArray[i] - '0';
            }

            return answer;
        }
    }
}
