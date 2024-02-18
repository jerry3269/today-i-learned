package chapter10.dynamic_programming;

import java.util.Arrays;

public class problem38_피보나치_수 {

    public static void main(String[] args) {
        System.out.println(solution(100000));
    }
    private static final int[] mem = new int[100001];

    public static int solution(int n) {
        Arrays.fill(mem, -1);
        for (int i = 0; i <= n; i++) {
            fibonacci(i);
        }
        return fibonacci(n);
    }

    private static int fibonacci(int n) {
        if(mem[n] != -1) return mem[n];
        if (n == 0 || n == 1) return n;
        return mem[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567;
    }
}
