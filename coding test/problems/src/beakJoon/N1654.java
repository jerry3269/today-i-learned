package beakJoon;

import java.util.Scanner;

class N1654 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();

        long start = 1;
        long end = Integer.MIN_VALUE;
        int[] wires = new int[k];

        for (int i = 0; i < k; i++) {
            wires[i] = sc.nextInt();
            end = Math.max(end, wires[i]);
        }

        long result = 0;

        while (start <= end) {
            int count = 0;
            long mid = (start + end) / 2;


            for (int wire : wires) {
                count += (wire / mid);
            }

            if (count >= n) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.print(result);
    }
}
