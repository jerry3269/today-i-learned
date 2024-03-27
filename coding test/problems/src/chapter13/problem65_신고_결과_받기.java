package chapter13;

import java.util.*;
import java.util.stream.Collectors;

public class problem65_신고_결과_받기 {
    public static void main(String[] args) {
        int[] answer = solution(
                new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
                2
        );
        System.out.println(Arrays.toString(answer));
    }


    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reports = new HashMap<>();
        Map<String, Integer> reportCount = new HashMap<>();
        int[] answer = new int[id_list.length];

        for (String s : id_list) {
            reports.put(s, new HashSet<>());
        }

        for (String s : report) {
            String[] split = s.split(" ");
            String reporter = split[0];
            String target = split[1];

            Set<String> set = reports.get(reporter);
            if(set.contains(target)) continue;

            set.add(target);
            reportCount.putIfAbsent(target, 0);
            reportCount.put(target, reportCount.get(target) + 1);
        }

        List<String> collect = reportCount.keySet().stream()
                .filter(s -> reportCount.get(s) >= k)
                .collect(Collectors.toList());

        for (int i = 0; i < id_list.length; i++) {
            int count = (int) reports.get(id_list[i]).stream()
                    .filter(collect::contains)
                    .count();

            answer[i] = count;
        }

        return answer;
    }
}
