package chapter6;

import java.util.*;

public class problem22 {

    public static void main(String[] args) {
        solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"});
        System.out.println(banSet.toString());
    }

    static Set<Set<String>> banSet = new HashSet<>();

    public static int solution(String[] user_id, String[] banned_id) {
        List<String[]> banList = new ArrayList<>();

        banned_id = Arrays.stream(banned_id)
                .map(banned -> banned.replace("*", "."))
                .toArray(String[]::new);

        for (String banned : banned_id) {
            String[] array = Arrays.stream(user_id)
                    .filter(user -> user.matches(banned))
                    .toArray(String[]::new);
            banList.add(array);
        }

        recursion(0, banList, new HashSet<>());
        return banSet.size();
    }

    private static void recursion(int index, List<String[]> banList, Set<String> banned) {
        if (index == banList.size()) {
            banSet.add(new HashSet<>(banned));
            return;
        }

        for (String id : banList.get(index)) {
            if(banned.contains(id)) continue;
            banned.add(id);
            recursion(index + 1, banList, banned);
            banned.remove(id);
        }
    }
}
