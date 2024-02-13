package chapter9.hash;

import java.util.*;


public class problem35_A로_B만들기 {
    public static void main(String[] args) {
        System.out.println(solution("hello", "olleh"));

    }
    public static int solution(String before, String after) {
        char[] charArray1 = before.toCharArray();
        char[] charArray2 = after.toCharArray();

        Map<Character, Integer> beforeMap = toMap(charArray1);
        Map<Character, Integer> afterMap = toMap(charArray2);

        if (beforeMap.equals(afterMap)) return 1;
        return 0;
    }

    private static Map<Character, Integer> toMap(char[] list) {
        Map<Character, Integer> map = new HashMap<>();
        for (char s : list) {
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
        }
        return map;
    }
}
