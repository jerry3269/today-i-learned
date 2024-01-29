package chapter7.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class problem23 {

    public static void main(String[] args) {
        int[] aa = solution(
                new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}
        );
        System.out.println(Arrays.toString(aa));
    }
    static List<Integer> ArrayList = new ArrayList<>();

    public static int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();

        ArrayList = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());

        for (int[] command : commands) {
            answer.add(operation(command));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static Integer operation(int[] command) {
        List<Integer> list = ArrayList.subList(command[0] - 1, command[1]);
        List<Integer> sortedList = list.stream()
                .sorted()
                .collect(Collectors.toList());
        return sortedList.get(command[2] - 1);
    }
}
