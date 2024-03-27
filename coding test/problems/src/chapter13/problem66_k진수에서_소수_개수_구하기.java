package chapter13;

public class problem66_k진수에서_소수_개수_구하기 {

    public int solution(int n, int k) {
        String string = Integer.toString(n, k);
        String[] split = string.split("0+");

        int count = 0;

        for (String s : split) {
            if (isPrime(s)) count++;
        }

        return count;
    }

    private static boolean isPrime(String s) {
        long number = Long.parseLong(s);
        if(number <= 1L) return false;

        int sqrt = (int)Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if(number % i == 0) return false;
        }

        /**
         *
         *          Math는 한번만 계산, i*i는 반복되는 횟수 많큼 계산 
         *         for (int i = 2; i * i <= number; i++) {
         *             if(number % i == 0) return false;
         *         }
         */
        return true;
    }
}
