package chapter11.data_stucture.stack_queue;

public class problem44_주식_가격 {
    public static void main(String[] args) {
        System.out.println((solution(new int[]{1, 2, 3, 2, 3})));
    }

    public static int[] solution(int[] prices) {
        int[] count = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                count[i]++;
                if(prices[i] > prices[j]) break;
            }
        }
        return count;
    }
}
