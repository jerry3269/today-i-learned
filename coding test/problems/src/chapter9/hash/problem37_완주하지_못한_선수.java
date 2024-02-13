package chapter9.hash;

import java.util.HashMap;
import java.util.Map;

public class problem37_완주하지_못한_선수 {
    public static void main(String[] args) {
        System.out.println(
                solution(
                new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"})
        );
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
        }

        for (String s : completion) {
            map.put(s, map.get(s) - 1);
            if(map.get(s) == 0) map.remove(s);
        }

        return map.keySet().iterator().next();
    }
}
