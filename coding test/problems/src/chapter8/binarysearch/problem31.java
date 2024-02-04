package chapter8.binarysearch;

public class problem31 {

    public long solution(int n, int[] times) {
        long start = 1;
        long end = 1000000000000000000L;

        while (end > start) {
            long mid = (start + end) / 2;

            if (isValid(mid, n, times)) {
                end = mid;
            } else{
                start = mid + 1;
            }
        }

        return start;
    }

    private boolean isValid(long mid, int n, int[] times) {
        long count = 0;
        for (int time : times) {
            count += mid / time;
        }
        return count >= n;
    }
}
