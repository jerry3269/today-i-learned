package chapter7.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class problem29 {


    /*
    * new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4}
    * new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5}
    * new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 5}
    * */
    public static void main(String[] args) {
        solution(
                new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
                new int[]{2, 3, 5}
        );

        System.out.println(answer);

    }

    static Map<String, Integer> map = new HashMap<>();
    static List<String> answer = new ArrayList<>();

    public static String[] solution(String[] orders, int[] course) {

        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < course.length; j++) {
                recursion("", orders[i], course[j], 0);
            }
        }

        for (int count : course) {
            Map<String, Integer> collect = map.entrySet()
                    .stream()
                    .filter(o -> o.getKey().length() == count)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


            if(collect.size() == 0) continue;
            int max = Collections.max(collect.values());
            if (max == 1) continue;

            List<String> list = collect.entrySet()
                    .stream()
                    .filter(o -> o.getValue() == max)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            answer.addAll(list);
        }

        answer = answer.stream()
                .sorted()
                .collect(Collectors.toList());

        return answer.toArray(String[]::new);
    }

    private static void recursion(String str, String target, int length, int index) {
        if (str.length() == length) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            StringBuilder stringBuilder = new StringBuilder(new String(charArray));
            String string = stringBuilder.toString();

            if (map.containsKey(string)) map.put(string, map.get(string) + 1);
            else map.put(string, 1);
            return;
        }

        for (int i = index; i < target.length(); i++) {
            char c = target.charAt(i);
            recursion(str + c, target, length, i + 1);
        }

    }

}
