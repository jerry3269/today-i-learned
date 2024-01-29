package chapter7.sorting;

import java.util.Arrays;

public class problem26 {

    public static void main(String[] args) {
        System.out.println(solution("JerryAFVeefdA"));
    }

    public static String solution(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        StringBuilder stringBuilder = new StringBuilder(new String(charArray));

        return stringBuilder.reverse().toString();
    }

}
