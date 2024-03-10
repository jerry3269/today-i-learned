package chapter11.data_stucture.ecetra.priority_queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class problem50_이중_우선순위_큐 {

    public static void main(String[] args) {
        int[] answer = solution(new String[]{"I 1", "I 2", "D 1", "D -1", "I 3", "I 4", "D 1"});
        System.out.println(Arrays.toString(answer));
    }
    public static int[] solution(String[] operations) {
        int max = 0;
        int min = 0;
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (String operation : operations) {
            String[] split = operation.split(" ");
            if (split[0].equals("I")) {
                minQueue.add(Integer.parseInt(split[1]));
                maxQueue.add(Integer.parseInt(split[1]));
            }
            if (split[0].equals("D")) {
                if (split[1].equals("1")) {
                    if (!maxQueue.isEmpty()) {
                        Integer poll = maxQueue.poll();
                        minQueue.remove(poll);
                    }
                } else {
                    if (!minQueue.isEmpty()) {
                        Integer poll = minQueue.poll();
                        maxQueue.remove(poll);
                    }
                }
            }
        }

        if(!maxQueue.isEmpty()) max = maxQueue.poll();
        if(!minQueue.isEmpty()) min = minQueue.poll();
        return new int[]{max, min};
    }
}
