package chapter4;

public class problem10 {
    class Solution {
        public int[] solution(String s) {
            int loop = 0;
            int removed = 0;

            while (!s.equals("1")) {
                int zeroCount = getZeroCount(s);
                loop++;
                removed += zeroCount;

                int length = s.length() - zeroCount;
                s= Integer.toString(length, 2);
            }

            return new int[]{loop, removed};
        }

        private int getZeroCount(String s) {
            int zeroCount = 0;
            for (char c : s.toCharArray()) {
                if(c == '0') zeroCount++;
            }
            return zeroCount;
        }
    }
}
