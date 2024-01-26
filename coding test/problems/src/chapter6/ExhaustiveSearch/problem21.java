package chapter6.ExhaustiveSearch;

import java.util.HashSet;
import java.util.Set;

public class problem21 {

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }

    static Set<String> prime = new HashSet<>();
    static boolean[] isUsed;

    public static int solution(String numbers) {
        isUsed = new boolean[numbers.length()];
        recursion("0", numbers.toCharArray());
        int[] answer = prime.stream().mapToInt(Integer::parseInt).distinct().toArray();

        return answer.length;
    }

    private static void recursion(String acc, char[] numbers) {
        if (isPrime(Integer.parseInt(acc))){
            prime.add(acc);
        }

        for (int i = 0; i < numbers.length; i++) {
            if(isUsed[i]) continue;

            String nextAcc = acc + numbers[i];

            isUsed[i] = true;
            recursion(nextAcc, numbers);
            isUsed[i] = false;
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
