package chapter9.hash;

import java.util.*;
import java.util.stream.Collectors;

public class problem34_중복된_문자_제거 {
    public String solution(String my_string) {
        String[] split = my_string.split("");
        List<String> list = Arrays.asList(split);
        Set<String> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : list) {
            if(set.contains(s)) continue;
            set.add(s);
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
