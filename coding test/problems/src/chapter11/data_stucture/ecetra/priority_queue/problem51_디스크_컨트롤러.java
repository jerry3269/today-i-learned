package chapter11.data_stucture.ecetra.priority_queue;

import java.util.PriorityQueue;

public class problem51_디스크_컨트롤러 {
    public static void main(String[] args) {
        int i = solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
        System.out.println(i);
    }

    public static int solution(int[][] jobs) {
        PriorityQueue<Job> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1.reqTime == o2.reqTime) return o1.runTime - o2.runTime;
            return o1.reqTime - o2.reqTime;
        });

        for (int[] job : jobs) {
            queue.add(new Job(job[0], job[1]));
        }

        int exec = 0;
        int time = 0;
        while (!queue.isEmpty()) {
            Job poll = queue.poll();
            if (time == poll.reqTime) {
                exec += poll.runTime;
                time += poll.runTime;
            }
            else if (time > poll.reqTime) {
                queue.add(new Job(time, poll.runTime));
                exec += time - poll.reqTime;
            } else {
                exec += poll.runTime;
                time = poll.reqTime + poll.runTime;
            }
        }
        return exec / jobs.length;
    }

    private static class Job {
        final int reqTime;
        final int runTime;
        public Job(int reqTime, int runTime) {
            this.reqTime = reqTime;
            this.runTime = runTime;
        }
    }
}
