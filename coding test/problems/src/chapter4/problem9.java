package chapter4;

public class problem9 {
    class Solution {
        public int solution(int n) {
            String string = Integer.toString(n, 3);
            String reverse = new StringBuilder(string).reverse().toString();
            return Integer.valueOf(reverse, 3);
        }
    }
}
