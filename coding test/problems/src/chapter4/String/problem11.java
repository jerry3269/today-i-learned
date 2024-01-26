package chapter4.String;

public class problem11 {

    class Solution {
        boolean solution(String s) {
            String lowerCase = s.toLowerCase();

            int pc = s.length() - lowerCase.replace("p", "").length();
            int yc = s.length() - lowerCase.replace("y", "").length();

            return pc == yc;
        }
    }
}
