package chapter11.data_stucture.stack_queue;

import java.util.*;

public class problem45_기능_개발 {
    public static void main(String[] args) {
        int[] result = solution(
                new int[]{1,95,95,95},
                new int[]{99,1,1,1}
        );

        System.out.println(Arrays.toString(result));
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((100 - progresses[i])/(double) speeds[i]);
            queue.add(day);
        }
        queue.add(1000);
        System.out.println(queue);

        int count = 1;
        int last = queue.poll();

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (last < poll) {
                result.add(count);
                last = poll;
                count = 0;
            }
            count++;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
